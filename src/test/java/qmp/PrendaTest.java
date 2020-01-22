package qmp;


import org.junit.Before;
import org.junit.Test;


import java.awt.*;

import static org.junit.Assert.*;
//import static org.junit.Assume.assumeThat;

public class PrendaTest {


	
	Categoria superior;
	Categoria calzado;
	Categoria inferior;
	
	
	
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
		
		superior=new Categoria("superior");
		inferior=new Categoria("inferior");
		calzado=new Categoria("Calzado");
		

		remera1 = new Prenda("RemeraMangaCorta", superior, "#FFFF00");
		remera2 = new Prenda("RemeraMangaCorta", superior, "#FFFF00");
		pantalon1 = new Prenda("Pantalon Negro Masculino", inferior,"#000000");
		pantalon2 = new Prenda("Pantalon ladrillo Femenino", inferior,"#FF0000");
		zapato1 = new Prenda("Zapato Negro Masculino", calzado,"#800000");
		zapato2 = new Prenda("Zapato Rojo Femenino", calzado,"#FF0000");
		//remera2 = new Prenda("RemeraMangaCorta", superior, "remera", "algodon", "#FFFF00", "#000000", "\\img\\sup\\remeraalgo4");
		//remera2 = new Prenda("RemeraMangaCorta", superior, "remera", "algodon", "#FFFF00", "#000000", "\\img\\sup\\remeraalgo4");

	}
	
	
	@Test
	public void testIgualacionDePrenda() throws Exception {

	assertTrue(remera1.equals(remera2));
	assertEquals(remera1,remera2);
	assertFalse(pantalon1.equals(pantalon2));

	}

    @Test
    public void testCategoria() throws  Exception{

        assertEquals(remera1.getCategoriaPrenda(),superior);

        assertFalse(zapato1.getCategoriaPrenda().equals(inferior));

    }
    
    
}//FIN PRENDATEST
