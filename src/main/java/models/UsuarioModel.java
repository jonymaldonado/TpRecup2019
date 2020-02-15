package models;

import db.EntityManagerHelper;
import qmp.Usuario;

import java.util.List;

public class UsuarioModel extends Model {
    private static UsuarioModel instance;

    public static UsuarioModel getInstance() {
        if(instance == null){
            instance = new UsuarioModel();
        }
        return instance;
    }

    @Override
    public List<Usuario> buscarTodos(){
        return EntityManagerHelper.getEntityManager().createQuery("from Usuario").getResultList();
    }

    @SuppressWarnings("unchecked")
	@Override
    public Usuario buscar(int idUsuario){
        return EntityManagerHelper.getEntityManager().find(Usuario.class, idUsuario);
    }

	
//	@Override
	public Usuario consultarYBuscar(String user, String pass) {
		// TODO Auto-generated method stub
       // Usuario usuario = (Usuario) EntityManagerHelper.createQuery("from Usuario where password = :pass and nombreDeUsuario = :user").setParameter("pass",pass).setParameter("user",user).getSingleResult();
        Integer id = (Integer) EntityManagerHelper.createQuery("select idUsuario from Usuario where password = :pass and nombreDeUsuario = :user").setParameter("pass",pass).setParameter("user",user).getSingleResult();
        //Usuario usuario = (Usuario) EntityManagerHelper.createQuery("from Usuario where nombre = 'UsuarioPrueba1'").getSingleResult();
        Usuario usuario = this.buscar(id);
        //return EntityManagerHelper.getEntityManager().find(Usuario.class, 1);

        return usuario;

    }

}
