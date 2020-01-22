package qmp;



public class Prenda {
	
	private String nombre;
	private Categoria categoriaPrenda;
	private String color;
//constructor
	public Prenda(String nombre, Categoria categoria, String color) {
		this.setNombre(nombre);
		this.setCategoriaPrenda(categoria);
		this.setColor(color);
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
	public Categoria getCategoriaPrenda() {
		return categoriaPrenda;
	}
	public void setCategoriaPrenda(Categoria categoriaPrenda) {
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
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}//fin Prenda
