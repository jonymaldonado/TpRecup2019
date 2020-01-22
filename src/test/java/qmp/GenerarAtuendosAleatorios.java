package qmp;

import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class GenerarAtuendosAleatorios{
	
	static Guardarropa guardarropa;
	static List<Prenda> resultadoObtenido;
	
	public boolean ComparadorAtuendo(List<Prenda> lista1, List<Prenda> lista2) {
		int i;
		boolean flag = true;
		for (i = 0; i< lista1.size();i++) {
			if (lista2.contains(lista1.get(i))) {
				
			}else {
				flag = false;
			}	
		}
		return flag;
	}
	
	@BeforeClass
	public static void GeneradorAtuendoAleatorio() throws Exception {
		Categoria calzado = new Categoria ("CALZADO");
		Categoria inferior = new Categoria ("INFERIOR");
		Categoria superior = new Categoria ("SUPERIOR");
		
		Prenda zapato=new Prenda("ZapatoVestir",calzado, "FFFFFF");
		Prenda zapatilla=new Prenda("ZapatillaCasual",calzado, "#FF0000");
		Prenda bermuda=new Prenda("Bermuda",inferior,"#008000");
		Prenda jeans=new Prenda("Jeans",inferior,"#0000FF");
		Prenda remera=new Prenda("RemeraRolinga",superior,"00FF00");
		Prenda camisa=new Prenda("CamisaMangaCorta",superior,"#808080");
		
		
		guardarropa = new Guardarropa("Ropa Verano");
		
		guardarropa.agregarPrenda(zapato); //posicion 0
		guardarropa.agregarPrenda(zapatilla); //posicion 1
		guardarropa.agregarPrenda(bermuda); //posicion 2
		guardarropa.agregarPrenda(jeans); //posicion 3
		guardarropa.agregarPrenda(remera); //posicion 4
		guardarropa.agregarPrenda(camisa); //posicion 5
		
		Algoritmo algoritmo = new Algoritmo();
		guardarropa.setAlgoritmo(algoritmo);
		Atuendo atuendogenerado = guardarropa.getAlgoritmo().originarAtuendoCon(guardarropa);
		resultadoObtenido = atuendogenerado.getPrendas();
	
	}
	
	@Test
	public void Combinacion_1() {

		List<Prenda> resultadoEsperado = new ArrayList<Prenda>();
		resultadoEsperado.add(guardarropa.getPrendas().get(0)); //calzado
		resultadoEsperado.add(guardarropa.getPrendas().get(2)); //inferior
		resultadoEsperado.add(guardarropa.getPrendas().get(4)); //superior
		resultadoEsperado.add(guardarropa.getPrendas().get(5)); //accesorio
				
		boolean resultado = ComparadorAtuendo(resultadoObtenido, resultadoEsperado);
		assertTrue(resultado);
	}
	
	@Test
	public void Combinacion_2() {
		
		
		List<Prenda> resultadoEsperado = new ArrayList<Prenda>();
		resultadoEsperado.add(guardarropa.getPrendas().get(1));
		resultadoEsperado.add(guardarropa.getPrendas().get(2));
		resultadoEsperado.add(guardarropa.getPrendas().get(4));
		resultadoEsperado.add(guardarropa.getPrendas().get(5));
				
		boolean resultado = ComparadorAtuendo(resultadoObtenido, resultadoEsperado);
		assertTrue(resultado);
	}
	
	@Test
	public void Combinacion_3() {
		
		
		List<Prenda> resultadoEsperado = new ArrayList<Prenda>();
		resultadoEsperado.add(guardarropa.getPrendas().get(0));
		resultadoEsperado.add(guardarropa.getPrendas().get(3));
		resultadoEsperado.add(guardarropa.getPrendas().get(4));
		resultadoEsperado.add(guardarropa.getPrendas().get(5));
				
		boolean resultado = ComparadorAtuendo(resultadoObtenido, resultadoEsperado);
		assertTrue(resultado);
	}
	
	@Test
	public void Combinacion_4() {
		
		
		List<Prenda> resultadoEsperado = new ArrayList<Prenda>();
		resultadoEsperado.add(guardarropa.getPrendas().get(1));
		resultadoEsperado.add(guardarropa.getPrendas().get(3));
		resultadoEsperado.add(guardarropa.getPrendas().get(4));
		resultadoEsperado.add(guardarropa.getPrendas().get(5));
		
		boolean resultado = ComparadorAtuendo(resultadoObtenido, resultadoEsperado);
		assertTrue(resultado);
	}
	
}
