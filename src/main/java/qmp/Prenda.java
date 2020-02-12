package qmp;

import java.util.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
	@Entity
	@Table(name="Prenda")
public class Prenda {
	@Id
	@GeneratedValue
	@Column(name = "idPrenda")
	private int idPrenda;
	
	@Column(name = "nombrePrenda")
	private String nombrePrenda;
	@ManyToOne
	//@JoinColumn(name="idCategoria")
	private Categoria categoriaPrenda;
	@Column(name = "colorPrenda")
	private String colorPrenda;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name ="guardarropaPerteneciente")
	private Guardarropa guardarropaPerteneciente;
	@ManyToMany(mappedBy = "prendas", fetch = FetchType.LAZY)
	private List<Atuendo> atuendos = new ArrayList<Atuendo>();
	
//constructor-----------------------------------------------------------------------
	public Prenda(String nombre, Categoria categoria, String color) {
		this.setNombre(nombre);
		this.setCategoriaPrenda(categoria);
		this.setColor(color);
		this.setCategoriaPrenda(null);
		this.setGuardarropaPerteneciente(null);
	}
	
	
public Prenda() {
		// TODO Apéndice de constructor generado automáticamente
	}

	//metodos - geters y seters--------------------------------------------------------

	public String getNombre() {
		return nombrePrenda;
	}
	public void setNombre(String nombre) {
		this.nombrePrenda = nombre;
	}
	public Categoria getCategoriaPrenda() {
		return categoriaPrenda;
	}
	public void setCategoriaPrenda(Categoria categoriaPrenda) {
		this.categoriaPrenda = categoriaPrenda;
	}
	public String getColor() {
		return colorPrenda;
	}
	public void setColor(String color) {
		this.colorPrenda = color;
	}
	
	public void setIdPrenda(int idPrenda) {
		this.idPrenda = idPrenda;
	}
	
	public int getIdPrenda() {
		return idPrenda;
	}
	
	public Guardarropa getGuardarropaPerteneciente() {
		return guardarropaPerteneciente;
	}
	
	public void setGuardarropaPerteneciente(Guardarropa guardarropaPerteneciente) {
		this.guardarropaPerteneciente = guardarropaPerteneciente;
	}
	public List<Atuendo> getAtuendos() {
		return atuendos;
	}
	public void setAtuendos(List<Atuendo> atuendos) {
		this.atuendos = atuendos;
	}
	
//metodos------------------------------------------------------------------
	//
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prenda other = (Prenda) obj;
		if (categoriaPrenda == null) {
			if (other.categoriaPrenda != null)
				return false;
		} else if (!categoriaPrenda.equals(other.categoriaPrenda))
			return false;
		if (colorPrenda == null) {
			if (other.colorPrenda != null)
				return false;
		} else if (!colorPrenda.equals(other.colorPrenda))
			return false;
		if (nombrePrenda == null) {
			if (other.nombrePrenda != null)
				return false;
		} else if (!nombrePrenda.equals(other.nombrePrenda))
			return false;
		return true;
	}

}//fin Prenda
