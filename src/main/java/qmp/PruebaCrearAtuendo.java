package qmp;

public class PruebaCrearAtuendo {
	


	public static void main(String[] args) {
	Usuario jony= new Usuario("Jonathan", "Maldonado", "Kamuz", "123444", 34, "jonathan.maldonado86@gmail.com", "1535463456");
	Guardarropa guardarropa= new Guardarropa("mi guardarropa");
	
	Algoritmo algoritmo= new Algoritmo();
	
	Categoria calzado = new Categoria ("CALZADO");
	Categoria inferior = new Categoria ("INFERIOR");
	Categoria superior = new Categoria ("SUPERIOR");
	
	Prenda zapato=new Prenda("ZapatoVestir",calzado, "FFFFFF");
	Prenda zapatilla=new Prenda("ZapatillaCasual",calzado, "#FF0000");
	Prenda bermuda=new Prenda("Bermuda",inferior,"#008000");
	Prenda jeans=new Prenda("Jeans",inferior,"#0000FF");
	Prenda remera=new Prenda("RemeraRolinga",superior,"00FF00");
	Prenda camisa=new Prenda("CamisaMangaCorta",superior,"#808080");
	jony.setGuardarropas(guardarropa);
	guardarropa.agregarPrenda(zapato); //posicion 0
	guardarropa.agregarPrenda(zapatilla); //posicion 1
	guardarropa.agregarPrenda(bermuda); //posicion 2
	guardarropa.agregarPrenda(jeans); //posicion 3
	guardarropa.agregarPrenda(remera); //posicion 4
	guardarropa.agregarPrenda(camisa); //posicion 5
	
	Atuendo atuendo= new Atuendo();
	
	
	//jony.crearAtuendo();
	atuendo=guardarropa.obtenerAtuendo();
	System.out.println("1- ");
	System.out.println("Atuendo: ");
	
	System.out.print(atuendo.getPrendas().get(0).getNombre());
	System.out.print(", ");
	System.out.print(atuendo.getPrendas().get(0).getCategoriaPrenda().getNombreCategoria());
	System.out.print("");	
	System.out.print(atuendo.getPrendas().get(0).getColor());
	System.out.print("");
	
	System.out.println();
	System.out.print(atuendo.getPrendas().get(1).getNombre());
	System.out.print(", ");
	System.out.println(atuendo.getPrendas().get(1).getCategoriaPrenda().getNombreCategoria());
	System.out.println("");	
	System.out.println(atuendo.getPrendas().get(1).getColor());
	System.out.println("");
	
	System.out.println();
	System.out.print(atuendo.getPrendas().get(2).getNombre());
	System.out.print(", ");
	System.out.println(atuendo.getPrendas().get(2).getCategoriaPrenda().getNombreCategoria());
	System.out.println("");	
	System.out.println(atuendo.getPrendas().get(2).getColor());
	System.out.println("");
	
	System.out.println();
	System.out.println(1);
	System.out.println(1);
	
	
	}
}//fin PruebaCrearAtuendo