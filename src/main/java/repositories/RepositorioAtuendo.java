package repositories;

import qmp.Atuendo;
import repositories.daos.DAO;

import java.util.List;

public class RepositorioAtuendo extends Repositorio{
	
    private static RepositorioAtuendo instance;

    public static RepositorioAtuendo getInstance(DAO dao) {
        if(instance == null){
            instance = new RepositorioAtuendo(dao);
        }
        return instance;
    }

    private RepositorioAtuendo(DAO dao){
        this.setDao(dao);
    }

    public List<Atuendo> buscarTodos(){
        return this.dao.buscarTodos();
    }
    
    public List<Atuendo> buscarTodosPorId(int id) {
    	return this.dao.buscarTodosPorId(id);
    }
    
    public List<Atuendo> buscarSugeridos(int id) {
    	return this.dao.buscarSugeridos(id);
    }

    public Atuendo buscar(int id){
        return this.dao.buscar(id);
    }
}
