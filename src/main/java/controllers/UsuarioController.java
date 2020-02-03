package controllers;

import pojo.Usuario;
import repositories.RepositorioUsuario;
import repositories.factories.FactoryRepositorioUsuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import pojo.Guardarropa;
//import repositories.RepositorioGuardarropa;

public class UsuarioController {
	private RepositorioUsuario repo;
//	private RepositorioGuardarropa repoGuardarropa;
	
	public UsuarioController() {
		this.repo= FactoryRepositorioUsuario.get();
	}
	
	public ModelAndView mostrartodos(Request request,Response response) {
		
 		List<Usuario> usuarios = this.repo.buscarTodos();
 		Map<String, Object> parametros= new HashMap<>();
 		parametros.put("usuarios", usuarios);
 		ModelAndView vista= new ModelAndView(parametros, "usuarios.hbs");
		return vista;
		}
	
public ModelAndView mostrar(Request request,Response response) {

	    //int idUsers=new Integer(request.params("id"));
		//Usuario usuarioBuscado=this.repo.buscar(idUsers);
        Usuario usuarioBuscado= request.session().attribute("usuario");

		Map<String, Object> parametros= new HashMap<>();
		parametros.put("usuario", usuarioBuscado);
		parametros.put("id", usuarioBuscado.getId());
		
 		ModelAndView vista= new ModelAndView(parametros, "usuario.hbs");
		
		return vista;
	}
	public Response modificar(Request request,Response response) {
		
		int id=new Integer(request.params("id"));
		Usuario usuarioBuscado=this.repo.buscar(id);

        asignarAtributosA(usuarioBuscado,request);
		//String nombre=request.queryParams("nombre");
		//usuarioBuscado.setNombre(nombre);
		
		
		//String telefonoString=request.queryParams("telefono");
		//if (!telefonoString.isEmpty()) {
			//int telefono = new Integer(telefonoString);
		//	usuarioBuscado.setCelular(telefonoString);
		//}
		this.repo.modificar(usuarioBuscado);
		request.session().attribute("usuario",usuarioBuscado);
		response.redirect("/usuario");
        return response;

	}
	private void asignarAtributosA(Usuario usuario, Request request){

	    if(request.queryParams("celular") != null){
            usuario.setCelular(request.queryParams("celular"));
        }

        if(request.queryParams("nombre") != null){
            usuario.setNombre(request.queryParams("nombre"));
        }

        if(request.queryParams("correo") != null){
            usuario.setCorreo(request.queryParams("correo"));
        }

        if(request.queryParams("nombreDeUsuario") != null){
            usuario.setNombreDeUsuario(request.queryParams("nombreDeUsuario"));
        }
        if(request.queryParams("password") != null){
            usuario.setPassword(request.queryParams("password"));
        }

    }

    public Response guardar(Request request, Response response){
        Usuario usuario = new Usuario();
        asignarAtributosA(usuario, request);
        this.repo.agregar(usuario);
        request.session().attribute("usuario",usuario);
        response.redirect("/usuarios");
        return response;
    }

    public Response eliminar(Request request, Response response){

        if(PrincipalController.tieneSessionUsuario(request)) {
            Usuario usuario = this.repo.buscar(new Integer(request.params("id")));
            this.repo.eliminar(usuario);
            response.redirect("/usuarios");
            return response;
        }else{
            response.redirect("/");
            return response;

        }
    }


	/*public ModelAndView mostrarGuardarropa(Request request,Response response) {
			
	 		List<Guardarropa> guardarropa = this.repoGuardarropa.buscarTodos();
	 		Map<String, Object> parametros= new HashMap<>();
	 		parametros.put("guardarropa", guardarropa);
	 		ModelAndView vista= new ModelAndView(parametros, "guardarropa.hbs");
			return vista;
			}*/
	//public ModelAndView validarUsuario(Request req, Response res)throws IOException {

   /* public Response validarSession(Request req, Response res)throws IOException {


    }*/
    public ModelAndView validarUsuario(Request req, Response res)throws IOException {
			Map<String, Object> model = new HashMap<>();

		try {
            if(req.session().attribute("usuario") != null){
                Usuario usuarioSession = req.session().attribute("usuario");
                int idUser=usuarioSession.getId();
                res.redirect("/inicio");
                //return  res;
                return new ModelAndView(model, "inicio.hbs");

            }else {
                String usuario = req.queryParams("usuario");
                String contrasenia = req.queryParams("clave");
                Usuario usuariobase = repo.consultarYBuscar(usuario, contrasenia);


                Session session = req.session(true);
                session.attribute("usuario", usuariobase);
                //session.maxInactiveInterval(1800);//30 Min en Segundos

                model.clear();
                model.put("usuario", usuariobase);
                int idUsers = usuariobase.getId();
                //res.redirect("/usuario/" + idUsers);
                res.redirect("/inicio");
                //return res;
                return new ModelAndView(model, "inicio.hbs");
                //return new ModelAndView(model, "inicio.hbs");

            }

		}
		catch(Exception e){
            String mensaje = "Usuario o Contraseña Incorrectos";
            model.clear();
            model.put("mensaje", mensaje);
		    //res.body("El usuario o la contraseña ingresada no coinciden");
			//res.redirect("/usuario_ingresar");
			//return res;
			ModelAndView vista= new ModelAndView(model, "ingresar.hbs");
			return vista;
		}


	}

	public Response logoutUsuario(Request req,Response res){

        req.session().invalidate();

        res.redirect("/");
        return res;
    }

}
