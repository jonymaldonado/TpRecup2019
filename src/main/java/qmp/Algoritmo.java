package qmp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Random;



public class Algoritmo {
	
//ATRIBUTOS---------------------------------------
	
//CONSTRUCTOR -------------------------------------------
	public Algoritmo () {
		
	}
//METODOS - GETTERS Y SETTERS -------------------------

	
	
//METODOS -------------------------------------------------
	//paso 1
	public Atuendo originarAtuendoCon(Guardarropa guardarropa) {
		//Agrego las prendas a las distintas listas de prendas, luego recorro cada lista y muestro lo que contienen para mostrar el atuendo.


		Atuendo atuendoARetornar= new Atuendo();
		

		atuendoARetornar = obtenerAtuendo(atuendoARetornar,guardarropa.getPrendas());
		return atuendoARetornar;
	}
	
	
	//paso 2
	public Atuendo obtenerAtuendo(Atuendo atuendoARetornar, List <Prenda> prendasPosibles) {
		List<Prenda> prendasSuperior=new ArrayList<Prenda>();
		List<Prenda> prendasInferior=new ArrayList<Prenda>();
		List<Prenda> prendasCalzado=new ArrayList<Prenda>();
		
		prendasSuperior=filtrarPrenda(prendasPosibles,"SUPERIOR");
		prendasInferior=filtrarPrenda(prendasPosibles,"INFERIOR");
		prendasCalzado=filtrarPrenda(prendasPosibles,"CALZADO");
		

		atuendoARetornar=agregarPrendaAAtuendo(atuendoARetornar, obtenerPrenda(prendasSuperior));
		atuendoARetornar=agregarPrendaAAtuendo(atuendoARetornar, obtenerPrenda(prendasInferior));
		atuendoARetornar=agregarPrendaAAtuendo(atuendoARetornar, obtenerPrenda(prendasCalzado));
		
		
		return atuendoARetornar;
	}
	
	public Atuendo agregarPrendaAAtuendo(Atuendo unAtuendo,Prenda unaPrenda) {
		
		unAtuendo.agregarPrenda(unaPrenda);
		return unAtuendo;
	}
	
	public Prenda obtenerPrenda(List<Prenda> prendas) {
		if (prendas.isEmpty()) {
			return null;
		} else {
			return (Prenda) prendas.get(obtenerAleatorio(prendas.size()));
			}
		}

	public List<Prenda> filtrarPrenda(List<Prenda> prendas, String categoria) {
		return prendas.stream().filter(prenda->prenda.getCategoriaPrenda().getNombreCategoria().contains(categoria)).collect(Collectors.toList());
	}

	

	
	public int obtenerAleatorio(int tamanio) {
		int numero = (int)(Math.random()*tamanio);
		return numero;
	}
	
	

}//FIN ALGORITMO
