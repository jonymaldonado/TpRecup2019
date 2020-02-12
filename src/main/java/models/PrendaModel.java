package models;

import db.EntityManagerHelper;
import qmp.Atuendo;
import qmp.Prenda;

import java.util.List;

public class PrendaModel extends Model {
    private static PrendaModel instance;

    public static PrendaModel getInstance() {
        if(instance == null){
            instance = new PrendaModel();
        }
        return instance;
    }

	@SuppressWarnings("unchecked")
	@Override
    public List<Prenda> buscarTodos(){
        return EntityManagerHelper.getEntityManager().createQuery("FROM Prenda").getResultList();
    }

    @Override
    public Prenda buscar(int id){
        return EntityManagerHelper.getEntityManager().find(Prenda.class, id);
    }
    
    @Override
    public List<Prenda> buscarTodosPorId(int id){
    	
    	return EntityManagerHelper.getEntityManager().createQuery("SELECT p FROM Atuendo a join a.prendas p where a.id=:id").setParameter("id", id).getResultList();
    }
    
    public List<Prenda> buscarPorGuardarropa(int id){
    	return EntityManagerHelper.getEntityManager().createQuery("SELECT p FROM Guardarropa g join g.prendas p where g.id=:id").setParameter("id", id).getResultList();
       // return EntityManagerHelper.getEntityManager().createQuery("SELECT p FROM Guardarropa g join g.prendas p where g.id=:id").setParameter("id", id).getResultList();
    }

}
