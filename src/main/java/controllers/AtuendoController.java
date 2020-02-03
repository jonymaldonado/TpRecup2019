package controllers;

import pojo.Atuendo;
import pojo.Guardarropa;
import pojo.Usuario;
import prendas.Prenda;
import repositories.RepositorioAtuendo;
import repositories.RepositorioGuardarropas;
import repositories.RepositorioPrenda;
import repositories.RepositorioUsuario;
import repositories.factories.FactoryRepositorioAtuendo;
import repositories.factories.FactoryRepositorioGuardarropas;
import repositories.factories.FactoryRepositorioUsuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import administradorEventos.AdministradorEvento;
import algoritmoAleatorio.Algoritmo;
import algoritmoAleatorio.algoritmoTemperatura;
import api.OpenWeatherMap;
import api.apiDelClima;
import db.EntityManagerHelper;

public class AtuendoController {
    private RepositorioAtuendo repo;
    private RepositorioUsuario repoUsuario;
    private RepositorioGuardarropas repoGuardarropa;

    public AtuendoController(){
        this.repo = FactoryRepositorioAtuendo.get();
        this.repoUsuario = FactoryRepositorioUsuario.get();
        this.repoGuardarropa = FactoryRepositorioGuardarropas.get();
    }

    public ModelAndView mostrarTodos(Request request, Response response) throws ParseException {
        ModelAndView vista;
        Map<String, Object> parametros = new HashMap<>();

        if(PrincipalController.tieneSessionUsuario(request)) {
        	apiDelClima unaApiDelClima = new OpenWeatherMap();
        	AdministradorEvento adminEvento = new AdministradorEvento();
        	List<Atuendo> sugerencias = new ArrayList<Atuendo>();
            algoritmoTemperatura unAlgoritmo = new algoritmoTemperatura(unaApiDelClima);
            double tempOPEN = unAlgoritmo.solicitarTemperatura("Buenos Aires","2019-12-22 21:00:00");
            System.out.println(tempOPEN);
            Guardarropa g = this.repoGuardarropa.buscar(new Integer(request.params("id")));
            Algoritmo alg = new Algoritmo();
            g.setAlgoritmo(alg);
        	g.generarTodos();
        	System.out.println(g.getAtuendosTotales());
        	if (tempOPEN != -1) {
        		System.out.println(tempOPEN);
        	EntityManagerHelper.beginTransaction();
            for (int i=0;i<g.getAtuendosTotales().size();i++) {
              	 EntityManagerHelper.getEntityManager().persist(g.atuendosTotales.get(i));
              }
            EntityManagerHelper.commit();
        	} else {
        		sugerencias = adminEvento.FiltrarAtuendosNivelAbrigo(g.atuendosTotales,tempOPEN,18);
        		g.setAtuendosTotales(sugerencias);
        		EntityManagerHelper.beginTransaction();
                for (int i=0;i<g.getAtuendosTotales().size();i++) {
                  	 EntityManagerHelper.getEntityManager().persist(g.atuendosTotales.get(i));
                  }
                EntityManagerHelper.commit();
        	}
        	/*
         	EntityManagerHelper.beginTransaction();
            for (int i=0;i<g.getAtuendosTotales().size();i++) {
              	 EntityManagerHelper.getEntityManager().persist(g.atuendosTotales.get(i));
            }
            EntityManagerHelper.commit();
        	 */
            List<Atuendo> atuendos = this.repo.buscarTodosPorId(new Integer(request.params("id")));
            parametros.put("atuendos", atuendos);
            vista = new ModelAndView(parametros, "atuendos.hbs");
            return vista;
        }
        else{
            vista = new ModelAndView(parametros, "ingresar.hbs");

            return vista;
        }
    }
    
    public ModelAndView mostrarSugeridos(Request request, Response response) {
        ModelAndView vista;
        Map<String, Object> parametros = new HashMap<>();

        if(PrincipalController.tieneSessionUsuario(request)) {
        	Usuario usuarioBuscado= request.session().attribute("usuario");
            List<Atuendo> atuendos = this.repo.buscarSugeridos(usuarioBuscado.getId());
            parametros.put("atuendos", atuendos);
            vista = new ModelAndView(parametros, "sugeridos.hbs");
            return vista;
        }
        else{
            vista = new ModelAndView(parametros, "ingresar.hbs");

            return vista;
        }
    }


    public Response eliminar(Request request, Response response){
    	Atuendo atuendo = this.repo.buscar(new Integer(request.params("id")));
        this.repo.eliminar(atuendo);
        return response;
    }
    
    public Response guardarAtuendo (Request request, Response response) throws ParseException {
    	Atuendo atuendo = this.repo.buscar(new Integer(request.queryParams("id")));
    	atuendo.setPuntaje(new Integer(request.queryParams("puntaje")));
    	this.repo.modificar(atuendo);
    	if(PrincipalController.tieneSessionUsuario(request)) {
			Usuario usuarioBuscado= request.session().attribute("usuario");
			usuarioBuscado.aceptarSugerencia(atuendo);
			this.repoUsuario.modificar(usuarioBuscado);
			response.redirect("/guardarropas");
	        return response;
    	 } else {
    		 System.out.println("Error");
    		 return response;
    	 }
    }
    
    public Response eliminarAtuendo (Request request, Response response) throws ParseException {
    	if(PrincipalController.tieneSessionUsuario(request)) {
    		System.out.println(new Integer(request.queryParams("id")));
			Usuario usuarioBuscado= request.session().attribute("usuario");
			usuarioBuscado.eliminarSugerencia(new Integer(request.queryParams("id")));
			System.out.println(usuarioBuscado.getAtuendos());
			this.repoUsuario.modificar(usuarioBuscado);
			response.redirect("/inicio");
	        return response;
    	 } else {
    		 System.out.println("Error");
    		 return response;
    	 }
    }
}
