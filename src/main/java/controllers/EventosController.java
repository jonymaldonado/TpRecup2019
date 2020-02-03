package controllers;

import pojo.Ciudad;
import pojo.Evento;
import pojo.Usuario;
import repositories.RepositorioCiudades;
import repositories.RepositorioEventos;
import repositories.factories.FactoryRepositorioCiudades;
import repositories.factories.FactoryRepositorioEventos;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EventosController {
    private RepositorioEventos repo;

    public EventosController(){
        this.repo = FactoryRepositorioEventos.get();
    }

    public ModelAndView mostrarTodos(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();

        if(PrincipalController.tieneSessionUsuario(request)) {
            List<Evento> eventos = this.repo.buscarTodos();
            parametros.put("eventos", eventos);
            return new ModelAndView(parametros, "eventos.hbs");
        }else{
            return PrincipalController.devolverIngresar();
        }
    }

    public ModelAndView mostrar(Request request, Response response){

        if(PrincipalController.tieneSessionUsuario(request)) {
            Evento evento = this.repo.buscar(new Integer(request.params("id")));
            RepositorioCiudades repoCiudad = FactoryRepositorioCiudades.get();
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("evento", evento);
            parametros.put("ciudades", repoCiudad.buscarTodos());

            return new ModelAndView(parametros, "evento.hbs");
        }else{
            return PrincipalController.devolverIngresar();
        }
    }

    public Response modificar(Request request, Response response){

        if(PrincipalController.tieneSessionUsuario(request)) {
            Evento evento = this.repo.buscar(new Integer(request.params("id")));
            asignarAtributosA(evento, request);
            this.repo.modificar(evento);
            response.redirect("/eventos");
            return response;
        }else{
            response.redirect("/");
            return response;
        }
    }

    private void asignarAtributosA(Evento evento, Request request){

        if(request.queryParams("nombre") != null){
            evento.setNombre(request.queryParams("nombre"));
            evento.setFecha(request.queryParams("fecha"));
            evento.setHora(request.queryParams("hora"));
            //evento.setLugar(request.queryParams(""));
            if(request.queryParams("ciudad") != null){
                RepositorioCiudades repoCiudad = FactoryRepositorioCiudades.get();
                Ciudad unaCiudad = repoCiudad.buscar(new Integer(request.queryParams("ciudad")));
                evento.setLugar(unaCiudad.getNombre());
            }
        }
    }

    public ModelAndView crear(Request request, Response response){

        if(PrincipalController.tieneSessionUsuario(request)) {
            Map<String, Object> parametros = new HashMap<>();
            RepositorioCiudades repoCiudad = FactoryRepositorioCiudades.get();
            parametros.put("ciudades", repoCiudad.buscarTodos());

            return new ModelAndView(parametros, "evento.hbs");
        }else{
            return PrincipalController.devolverIngresar();
        }
    }

    public Response guardar(Request request, Response response){

        if(PrincipalController.tieneSessionUsuario(request)) {
            Evento evento = new Evento();
            asignarAtributosA(evento, request);
            this.repo.agregar(evento);
            response.redirect("/eventos");
            return response;
        }else{
            response.redirect("/");
            return response;
        }
    }

    public Response eliminar(Request request, Response response){

        if(PrincipalController.tieneSessionUsuario(request)) {
            Evento evento = this.repo.buscar(new Integer(request.params("id")));
            this.repo.eliminar(evento);
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
            List<Evento> eventos = this.repo.buscarTodosXId(usuarioBuscado.getId());
            parametros.put("eventos", eventos);
            return new ModelAndView(parametros, "eventos.hbs");
        }else{
            return PrincipalController.devolverIngresar();
        }
    }
}
