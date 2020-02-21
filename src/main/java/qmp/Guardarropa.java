package qmp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity

public class Guardarropa{
	//atributos---------------------------------------------------------
	
	@Id
	@GeneratedValue
	@Column(name = "idGuardarropa")
	private int idGuardarropa;
	
	@Column(name="nombreGuardarropa")
	public String nombreGuardarropa;	 
	@OneToMany (cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(
		       name = "Guardarropa_Prenda", 
			        joinColumns = { @JoinColumn(name = "idGuardarropa") },
			        inverseJoinColumns = { @JoinColumn(name = "idPrenda")}
		)
	private List<Prenda> prendas;
	@Transient
	private Algoritmo algoritmo;
	 @OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	 @JoinTable(
		       name = "Guardarropa_Atuendo", 
			        joinColumns = { @JoinColumn(name = "idGuardarropa") },
			        inverseJoinColumns = { @JoinColumn(name = "idAtuendo")}
		)
	private List<Atuendo> atuendos = new ArrayList<Atuendo>();
	@Transient
	@OneToOne(mappedBy="guardarropa", fetch = FetchType.LAZY)
	@JoinColumn(name="usuarioPerteneciente")
	
	 private Usuario usuarioPerteneciente;

//constructor---------------------------------------------------------

	public Guardarropa(String nombre) {
		 this.prendas = new ArrayList<Prenda>();
		 this.usuarioPerteneciente=null;
		 this.setNombre(nombre);
		 }
//metodos getters y setters--------------------------------------------------
	

	public Guardarropa() {
		// TODO Apéndice de constructor generado automáticamente
	}


	public String getNombre() {
	return nombreGuardarropa;

	} 
	public void setNombre(String nombre) {
		this.nombreGuardarropa = nombre;
	}

	public Usuario getUsuarioPerteneciente() {
		return usuarioPerteneciente;
	}	
	public void setUsuarioPerteneciente(Usuario usuarioPerteneciente) {
		this.usuarioPerteneciente = usuarioPerteneciente;
	}

	
	public List<Prenda> getPrendas() {
		return prendas;
	}
	
	public void setAlgoritmo(Algoritmo algoritmo) {
		this.algoritmo = algoritmo;
	}
	
	public Algoritmo getAlgoritmo() {
		return algoritmo;
	}
	
	public int getIdGuardarropa() {
		return idGuardarropa;
	}
	
	public void setIdGuardarropa(int idGuardarropa) {
		this.idGuardarropa = idGuardarropa;
	}
	
	
//metodos------------------------------------------
	
	public void agregarPrenda(Prenda unaPrenda) {
		this.prendas.add(unaPrenda);
		unaPrenda.setGuardarropaPerteneciente(this);
	}


	public Atuendo obtenerAtuendo() {
		Atuendo atuendo= new Atuendo();
		atuendo=getAlgoritmo().originarAtuendoCon(this);
		return atuendo;
	}
	
	public void asignarUsuario(Usuario usuario) {
		this.setUsuarioPerteneciente(usuario);
	}
	
	
	
	
	
	
	
	
	
	
	
}//fin 
