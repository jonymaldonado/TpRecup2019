package qmp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Categoria")
public class Categoria extends EntidadPersistente{
	
	@Transient
	//@Column(name = "nombreCategoria")
	private String nombreCategoria;

	public Categoria(String nombreCategoria) {
		
		this.nombreCategoria = nombreCategoria;
	}
	
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	
	public void setNombraCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

}
