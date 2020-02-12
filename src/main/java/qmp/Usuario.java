package qmp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {
	//atributos --------------------------------------------------------------------------------
	@Id
	@GeneratedValue
	@Column(name="idUsuario")
	private int idUsuario;
	@Column(name="nombreUsuario")
	private String nombreUsuario;
	@Column(name="apellidoUsuario")
	private String apellidoUsuario;
	@Column(name="nombreDeUsuario")
	private String nombreDeUsuario;
	@Column(name="password")
	private String password;
	@Column(name="edadUsuario")
	private int edadUsuario;
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinTable(name = "Usuario_Guardarropa" ,
		        joinColumns = { @JoinColumn(name = "idUsuario") },
		        inverseJoinColumns = { @JoinColumn(name = "idGuardarropa")}
    )
	private Guardarropa guardarropa;
	@Column(name="correoUsuario")
	private String correoUsuario;
	@Column(name="celularUsuario")
	private String celularUsuario;
	
	//constructor ---------------------------------------------------------------------------
	public Usuario(String nombre, String apellido, String nombreDeUsuario, String password, int edad, String correo, String celular) {

		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setNombreDeUsuario(nombreDeUsuario);
		this.setPassword(password);
		this.setEdad(edad);
		this.setCorreo(correo);
		this.setCelular(celular);
		this.setGuardarropas(null);
	}
	
	public Usuario() {
		// TODO Apéndice de constructor generado automáticamente
	}

	//metodos - Getters y setters ---------------------------------------------------------------
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public void setApellido(String apellido) {
		this.apellidoUsuario = apellido;
	}
	
	public String getApellido() {
		return apellidoUsuario;
	}
	
	public Guardarropa getGuardarropas() {
		return guardarropa;
	}
	
	public void setGuardarropas(Guardarropa guardarropas) {
		this.guardarropa = guardarropas;
	}

	public String getNombre() {
		return nombreUsuario;
	}

	public void setNombre(String nombre) {
		this.nombreUsuario = nombre;
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
		return edadUsuario;
	}

	public void setEdad(int edad) {
		this.edadUsuario = edad;
	}
	
	public String getCorreo() {
		return this.correoUsuario;
	}
	

	public void setCorreo(String correo) {
		this.correoUsuario = correo;
	}

	public String getCelular() {
		return this.celularUsuario;
	}

	public void setCelular(String celular) {
		this.celularUsuario = celular;
	}
	
	//metodos --------------------------------------------------------------------------------------------
	
	public void crearGuardarropa(String nombre) {
		Guardarropa guardarropaNueva = new Guardarropa(nombre);
		 {
			if (this.existenciaDeGuardarropa()) {
				System.out.println("Ya tienes un Guardarropa");
			} else {
				this.agregarGuardarropa(guardarropaNueva);
			}

		}
		
	}
	
	public boolean existenciaDeGuardarropa() {
		boolean existeUnGuardarropa=false;
		
		if (this.getGuardarropas()!=null) {
			existeUnGuardarropa=true;
		}
		return existeUnGuardarropa;
	}
	
	public Atuendo crearAtuendo() {
		Atuendo unAtuendo=new Atuendo();
		unAtuendo=this.getGuardarropas().obtenerAtuendo();
		return unAtuendo;
	}
	
	public void agregarGuardarropa(Guardarropa unGuardarropa) {
		this.setGuardarropas(unGuardarropa);
		unGuardarropa.asignarUsuario(this);
	}


}//fin Usuario ------------------------------------------------------------------------------------------
