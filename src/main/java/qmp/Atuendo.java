package qmp;

//import prendas.Prenda;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Atuendo")

public class Atuendo {
//ATRIBUTOS------------------------------------------------------------------------------

	@Id
	@GeneratedValue
	@Column(name = "idAtuendo")
	private int idAtuendo;
	@ManyToMany (cascade= {CascadeType.ALL,CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE},fetch=FetchType.LAZY)
	@JoinTable(
	       name = "Atuendo_Prenda", 
		        joinColumns = { @JoinColumn(name = "idAtuendo") },
		        inverseJoinColumns = { @JoinColumn(name = "idPrenda")}
	)
	private List<Prenda> prendas = new ArrayList<Prenda>();
	
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "guardarropaCorrespondiente")
	private Guardarropa guardarropaCorrespondiente;
	
	//@ManyToMany(mappedBy = "atuendos", fetch = FetchType.LAZY)
	//private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	// Se deja comentado, recuperar el Guardarropas desde las prendas.

	//@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="guardarropa")
	private Guardarropa guardarropa;
//CONSTRUCTOR --------------------------------------------------------------
	public Atuendo() {

	}

//METODOS - GETTERS Y SETTERS ---------------------------------------------------------------------------------------
	public int getIdAtuendo() {
		return idAtuendo;
	}
	
	public List<Prenda> getPrendas() {
	return prendas;
}

	public void setPrendas(List<Prenda> prendas) {
	this.prendas = prendas;
}

	public Guardarropa getGuardarropa() {
	return guardarropa;
}

	public void setGuardarropa(Guardarropa guardarropa) {
	this.guardarropa = guardarropa;
}
	//METODOS------------------------------------------------------------------
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atuendo other = (Atuendo) obj;
		if (prendas == null) {
			if (other.prendas != null)
				return false;
		} else if (!prendas.equals(other.prendas))
			return false;
		return true;
	}
	
	public void limpiar() {
		prendas.clear();
	}
	
	public void agregarVariasPrendas(List<Prenda> prendas) {
		this.prendas.addAll(prendas);
	}
	
	public boolean compararAtuendo(Atuendo atuendo) {
		
		for (int i = 0; i< atuendo.getPrendas().size();i++) {
			if (this.prendas.contains(atuendo.getPrendas().get(i))) {
				
			}else {
				return false;
			}	
		}
		return true;
	}
	
	public int cantidadDePrendas() {
		int cantidad= 0;
		cantidad= this.getPrendas().size();
		return cantidad;
	}
	
	
	public void agregarPrenda(Prenda unaPrenda) {
		if (unaPrenda == null) {}
		else {
			prendas.add(unaPrenda);
		}
	}
	
	/*@Override
	public String toString() {
		return "Atuendo [" + prendas+ "]";
	}*/
	@Override
	public String toString() {
		for(Prenda prenda: this.getPrendas())
		{
			String nombreDePrenda=null;
			nombreDePrenda=prenda.getNombre();
		    System.out.println(nombreDePrenda);
		    
		}
		return "Atuendo [" + prendas+ "]";
	}
	
	}//FIN ATUENDOS
