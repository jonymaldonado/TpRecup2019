package qmp;

import java.util.ArrayList;
import java.util.List;

import pojo.Guardarropa;

public class Usuario {
	//atributos
	private String nombre;
	private String nombreDeUsuario;
	private String password;
	private int edad;
	private List<Guardarropa> guardarropas;
	private String correo;
	private String celular;
	
	//constructor
	public Usuario(String nombre, String nombreDeUsuario, String password, int edad, String correo, String celular) {

		this.nombre = nombre;
		this.nombreDeUsuario = nombreDeUsuario;
		this.password = password;
		this.edad = edad;
		this.correo = correo;
		this.celular = celular;
		this.guardarropas = new ArrayList<Guardarropa>();
	}
	
	//metodos - Getters y setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}

	public void setNombreDeUsuario(String nombreDeUsuario) {
		this.nombreDeUsuario = nombreDeUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getCorreo() {
		return this.correo;
	}
	

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	//metodos
	
	public void crearGuardarropa(String nombre) {
		Guardarropa g = new Guardarropa(nombre);
		this.guardarropas.add(g);
		}
	
	
	

}
