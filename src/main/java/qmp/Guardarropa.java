package qmp;

import java.util.ArrayList;
import java.util.List;

public class Guardarropa {
	 
	public String nombre;	 
	private List<Prenda> prendas;
	private Algoritmo algoritmo;
//	private List<Atuendo> atuendos = new ArrayList<Atuendo>();
//	private Usuario usuarioPerteneciente;

//constructor

	public Guardarropa(String nombre) {
		 this.prendas = new ArrayList<Prenda>();
//		 this.usuarioPerteneciente=null;
		 this.setNombre(nombre);
		 }
//metodos getters y setters
	

	public String getNombre() {
	return nombre;

	} 
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

/*	public Usuario getUsuarioPerteneciente() {
		return usuarioPerteneciente;
	}	
	public void setUsuarioPerteneciente(Usuario usuarioPerteneciente) {
		this.usuarioPerteneciente = usuarioPerteneciente;
	}
*/
	
	public List<Prenda> getPrendas() {
		return prendas;
	}
	
//metodos 
	
	public void agregarPrenda(Prenda unaPrenda) {
		this.prendas.add(unaPrenda);
	}


	public Atuendo obtenerAtuendo() {
		Atuendo atuendo= new Atuendo();
		atuendo=algoritmo.originarAtuendoCon(this);
		return atuendo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}//fin 
