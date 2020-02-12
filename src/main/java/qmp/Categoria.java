package qmp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Categoria")
public class Categoria {
	@Id
	@GeneratedValue
	@Column(name = "idCategoria")
	private int idCategoria;
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
	
	public int getIdCategoria() {
		return idCategoria;
	}
	
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

}
