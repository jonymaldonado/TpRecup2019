package qmp;

public class Prenda {
	
	private String nombre;
	private Categoria categoria;
	private Color color;
//constructor
	public Prenda(String nombre, Categoria categoria, qmp.Color color) {
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
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
//metodos
	//
}//fin Prenda
