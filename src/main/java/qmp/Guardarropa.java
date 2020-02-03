package qmp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity

public class Guardarropa extends EntidadPersistente{
	 
	@Column(name="nombre")
	public String nombre;	 
	@Transient
	private List<Prenda> prendas;
	@Transient
	private Algoritmo algoritmo;
	@Transient
	private List<Atuendo> atuendos = new ArrayList<Atuendo>();
	@Transient
	private Usuario usuarioPerteneciente;

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
	
	public void setAlgoritmo(Algoritmo algoritmo) {
		this.algoritmo = algoritmo;
	}
	
	public Algoritmo getAlgoritmo() {
		return algoritmo;
	}
	
	
//metodos 
	
	public void agregarPrenda(Prenda unaPrenda) {
		this.prendas.add(unaPrenda);
	}


	public Atuendo obtenerAtuendo() {
		Atuendo atuendo= new Atuendo();
		atuendo=getAlgoritmo().originarAtuendoCon(this);
		return atuendo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}//fin 
