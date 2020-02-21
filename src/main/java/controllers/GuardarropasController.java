package controllers;
import repositories.RepositorioGuardarropas;
import repositories.factories.FactoryRepositorioGuardarropas;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import qmp.Guardarropa;
import qmp.Usuario;

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
 List<Guardarropa> guardarropas = this.repo.buscarTodos();
            parametros.put("guardarropas", guardarropas);
            return new ModelAndView(parametros, "guardarropas.hbs");
        
    }

    public ModelAndView mostrar(Request request, Response response){

    	Guardarropa guardarropa = this.repo.buscar(new Integer(request.params("id")));
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("guardarropa", guardarropa);
            return new ModelAndView(parametros, "guardarropa.hbs");
        
    }

    public Response modificar(Request request, Response response){

        
            Guardarropa guardarropa = this.repo.buscar(new Integer(request.params("id")));
            asignarAtributosA(guardarropa, request);
            this.repo.modificar(guardarropa);
            response.redirect("/guardarropas");
            return response;
        
    }

    private void asignarAtributosA(Guardarropa guardarropa, Request request){

        if(request.queryParams("nombre") != null){
            guardarropa.setNombre(request.queryParams("nombre"));
        }
    }

    public ModelAndView crear(Request request, Response response){

        
            Map<String, Object> parametros = new HashMap<>();
            return new ModelAndView(parametros, "guardarropa.hbs");
        
    }

    public Response guardar(Request request, Response response){

        Guardarropa guardarropa = new Guardarropa();
            asignarAtributosA(guardarropa, request);
            this.repo.agregar(guardarropa);
            response.redirect("/guardarropas");
            return response;
        
    }

    public Response eliminar(Request request, Response response){

        
            Guardarropa guardarropa = this.repo.buscar(new Integer(request.params("id")));
            this.repo.eliminar(guardarropa);
            return response;
        
    }
    
   public ModelAndView mostrarTodosXId(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();

         	Usuario usuarioBuscado= request.session().attribute("usuario");
        	System.out.println(usuarioBuscado.getIdUsuario());
            List<Guardarropa> guardarropas = this.repo.buscarTodosXId(usuarioBuscado.getIdUsuario());
            System.out.println(guardarropas);
            parametros.put("guardarropas", guardarropas);
            return new ModelAndView(parametros, "guardarropas.hbs");
        
   }
}
