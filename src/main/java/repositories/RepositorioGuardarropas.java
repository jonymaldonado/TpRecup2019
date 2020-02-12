package repositories;

import qmp.Guardarropa;
import repositories.daos.DAO;

import java.util.List;

public class RepositorioGuardarropas extends Repositorio {
    private static RepositorioGuardarropas instance;

    public static RepositorioGuardarropas getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioGuardarropas(dao);
        }
        return instance;
    }

    private RepositorioGuardarropas(DAO dao){
        this.setDao(dao);
    }

    public List<Guardarropa> buscarTodos(){
        return this.dao.buscarTodos();
    }
    
    public List<Guardarropa> buscarTodosXId(int id) {
    	return this.dao.buscarTodosXId(id);
    }

    public Guardarropa buscar(int id){
        return this.dao.buscar(id);
    }
}
