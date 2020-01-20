package pojo;

//import prendas.Prenda;

//import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
//@Table(name="Atuendo")

public class Atuendo /*extends EntidadPersistente*/ {

//	@Column(name="Puntaje")
	private int puntaje = 0;
	
//	@ManyToMany (cascade= {CascadeType.ALL,CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE},fetch=FetchType.LAZY)
//	@JoinTable(
	//        name = "Atuendo_Prenda", 
	//	        joinColumns = { @JoinColumn(name = "atuendo_id") },
	//	        inverseJoinColumns = { @JoinColumn(name = "prenda_id")}
	//)
	private List<Prenda> prendas = new ArrayList<Prenda>();
	
	//@ManyToMany(mappedBy = "atuendos", fetch = FetchType.LAZY)
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	// Se deja comentado, recuperar el Guardarropas desde las prendas.

	//@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Guardarropa g;
							
public List<Prenda> getPrendas() {
	return prendas;
}

public void setPrendas(List<Prenda> prendas) {
	this.prendas = prendas;
}

public Guardarropa getG() {
	return g;
}

public void setG(Guardarropa g) {
	this.g = g;
}

public int calcularNivelAbrigo() {
	int acumulador = 0;
	for(Prenda prenda:this.getPrendas()) {
	    acumulador = acumulador + prenda.nivelAbrigo; 
	}
	return acumulador;
}

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

public void agregarP(List<Prenda> prendas) {
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

public Atuendo() {

	}


public int getPuntaje() {
	return puntaje;
}

public void setPuntaje(int puntaje) {
	this.puntaje = puntaje;
}

public void agregarPrenda(Prenda unaPrenda) {
	if (unaPrenda == null) {}
	else {
		prendas.add(unaPrenda);
	}
}

@Override
public String toString() {
	return "Atuendo [" + prendas + "]";
}

}
