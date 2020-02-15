package qmp;

import java.awt.Color;

import org.junit.Before;

public class Prueba {

	
	
	public static void main(String[] args) {
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
        
         ropaVerano = new Guardarropa("RopaVerano");
      /*  remera1.setG(ropaVerano);
        remera2.setG(ropaVerano);
        pantalon1.setG(ropaVerano);
        pantalon2.setG(ropaVerano);
        zapato1.setG(ropaVerano);
        zapato2.setG(ropaVerano);*/
              

        ropaVerano.agregarPrenda(remera1);
        ropaVerano.agregarPrenda(remera2);
        ropaVerano.agregarPrenda(pantalon1);
        ropaVerano.agregarPrenda(pantalon2);
        ropaVerano.agregarPrenda(zapato1);
        ropaVerano.agregarPrenda(zapato2);
        
        usuarioPrueba=new Usuario("Lucas", "Saclier", "lsaclier", "dds2020", 43, "lsaclier@gmail.com", "1122334455");
        usuarioPrueba.agregarGuardarropa(ropaVerano);
        Algoritmo alg = new Algoritmo();
        
        ropaVerano.setAlgoritmo(alg);
		
        System.out.println(usuarioPrueba.getGuardarropas().getNombre());
     System.out.println(ropaVerano.getPrendas().size());
	}
    	

  

}