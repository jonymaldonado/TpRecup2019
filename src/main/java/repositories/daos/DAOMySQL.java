package repositories.daos;

import models.Model;
import qmp.Prenda;

import java.util.List;

public class DAOMySQL implements DAO {
    private Model model;

    public DAOMySQL(Model model){
        this.model = model;
    }

    @Override
    public <T> List<T> buscarTodos() {
        return this.model.buscarTodos();
    }
    
    @Override
    public <T> List<T> buscarTodosPorId(int id) {
        return this.model.buscarTodosPorId(id);
    }
    
    @Override
    public <T> List<T> buscarTodosXId(int id) {
        return this.model.buscarTodosXId(id);
    }
    
    @Override
    public <T> List<T> buscarSugeridos(int id) {
        return this.model.buscarSugeridos(id);
    }
    
    @Override
    public <T> T buscar(int id) {
        return this.model.buscar(id);
    }

    @Override
    public void agregar(Object unObjeto) {
        this.model.agregar(unObjeto);
    }

    @Override
    public void modificar(Object unObjeto) {
        this.model.modificar(unObjeto);
    }

    @Override
    public void eliminar(Object unObjeto) {
        this.model.eliminar(unObjeto);
    }
    
    @Override
    public <T> List<T> buscarPorGuardarropa(int id) {
        return this.model.buscarPorGuardarropa(id);
    }
}
