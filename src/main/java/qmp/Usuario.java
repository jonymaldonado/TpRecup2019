package qmp;



public class Usuario{
	//atributos --------------------------------------------------------------------------------
	private String nombre;
	private String apellido;
	private String nombreDeUsuario;
	private String password;
	private int edad;
	private Guardarropa guardarropas;
	private String correo;
	private String celular;
	
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
	
	//metodos - Getters y setters ---------------------------------------------------------------
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public Guardarropa getGuardarropas() {
		return guardarropas;
	}
	
	public void setGuardarropas(Guardarropa guardarropas) {
		this.guardarropas = guardarropas;
	}

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
	
	//metodos --------------------------------------------------------------------------------------------
	
	public void crearGuardarropa(String nombre) {
		Guardarropa guardarropaNueva = new Guardarropa(nombre);
		 {
			if (this.existenciaDeGuardarropa()) {
				System.out.println("Ya tienes un Guardarropa");
			} else {
				this.setGuardarropas(guardarropaNueva);
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
	
	public Atuendo crearAtuendo(Guardarropa guardarropa) {
		Atuendo unAtuendo=new Atuendo();
		unAtuendo=guardarropa.obtenerAtuendo();
		return unAtuendo;
	}

}//fin Usuario ------------------------------------------------------------------------------------------
