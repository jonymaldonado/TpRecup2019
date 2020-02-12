package models;

import db.EntityManagerHelper;
import qmp.Guardarropa;

import java.util.List;

public class GuardarropasModel extends Model {
    private static GuardarropasModel instance;

    public static GuardarropasModel getInstance() {
        if(instance == null){
            instance = new GuardarropasModel();
        }
        return instance;
    }

    @Override
    public List<Guardarropa> buscarTodos(){
        return EntityManagerHelper.getEntityManager().createQuery("from Guardarropa").getResultList();
    }
    
    @Override
    public List<Guardarropa> buscarTodosXId(int id){
    	System.out.println(id);
        return EntityManagerHelper.getEntityManager().createQuery("SELECT g FROM Usuario u join u.guardarropas g where u.id=:id").setParameter("id", id).getResultList();
    }

    @Override
    public Guardarropa buscar(int id){
        return EntityManagerHelper.getEntityManager().find(Guardarropa.class, id);
    }
    
}
