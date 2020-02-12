package qmp;

import db.EntityManagerHelper;

import java.awt.Color;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class PersistenciaTest {
	
	Categoria superior;
	Categoria calzado;
	Categoria inferior;
	
	Usuario usuarioPrueba;
	
	Prenda remera1;
	Prenda remera2;
	Prenda pantalon1;
	Prenda pantalon2;
	Prenda zapato1;
	Prenda zapato2;

	Color ladrillo;
	Color marron;
	Color amarillo;
	Color negro;
	Color rojo;
	
	Guardarropa ropaVerano;
	Algoritmo a;
	
    @Before
    public void initialize() throws Exception {
    	//categoria
    	superior=new Categoria("superior");
		inferior=new Categoria("inferior");
		calzado=new Categoria("Calzado");
		//prendas
		remera1 = new Prenda("RemeraMangaCorta", superior, "#FFFF00");
		remera2 = new Prenda("RemeraMangaCorta", superior, "#FFFF00");
		pantalon1 = new Prenda("Pantalon Negro Masculino", inferior,"#000000");
		pantalon2 = new Prenda("Pantalon ladrillo Femenino", inferior,"#FF0000");
		zapato1 = new Prenda("Zapato Negro Masculino", calzado,"#800000");
		zapato2 = new Prenda("Zapato Rojo Femenino", calzado,"#FF0000");
		//remera2 = new Prenda("RemeraMangaCorta", superior, "remera", "algodon", "#FFFF00", "#000000", "\\img\\sup\\remeraalgo4");
		//remera2 = new Prenda("RemeraMangaCorta", superior, "remera", "algodon", "#FFFF00", "#000000", "\\img\\sup\\remeraalgo4");
        
        Guardarropa ropaVerano = new Guardarropa("RopaVerano");
      /*  remera1.setG(ropaVerano);
        remera2.setG(ropaVerano);
        pantalon1.setG(ropaVerano);
        pantalon2.setG(ropaVerano);
        zapato1.setG(ropaVerano);
        zapato2.setG(ropaVerano);*/
        //usuarioPrueba.agregarGuardarropa(ropaVerano);      

        ropaVerano.agregarPrenda(remera1);
        ropaVerano.agregarPrenda(remera2);
        ropaVerano.agregarPrenda(pantalon1);
        ropaVerano.agregarPrenda(pantalon2);
        ropaVerano.agregarPrenda(zapato1);
        ropaVerano.agregarPrenda(zapato2);
        
        
        
        Algoritmo alg = new Algoritmo();
        
        ropaVerano.setAlgoritmo(alg);
        //ropaVerano.generarTodos();


        EntityManagerHelper.beginTransaction();
        //persistir guardarropa
        EntityManagerHelper.getEntityManager().persist(ropaVerano);
        //persistir usuario
        EntityManagerHelper.getEntityManager().persist(usuarioPrueba);
        //persistir categoria
        EntityManagerHelper.getEntityManager().persist(superior);
        EntityManagerHelper.getEntityManager().persist(inferior);
        EntityManagerHelper.getEntityManager().persist(calzado);
        //persistir 
        EntityManagerHelper.getEntityManager().persist(remera1);
        EntityManagerHelper.getEntityManager().persist(remera2);
        EntityManagerHelper.getEntityManager().persist(pantalon1);
        EntityManagerHelper.getEntityManager().persist(pantalon1);
        EntityManagerHelper.getEntityManager().persist(zapato1);
        EntityManagerHelper.getEntityManager().persist(zapato2);

        EntityManagerHelper.commit();
        
        /*

     //   EntityManagerHelper.getEntityManager().persist(sensi);
        EntityManagerHelper.getEntityManager().persist(ropaVerano);
     //   EntityManagerHelper.getEntityManager().persist(usuarioPrueba);
       // EntityManagerHelper.getEntityManager().persist(pruebaEvento1);
        EntityManagerHelper.commit();}
   /*     

>>>>>>> 307f129426ccfdff3f03f8c8a942da07fdc3cbc3
    	Guardarropa g = new Guardarropa("Ropa Formal");
    	Usuario usuario = (Usuario) EntityManagerHelper.createQuery("from Usuario where nombre = 'UsuarioPrueba1'").getSingleResult();
    	Evento pruebaEvento = new Evento("Evento Empresa","2019-10-15","09:00:00","Caballito",usuario,g,MENSUAL);
    	usuario.agregarUnEvento(pruebaEvento);
    	EntityManagerHelper.beginTransaction();
    	EntityManagerHelper.getEntityManager().persist(g);
    	EntityManagerHelper.getEntityManager().persist(pruebaEvento);
    	EntityManagerHelper.getEntityManager().merge(usuario);
    	EntityManagerHelper.commit();
	
    	Sensibilidad sensibilidad = (Sensibilidad) EntityManagerHelper.createQuery("from Sensibilidad where nombre = 'Sensibilidades'").getSingleResult();
    	sensibilidad.agregarParteSensible("Manos");
    	EntityManagerHelper.beginTransaction();
    	EntityManagerHelper.getEntityManager().merge(sensibilidad);
    	EntityManagerHelper.commit();

*/
    }

	@Test public void recuperandoDatos() throws Exception {



	Categoria inferior1 = (Categoria) EntityManagerHelper.createQuery("from Categoria where categoria = 'inferior'").getSingleResult();
	Assert.assertEquals(2, inferior1.getIdCategoria());
    Prenda p = (Prenda) EntityManagerHelper.createQuery("from Prenda where nombre = 'Zapas'").getSingleResult();
	Assert.assertEquals(1, p.getIdPrenda());
	Guardarropa g = (Guardarropa) EntityManagerHelper.createQuery("from Guardarropa where nombre = 'RopaVerano'").getSingleResult();
	Assert.assertEquals(1, g.getIdGuardarropa());
	Usuario usu1 = (Usuario) EntityManagerHelper.createQuery("from Usuario where nombre = 'UsuarioPrueba1'").getSingleResult();
	Assert.assertEquals(1, usu1.getIdUsuario());

	}
}
