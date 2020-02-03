package controllers;
import repositories.RepositorioGuardarropas;
import repositories.factories.FactoryRepositorioGuardarropas;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import pojo.Guardarropa;
import pojo.Usuario;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardarropasController {
    private RepositorioGuardarropas repo;

    public GuardarropasController(){
        this.repo = FactoryRepositorioGuardarropas.get();
    }

    public ModelAndView mostrarTodos(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();

        if(PrincipalController.tieneSessionUsuario(request)) {
            List<Guardarropa> guardarropas = this.repo.buscarTodos();
            parametros.put("guardarropas", guardarropas);
            return new ModelAndView(parametros, "guardarropas.hbs");
        }else{
            return PrincipalController.devolverIngresar();
        }
    }

    public ModelAndView mostrar(Request request, Response response){

        if(PrincipalController.tieneSessionUsuario(request)) {
            Guardarropa guardarropa = this.repo.buscar(new Integer(request.params("id")));
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("guardarropa", guardarropa);
            return new ModelAndView(parametros, "guardarropa.hbs");
        }else{
            return PrincipalController.devolverIngresar();
        }
    }

    public Response modificar(Request request, Response response){

        if(PrincipalController.tieneSessionUsuario(request)) {
            Guardarropa guardarropa = this.repo.buscar(new Integer(request.params("id")));
            asignarAtributosA(guardarropa, request);
            this.repo.modificar(guardarropa);
            response.redirect("/guardarropas");
            return response;
        }else{
            response.redirect("/");
            return response;
        }
    }

    private void asignarAtributosA(Guardarropa guardarropa, Request request){

        if(request.queryParams("nombre") != null){
            guardarropa.setNombre(request.queryParams("nombre"));
        }
    }

    public ModelAndView crear(Request request, Response response){

        if(PrincipalController.tieneSessionUsuario(request)) {
            Map<String, Object> parametros = new HashMap<>();
            return new ModelAndView(parametros, "guardarropa.hbs");
        }else{
            return PrincipalController.devolverIngresar();
        }
    }

    public Response guardar(Request request, Response response){

        if(PrincipalController.tieneSessionUsuario(request)) {
            Guardarropa guardarropa = new Guardarropa();
            asignarAtributosA(guardarropa, request);
            this.repo.agregar(guardarropa);
            response.redirect("/guardarropas");
            return response;
        }else{
            response.redirect("/");
            return response;
        }
    }

    public Response eliminar(Request request, Response response){

        if(PrincipalController.tieneSessionUsuario(request)) {
            Guardarropa guardarropa = this.repo.buscar(new Integer(request.params("id")));
            this.repo.eliminar(guardarropa);
            return response;
        }else{
            response.redirect("/");
            return response;
        }
    }
    
    public ModelAndView mostrarTodosXId(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();

        if(PrincipalController.tieneSessionUsuario(request)) {
        	Usuario usuarioBuscado= request.session().attribute("usuario");
        	System.out.println(usuarioBuscado.getId());
            List<Guardarropa> guardarropas = this.repo.buscarTodosXId(usuarioBuscado.getId());
            System.out.println(guardarropas);
            parametros.put("guardarropas", guardarropas);
            return new ModelAndView(parametros, "guardarropas.hbs");
        }else{
            return PrincipalController.devolverIngresar();
        }
    }
}
