package qmp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
	
	Usuario jony;
	Guardarropa guardarropa;
	
	@Before
	public void initialize() {
		 jony=new Usuario("Jonathan","Maldonado", "Kamuz", "YugioH", 33, "jonathanm86@gmail.com", "11353464356");
		 guardarropa=new Guardarropa("ropero");
	}
	
	

	@Test
	public void testDeVerificarDato() {
		assertTrue(jony.getNombre().equals("Jonathan"));
		assertTrue(jony.getApellido().equals("Maldonado"));
		assertTrue(jony.getNombreDeUsuario().equals("Kamuz"));
		assertTrue(jony.getPassword().equals("YugioH"));
		assertTrue(jony.getEdad()==33);
		assertTrue(jony.getCorreo().equals("jonathanm86@gmail.com"));
		assertTrue(jony.getCelular().equals("11353464356"));
		}
	
	@Test
	public void testVerificadorGuardarropa() {
		jony.setGuardarropas(guardarropa);
		
		assertTrue(jony.existenciaDeGuardarropa());
	}
}//fin UsuarioTest
