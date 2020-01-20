package qmp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Random;

import api.AccuWeather;
import api.OpenWeatherMap;
import api.apiDelClima;
import pojo.Guardarropa;
import prendas.Prenda;
import pojo.Atuendo;


public class Algoritmo {
	
//ATRIBUTOS---------------------------------------
	public int cantidadDeAtuendosPosible;
//CONSTRUCTOR -------------------------------------------
	public Algoritmo () {
		
	}
//METODOS - GETTERS Y SETTERS -------------------------
	
	
	
	
//METODOS -------------------------------------------------
	public Atuendo originarAtuendoCon(Guardarropa guardarropa) {
		//Agrego las prendas a las distintas listas de prendas, luego recorro cada lista y muestro lo que contienen para mostrar el atuendo.

		//double tempOPEN = unAlgoritmo.solicitarTemperatura();
		//double tempACCU = otroAlgoritmo.solicitarTemperatura();
		
		Atuendo atuendoARetornar= new Atuendo();
		
		//int temperaturaOpen = (int) Math.round(tempOPEN);
		//int temperaturaAccu = (int) Math.round(tempACCU);

		atuendoARetornar = obtenerAtuendo(atuendoARetornar,guardarropa.getPrendas());
		return atuendoARetornar;
	}
	
	public Atuendo obtenerAtuendo(Atuendo atuendoARetornar, List <Prenda> prendasPosibles) {
		atuendoARetornar.agregarPrenda(obtenerPrendas(filtrarPrenda(prendasPosibles,"CALZADO")));
		atuendoARetornar.agregarPrenda(obtenerPrendas(filtrarPrenda(prendasPosibles,"SUPERIOR")));
		atuendoARetornar.agregarPrenda(obtenerPrendas(filtrarPrenda(prendasPosibles,"ACCESORIO")));
		atuendoARetornar.agregarPrenda(obtenerPrendas(filtrarPrenda(prendasPosibles,"INFERIOR")));
		return atuendoARetornar;
		
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
	
	
	
	public Prenda obtenerPrenda(List<Prenda> prendas) {
		if (prendas.isEmpty()) {
			return null;
		} else {
		return (Prenda) prendas.get(obtenerAleatorio(prendas.size()));
		}
		}

	public List<Prenda> filtrarPrenda(List<Prenda> prendas, String categoria) {
		return prendas.stream().filter(prenda->prenda.getCategoriaPrenda().getCategoria().contains(categoria)).collect(Collectors.toList());
	}

	public List<Prenda> buscarPrendas(List<Prenda> prendas) {
		return prendas;		
	}

	public int getCantidadDeAtuendosPosible() {
		return cantidadDeAtuendosPosible;
	}

	public void setCantidadDeAtuendosPosible(int cantidadDeAtuendosPosible) {
		this.cantidadDeAtuendosPosible = cantidadDeAtuendosPosible;
	}
	


}//FIN ALGORITMO
