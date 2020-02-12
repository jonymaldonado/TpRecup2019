package models;

import java.util.List;
import db.EntityManagerHelper;
import qmp.Atuendo;

public class AtuendoModel extends Model{
	
    private static AtuendoModel instance;

    public static AtuendoModel getInstance() {
        if(instance == null){
            instance = new AtuendoModel();
        }
        return instance;
    }

    @Override
    public List<Atuendo> buscarTodos(){
    	
        return EntityManagerHelper.getEntityManager().createQuery("from Atuendo").getResultList();
    }

    @Override
    public List<Atuendo> buscarTodosPorId(int id){
    	
        return EntityManagerHelper.getEntityManager().createQuery("SELECT a FROM Guardarropa g join g.atuendosTotales a where g.id=:id").setParameter("id", id).getResultList();
    }
    
    @Override
    public List<Atuendo> buscarSugeridos(int id){
    	
        return EntityManagerHelper.getEntityManager().createQuery("SELECT a FROM Usuario u join u.atuendos a where u.id=:id").setParameter("id", id).getResultList();
    }


    @Override
    public Atuendo buscar(int id){
        return EntityManagerHelper.getEntityManager().find(Atuendo.class, id);
    }
    
}
