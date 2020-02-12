package repositories;

import qmp.Categoria;
import repositories.daos.DAO;

import java.util.List;

public class RepositorioCategoria extends Repositorio {
    private static RepositorioCategoria instance;

    public static RepositorioCategoria getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioCategoria(dao);
        }
        return instance;
    }

    private RepositorioCategoria(DAO dao){
        this.setDao(dao);
    }

    public List<Categoria> buscarTodos(){
        return this.dao.buscarTodos();
    }

    public Categoria buscar(int id){
        return this.dao.buscar(id);
    }
}
