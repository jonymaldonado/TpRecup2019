package controllers;


import qmp.Usuario;
import repositories.RepositorioUsuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class PrincipalController {
	private Map<String,Object> model=new HashMap<>(); 
	private RepositorioUsuario repo;

	public PrincipalController(){
		
	}
	
	public ModelAndView mostrarPaginaPrincipal(Request req, Response res) {
		ModelAndView vista;
		
		vista= new ModelAndView(model,"ingresar.hbs");

			return vista;

	}
	public ModelAndView bienvenida(Request req, Response res) {
		ModelAndView vista;
		
		vista= new ModelAndView(model,"bienvenido.hbs");
		
		return vista;
		
	}
	
	/*public ModelAndView mostrarPaginaPrincipal(Request req, Response res) {

		ModelAndView vista;
		if(PrincipalController.tieneSessionUsuario(req)) {

			vista= new ModelAndView(model,"inicio.hbs");

			return vista;

		}
		else{
			vista = new ModelAndView(model, "ingresar.hbs");

			return vista;
		}

	}*/
	
	/*public ModelAndView insertarUsuario(Request req, Response res) {
 		ModelAndView insertar= new ModelAndView(model,"usuario_insertar.hbs");
		
		return insertar;
	}*/
	
	/*public ModelAndView ingresarUsuario(Request req, Response res) {

		if(res.body() != null && !res.body().isEmpty()){

			model.clear();
			model.put("mensaje", res.body());

		}
		if(req.session().attribute("usuario") != null){
			Usuario usuarioSession = req.session().attribute("usuario");
			//int idUser=usuarioSession.getId();
			res.redirect("/inicio");
			ModelAndView ingresar = new ModelAndView(model, "/inicio");
			return ingresar;
		}else {
			ModelAndView ingresar = new ModelAndView(model, "ingresar.hbs");
			return ingresar;
		}

	}*/
        //Levo este metodo a UsuarioController
    /*
	public ModelAndView validar(Request req, Response res) {
		ModelAndView validar= new ModelAndView(model,"inicio.hbs");

		return validar;
	}*/
	
	public ModelAndView mostrarEventos(Request req, Response res) {
		ModelAndView ingresar;
		if(this.tieneSessionUsuario(req)) {
			ingresar = new ModelAndView(model, "eventos.hbs");

			return ingresar;
		}else {

			return devolverIngresar();
		}
	}
	
	/*public ModelAndView ingresarUsuario(Request req, Response res) {
 		ModelAndView ingresar= new ModelAndView(model,"usuario_ingreso.hbs");
		
		return ingresar;
	}*/

	public static Boolean tieneSessionUsuario(Request req){

		if(req.session().attribute("usuario") != null){

			return true;

		}else {
			return false;
		}
	}

	public static ModelAndView devolverIngresar(){
		Map<String,Object> model=new HashMap<>();
		ModelAndView ingresar = new ModelAndView(model, "ingresar.hbs");
		return ingresar;
	}
}
