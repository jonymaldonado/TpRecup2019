package qmp;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import db.EntityManagerHelper;

public class AgregarPrendaTest {
	Categoria superior;
	Prenda campera;

	

	@Test
	public void testAgregarUnaPrenda() throws Exception {
		campera = new Prenda("CamperaJeans", superior,"#FF0000");
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.persist(campera);		
		EntityManagerHelper.commit();
		
	Prenda p = (Prenda) EntityManagerHelper.createQuery("from Prenda where nombrePrenda = 'CamperaJeans'").getSingleResult();
		Assert.assertEquals(12, p.getIdPrenda());	
		
	}

}
