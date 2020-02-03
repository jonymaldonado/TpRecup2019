package controllers;

import pojo.Guardarropa;
import prendas.Categoria;
import prendas.Prenda;
import prendas.TipoPrenda;
import prendas.TipoTela;
import repositories.*;
import repositories.factories.*;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrendaController{
    private RepositorioPrenda repo;

    public PrendaController(){
        this.repo = FactoryRepositorioPrenda.get();
    }

    public ModelAndView mostrarTodos(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();
        if(PrincipalController.tieneSessionUsuario(request)) {
            List<Prenda> prendas = this.repo.buscarTodos();
            parametros.put("prendas", prendas);
            return new ModelAndView(parametros, "prendas.hbs");
        }else {

            return PrincipalController.devolverIngresar();
        }
    }

    public ModelAndView mostrar(Request request, Response response){
        if(PrincipalController.tieneSessionUsuario(request)) {

            Prenda prenda = this.repo.buscar(new Integer(request.params("id")));
            RepositorioCategoria repoCat = FactoryRepositorioCategoria.get();
            RepositorioTipoPrenda repoTP = FactoryRepositorioTipoPrenda.get();
            RepositorioTipoTela repoTela = FactoryRepositorioTipoTela.get();
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("tipoPrenda", repoTP.buscarTodos());
            parametros.put("categoria", repoCat.buscarTodos());
            parametros.put("tipoTela", repoTela.buscarTodos());
            parametros.put("prenda", prenda);
            return new ModelAndView(parametros, "prenda.hbs");
        }else{

            return PrincipalController.devolverIngresar();
        }
    }
    
    public ModelAndView buscarPorGuardarropa(Request request, Response response){
    	Map<String, Object> parametros = new HashMap<>();

        if(PrincipalController.tieneSessionUsuario(request)) {
            RepositorioGuardarropas guardarropas = FactoryRepositorioGuardarropas.get();
            Guardarropa guardarropa = guardarropas.buscar(new Integer(request.params("id")));
            List<Prenda> prendas = this.repo.buscarPorGuardarropa(new Integer(request.params("id")));
            parametros.put("guardarropa", guardarropa);
            parametros.put("prendas", prendas);
            return new ModelAndView(parametros, "prendas.hbs");
        }else{

            return PrincipalController.devolverIngresar();
        }
    }
    
    public ModelAndView crear(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();

        if(PrincipalController.tieneSessionUsuario(request)) {
            RepositorioCategoria repoCat = FactoryRepositorioCategoria.get();
            RepositorioTipoPrenda repoTP = FactoryRepositorioTipoPrenda.get();
            RepositorioTipoTela repoTela = FactoryRepositorioTipoTela.get();
            RepositorioGuardarropas guardarropas = FactoryRepositorioGuardarropas.get();
            Guardarropa guardarropa = guardarropas.buscar(new Integer(request.params("id")));
            parametros.put("guardarropas", guardarropa);
            parametros.put("tipoPrendas", repoTP.buscarTodos());
            parametros.put("categorias", repoCat.buscarTodos());
            parametros.put("tipoTelas", repoTela.buscarTodos());
            return new ModelAndView(parametros, "prenda.hbs");
        }else{

            return PrincipalController.devolverIngresar();
        }

    }
    
    public ModelAndView cargaImagen(Request request, Response response){
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "prenda1.hbs");
    }
    
    public Response guardar(Request request, Response response) throws Exception{

        if(PrincipalController.tieneSessionUsuario(request)) {
            RepositorioGuardarropas guardarropas = FactoryRepositorioGuardarropas.get();
            Guardarropa guardarropa = guardarropas.buscar(new Integer(request.params("id")));
            Prenda prenda = asignarAtributosA(request);
            prenda.setG(guardarropa);
            this.repo.agregar(prenda);
            response.redirect("/prendas/" + (new Integer(request.params("id"))));
            return response;
        }else{
            response.redirect("/");
            return response;
        }
    }
    
    private Prenda asignarAtributosA(Request request) throws Exception{
    	String nombre = null;
    	Categoria unaCat = null;
    	String nomTipoPrenda = null;
    	String nomTipoTela = null;
    	int nivelCapa = 0;
    	int nivelAbrigo = 0;
    	String color1 = null;
    	String color2 = null;
    	String urlImagen = null;
    	
    	if(request.queryParams("nombreDePrenda") != null){
            nombre = new String(request.queryParams("nombreDePrenda"));
        }

        if(request.queryParams("categoria") != null){
            RepositorioCategoria repoCat = FactoryRepositorioCategoria.get();
            unaCat = repoCat.buscar(new Integer(request.queryParams("categoria")));
        }

        if(request.queryParams("tipoPrenda") != null){
            RepositorioTipoPrenda repoTP = FactoryRepositorioTipoPrenda.get();
            TipoPrenda unTipoPrenda = repoTP.buscar(new Integer(request.queryParams("tipoPrenda")));
            nomTipoPrenda = unTipoPrenda.getTipoPrenda();
        }

        if(request.queryParams("tipoTela") != null){
            RepositorioTipoTela repoTT = FactoryRepositorioTipoTela.get();
            TipoTela unTipoTela = repoTT.buscar(new Integer(request.queryParams("tipoTela")));
            nomTipoTela = unTipoTela.getNombreTela();
        }

        if(request.queryParams("nivelCapa") != null){
            nivelCapa = new Integer((request.queryParams("nivelCapa")));
        }

        if(request.queryParams("abrigo") != null){
            nivelAbrigo = new Integer(request.queryParams("abrigo"));
        }
        
        if(request.queryParams("colorPrimario") != null){
            color1 = request.queryParams("colorPrimario");
        }
        
        if(request.queryParams("colorSecundario") != null){
            color2 = request.queryParams("colorSecundario");
        }
        
        if(request.queryParams("pathImagen") != null){
            Prenda prenda = new Prenda();
            urlImagen = request.queryParams("pathImagen");
            urlImagen = prenda.normalizarImagen(urlImagen);
        }
        
        
        Prenda prenda = new Prenda(nombre,unaCat,nomTipoPrenda,nomTipoTela,color1,color2,urlImagen,nivelCapa,nivelAbrigo);
        prenda.normalizarImagen(urlImagen);
        return prenda;
    }
    
    private void asignarAtributosA(Prenda prenda, Request request){
    	if(request.queryParams("nombreDePrenda") != null){
           prenda.setNombre((request.queryParams("nombreDePrenda")));
        }

        if(request.queryParams("categoria") != null){
            RepositorioCategoria repoCat = FactoryRepositorioCategoria.get();
            Categoria unaCat = repoCat.buscar(new Integer(request.queryParams("categoria")));
            prenda.setCategoriaPrenda(unaCat);
        }

        if(request.queryParams("tipoPrenda") != null){
            RepositorioTipoPrenda repoTP = FactoryRepositorioTipoPrenda.get();
            TipoPrenda unTipoPrenda = repoTP.buscar(new Integer(request.queryParams("tipoPrenda")));
            prenda.setTipoPrenda(unTipoPrenda.getTipoPrenda());
        }

        if(request.queryParams("tipoTela") != null){
            RepositorioTipoTela repoTT = FactoryRepositorioTipoTela.get();
            TipoTela unTipoTela = repoTT.buscar(new Integer(request.queryParams("tipoTela")));
            prenda.setTipoDeTela(unTipoTela.getNombreTela());
        }
        
        if(request.queryParams("colorPrimario") != null){
            prenda.setColorPrimario(request.queryParams("colorPrimario"));
        }
        
        if(request.queryParams("colorSecundario") != null){
            prenda.setColorSecundario(request.queryParams("colorSecundario"));
        }

        if(request.queryParams("pathImagen")!= null){
            String path = request.queryParams("pathImagen");
            path = prenda.normalizarImagen(path);
            prenda.setUrlImagen(path);
        }
    }
    

    public Response modificar(Request request, Response response){
        Prenda prenda = this.repo.buscar(new Integer(request.params("id")));
        int guardarropa = prenda.getG().getId();
        asignarAtributosA(prenda, request);
        this.repo.modificar(prenda);
        response.redirect("/prendas/" + guardarropa);
        return response;
    }


    public Response eliminar(Request request, Response response){

        if(PrincipalController.tieneSessionUsuario(request)) {
            Prenda prenda = this.repo.buscar(new Integer(request.params("id")));
            this.repo.eliminar(prenda);
            return response;
        }else{
            response.redirect("/");
            return response;
        }


    }
    


}
