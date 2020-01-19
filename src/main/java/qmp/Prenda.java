package qmp;

public class Prenda {
	
	private String nombre;
	private Categoria categoria;
	private String color;
//constructor
	public Prenda(String nombre, Categoria categoria, String color) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.color = color;
	}
	
	
//metodos - geters y seters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
//metodos
	//
}//fin Prenda
