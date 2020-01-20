package qmp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Random;



public class Algoritmo {
	
//ATRIBUTOS---------------------------------------
	//public int cantidadDeAtuendosPosible;
//CONSTRUCTOR -------------------------------------------
	public Algoritmo () {
		
	}
//METODOS - GETTERS Y SETTERS -------------------------

	/*
	public int getCantidadDeAtuendosPosible() {
		return cantidadDeAtuendosPosible;
	}

	public void setCantidadDeAtuendosPosible(int cantidadDeAtuendosPosible) {
		this.cantidadDeAtuendosPosible = cantidadDeAtuendosPosible;
	}
	*/
	
//METODOS -------------------------------------------------
	//paso 1
	public Atuendo originarAtuendoCon(Guardarropa guardarropa) {
		//Agrego las prendas a las distintas listas de prendas, luego recorro cada lista y muestro lo que contienen para mostrar el atuendo.


		Atuendo atuendoARetornar= new Atuendo();
		

		atuendoARetornar = obtenerAtuendo(atuendoARetornar,guardarropa.getPrendas());
		return atuendoARetornar;
	}
	
	/*Decido poner este metodo en comentado ya que en el otro delego un poco más
	 
	public Atuendo obtenerAtuendo(Atuendo atuendoARetornar, List <Prenda> prendasPosibles) {
		atuendoARetornar.agregarPrenda(obtenerPrenda(filtrarPrenda(prendasPosibles,"CALZADO")));
		atuendoARetornar.agregarPrenda(obtenerPrenda(filtrarPrenda(prendasPosibles,"SUPERIOR")));
		atuendoARetornar.agregarPrenda(obtenerPrenda(filtrarPrenda(prendasPosibles,"ACCESORIO")));
		atuendoARetornar.agregarPrenda(obtenerPrenda(filtrarPrenda(prendasPosibles,"INFERIOR")));
		return atuendoARetornar;
	}*/
	//paso 2
	public Atuendo obtenerAtuendo(Atuendo atuendoARetornar, List <Prenda> prendasPosibles) {
		List<Prenda> prendasSuperior=new ArrayList<Prenda>();
		List<Prenda> prendasInferior=new ArrayList<Prenda>();
		List<Prenda> prendasCalzado=new ArrayList<Prenda>();
		
		prendasSuperior=filtrarPrenda(prendasPosibles,"SUPERIOR");
		prendasInferior=filtrarPrenda(prendasPosibles,"SUPERIOR");
		prendasCalzado=filtrarPrenda(prendasPosibles,"CALZADO");
		
			
//		atuendoARetornar.agregarPrenda();
//		atuendoARetornar.agregarPrenda());
//		atuendoARetornar.agregarPrenda());
		
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
		return prendas.stream().filter(prenda->prenda.getCategoriaPrenda().contains(categoria)).collect(Collectors.toList());
	}

	
	public int aleatorioFunc(int t) {
    Random generadorAleatorios = new Random();
    //genera un numero entre 1 y 5 y lo guarda en la variable numeroAleatorio
    int numeroAleatorio = 1+generadorAleatorios.nextInt(t);
    return numeroAleatorio;
	}
	
	public int obtenerAleatorio(int tamanio) {
		int numero = (int)(Math.random()*tamanio);
		return numero;
	}
	public int obtenerAleatorioSinRes() {
		int numero = (int)(Math.random());
		return numero;
	}
	/* public List<Prenda> obtenerPrendas(List <Prenda> prendas) {
		List <Prenda> listaAObtener = new ArrayList <Prenda> ();
		int capasMaxima;
		if (capasMax==1 || prendas.size()==1) {
		capasMaxima=1;
		}else {
				capasMaxima = aleatorioFunc(buscarMaximo(prendas));   //Valor aleatorio para determinar la cantidad de capas que tendra este atuendo en particular
			}
		int nivelCapa=1;
		do  {
			Prenda p = prendas.get(obtenerAleatorio(prendas.size()));
			if (p.nivelCapa==nivelCapa) {
				listaAObtener.add(p);
				nivelCapa++;
			}
		} while (nivelCapa<(capasMaxima+1));
			
		return listaAObtener;
	}*/
	
	
	

	public List<Prenda> buscarPrendas(List<Prenda> prendas) {
		return prendas;		
	}

	


}//FIN ALGORITMO
