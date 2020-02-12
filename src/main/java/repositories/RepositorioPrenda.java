package repositories;

import qmp.Prenda;
import repositories.daos.DAO;

import java.util.List;

public class RepositorioPrenda extends Repositorio {
    private static RepositorioPrenda instance;

    public static RepositorioPrenda getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioPrenda(dao);
        }
        return instance;
    }

    private RepositorioPrenda(DAO dao){
        this.setDao(dao);
    }

    public List<Prenda> buscarTodos(){
        return this.dao.buscarTodos();
    }
    
    public List<Prenda> buscarTodosPorId(int id){
        return this.dao.buscarTodosPorId(id);
    }

    public Prenda buscar(int id){
        return this.dao.buscar(id);
    }
    
    public List<Prenda> buscarPorGuardarropa(int id){
        return this.dao.buscarPorGuardarropa(id);
    }
}
