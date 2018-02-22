package Test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import modelo.MockUsuarioModelo;
import modelo.Usuario;
import vista.UsuarioVista;

public class Tests {

	@Test
	public void testSelectAll() {
		try {
			MockUsuarioModelo usuarioModelo= new MockUsuarioModelo(true);
			ArrayList<Usuario> usuarios=usuarioModelo.selectAll();
			fail("Se esperaba fallo de conexion");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test() {
		try {
			MockUsuarioModelo usuarioModelo= new MockUsuarioModelo(false);
			Usuario usuario=usuarioModelo.select(2);
			UsuarioVista usuarioVista=new UsuarioVista();
			usuarioVista.mostrarUsuario(usuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("No se esperaba fallo de conexion");
		}
	}
	@Test
	public void testInsert() {
		try {
			MockUsuarioModelo usuarioModelo= new MockUsuarioModelo(false);
			Usuario usuario=usuarioModelo.select(1);
			
			usuarioModelo.insertar(usuario);
			fail("Se esperaba error al insertar");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
