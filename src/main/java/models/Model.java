package models;

import db.EntityManagerHelper;
import qmp.Prenda;

import java.util.List;

public abstract class Model {
    public void agregar(Object object){
        EntityManagerHelper.getEntityManager().getTransaction().begin();
        EntityManagerHelper.getEntityManager().persist(object);
        EntityManagerHelper.getEntityManager().getTransaction().commit();
    }

    public void modificar(Object object){
        EntityManagerHelper.getEntityManager().getTransaction().begin();
        EntityManagerHelper.getEntityManager().merge(object);
        EntityManagerHelper.getEntityManager().getTransaction().commit();
    }

    public void eliminar(Object object){
        EntityManagerHelper.getEntityManager().getTransaction().begin();
        EntityManagerHelper.getEntityManager().remove(object);
        EntityManagerHelper.getEntityManager().getTransaction().commit();
    }

    public abstract <T> List<T> buscarTodos();
    
    public <T> List<T> buscarTodosPorId(int id) {
    	return null;
    }
    
    
    public <T> List<T> buscarTodosXId(int id) {
    	return null;
    }
    
    public <T> List<T> buscarSugeridos(int id) {
    	return null;
    }

    public abstract <T> T buscar(int id);
/*    public abstract <T> T consultarYBuscar(String user, String pass);
*/

	public <T> List<T> buscarPorGuardarropa(int id) {
		return null;
    }
}
