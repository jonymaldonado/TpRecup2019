package server;

import controllers.*;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.BooleanHelper;
import spark.utils.HandlebarsTemplateEngineBuilder;

//import controllers.UsuarioController;
//import models.UsuarioModel;
//import repositories.daos.DAOMySQL;

public class Router {
    private static HandlebarsTemplateEngine engine;

    private static void initEngine() {
        Router.engine = HandlebarsTemplateEngineBuilder
                .create()
                .withDefaultHelpers()
                .withHelper("isTrue", BooleanHelper.isTrue)
                .build();
    }

    public static void init() {
        Router.initEngine();
        Spark.staticFileLocation("/public");
        Router.configure();
    }

    private static void configure(){
    	PrendaController prendaController = new PrendaController();
        GuardarropasController guardarropaController = new GuardarropasController();
    	UsuarioController usuarioController= new UsuarioController();
    	PrincipalController paginaController= new PrincipalController();
    	AtuendoController atuendoController = new AtuendoController();

        Spark.get("/", paginaController::mostrarPaginaPrincipal, Router.engine);

     	Spark.get("/prendas", prendaController::mostrarTodos,Router.engine);
    	Spark.get("/prendas/:id", prendaController::buscarPorGuardarropa,Router.engine);
    	Spark.get("/mostrarPrenda/:id", prendaController::mostrar, Router.engine);
    	//Spark.post("/modificarPrenda/:id",prendaController::modificar);
    	Spark.get("/prenda/:id", prendaController::crear, Router.engine);
    //	Spark.post("/prenda/:id", prendaController::guardar);
        Spark.delete("prendas/prenda/:id", prendaController::eliminar);


        Spark.get("/guardarropas", guardarropaController::mostrarTodosXId, Router.engine);
        Spark.get("/guardarropa", guardarropaController::mostrar, Router.engine);
        Spark.get("/guardarropa", guardarropaController::crear, Router.engine);
        Spark.post("/guardarropa/:id", guardarropaController::modificar);
        Spark.post("/guardarropa", guardarropaController::guardar);
        Spark.delete("/guardarropa/:id", guardarropaController::eliminar);



        Spark.delete("/usuario/:idUsuario", usuarioController::eliminar);

        Spark.get("/usuario", usuarioController::mostrar, Router.engine);
        //Spark.get("/usuario/:id", usuarioController::modificar);
        Spark.post("/usuario/:id", usuarioController::modificar);

        Spark.post("/usuario", usuarioController::guardar);

        Spark.delete("/usuario/:id", usuarioController::eliminar);
        
        Spark.get("/usuarios", usuarioController::mostrartodos,Router.engine);

        Spark.get("/usuario_insertar", paginaController::insertarUsuario,Router.engine);

       // Spark.get("/usuario_ingresar", paginaController::ingresarUsuario,Router.engine);

        Spark.get("/usuarios/validar", usuarioController::validarUsuario,Router.engine);
        
    //    Spark.get("/eventos", paginaController::mostrarEventos, Router.engine);

    //    Spark.get("/atuendos/:id", atuendoController::mostrarTodos, Router.engine);
    //    Spark.get("/atuendosSugeridos", atuendoController::mostrarSugeridos, Router.engine);
    //    Spark.post("/atuendos", atuendoController::guardarAtuendo);
    //    Spark.post("/eliminarAtuendo", atuendoController::eliminarAtuendo);

        Spark.get("/logout", usuarioController::logoutUsuario);
        Spark.get("/inicio", paginaController::bienvenida,Router.engine);

        
    }
}
