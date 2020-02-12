package models;

import db.EntityManagerHelper;
import qmp.Categoria;


import java.util.List;

public class CategoriaModel extends Model {
    private static CategoriaModel instance;

    public static CategoriaModel getInstance() {
        if(instance == null){
            instance = new CategoriaModel();
        }
        return instance;
    }

	@Override
    public List<Categoria> buscarTodos(){
        return EntityManagerHelper.getEntityManager().createQuery("from Categoria").getResultList();
    }

    @Override
    public Categoria buscar(int id){
        return EntityManagerHelper.getEntityManager().find(Categoria.class, id);
    }

}
