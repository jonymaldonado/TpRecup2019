package qmp;

public class Prenda {
	
	private String nombre;
	private String categoriaPrenda;
	private String color;
//constructor
	public Prenda(String nombre, String categoria, String color) {
		this.nombre = nombre;
		this.categoriaPrenda = categoria;
		this.color = color;
	}
	
	
public Prenda() {
		// TODO Apéndice de constructor generado automáticamente
	}


	//metodos - geters y seters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoriaPrenda() {
		return categoriaPrenda;
	}
	public void setCategoriaPrenda(String categoriaPrenda) {
		this.categoriaPrenda = categoriaPrenda;
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
