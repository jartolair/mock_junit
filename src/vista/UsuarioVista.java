package vista;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Test.MockUsuarioModelo;
import modelo.UsuarioModelo;
import modelo.Usuario;

public class UsuarioVista {

	public void menuUsuario(){
		//listar y insertar
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		final int LISTAR=1;
		final int INSERTAR=2;
		final int SALIR=0;
		int opcion;
		try {
		do{
			System.out.println("-----MENU DE USUARIOS-----");
			System.out.println(LISTAR +"- Listar");
			System.out.println(INSERTAR+"- Insertar");
			System.out.println(SALIR+"- Salir");
			MockUsuarioModelo modeloUsuario=new MockUsuarioModelo(true);
			Scanner lector=new Scanner(System.in);
			opcion = Integer.parseInt(lector.nextLine());
			
			switch(opcion){
			case LISTAR:
				
				ArrayList<Usuario> usuarios;
				
					usuarios = modeloUsuario.selectAll();
				
				mostrarUsuarios(usuarios);
				break;
			case INSERTAR:
				System.out.println("Nombre:");
				String nombre=lector.nextLine();
				System.out.println("Apellido:");
				String apellido=lector.nextLine();
				System.out.println("Edad:");
				int edad=Integer.parseInt(lector.nextLine());
				System.out.println("DNI:");
				String dni=lector.nextLine();
				System.out.println("Fecha de nacimiento: [yyyy-MM-dd]");
				Date fecha_nac=null;
				try {
					fecha_nac=(Date) formatter.parse(lector.nextLine());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Usuario usuario=new Usuario();
				usuario.setNombre(nombre);
				usuario.setApellido(apellido);
				usuario.setEdad(edad);
				usuario.setDni(dni);
				usuario.setFecha_nac(fecha_nac);
				modeloUsuario.insertar(usuario);
				break;
				
			case SALIR:
				System.out.println("Adios...");
				break;
			
			default:
				System.out.println("Esa opcion no existe");
			}
		}while(opcion!=SALIR);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void mostrarUsuarios(ArrayList<Usuario> usuarios) {
		// TODO Auto-generated method stub
		System.out.println("Id - Nombre Apellidos / Edad / DNI / Fecha_nac\n");
		Iterator<Usuario> i=usuarios.iterator();
		while(i.hasNext()){
			mostrarUsuario(i.next());
		}
	}

	public void mostrarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		System.out.println(usuario.getId()+" - "+usuario.getNombre()+" "+usuario.getApellido()+" / "+usuario.getEdad()+" / "+usuario.getDni()+" / "+usuario.getFecha_nac());
	}
}
