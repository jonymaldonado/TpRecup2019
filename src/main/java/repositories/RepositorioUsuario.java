package repositories;

import models.UsuarioModel;
import qmp.Usuario;
import repositories.daos.DAO;

import java.util.List;

public class RepositorioUsuario extends Repositorio {
    private static RepositorioUsuario instance;

    public static RepositorioUsuario getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioUsuario(dao);
        }
        return instance;
    }

    private RepositorioUsuario(DAO dao){
        this.setDao(dao);
    }

    public List<Usuario> buscarTodos(){
        return this.dao.buscarTodos();
    }

    public Usuario buscar(int id){
        return this.dao.buscar(id);
    }
    
   public Usuario consultarYBuscar(String user, String pass) {
    	//return this.dao.consultarYBuscar(user,pass);
       UsuarioModel usuario = new UsuarioModel();
       return usuario.consultarYBuscar(user,pass);
    }
}
