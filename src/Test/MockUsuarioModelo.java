package Test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import modelo.Usuario;



public class MockUsuarioModelo{
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	private ArrayList<Usuario> listaUsuarios;
	private boolean lanzarExtepcion;
	
	/**
	 * 
	 * @param lanzarExtepcion True: Dara error | False: Funcionara
	 */
	public MockUsuarioModelo(boolean lanzarExtepcion){
		this.lanzarExtepcion=lanzarExtepcion;
		
		this.listaUsuarios=new ArrayList<>();


		Usuario patxi=new Usuario();
		patxi.setId(1);
		patxi.setNombre("Patxi");
		patxi.setApellido("Lizaralde");
		patxi.setDni("12345678A");
		patxi.setEdad(20);
		try {
			patxi.setFecha_nac(formatter.parse("1993/12/01"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.listaUsuarios.add(patxi);
		
		Usuario aitor=new Usuario();
		aitor.setId(2);
		aitor.setNombre("Aitor");
		aitor.setApellido("Tena");
		aitor.setDni("87654321B");
		aitor.setEdad(18);
		try {
			aitor.setFecha_nac(formatter.parse("1994/12/01"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}this.listaUsuarios.add(aitor);
	}
	
	
	private void comprobarConexion() throws Exception{
		if (this.lanzarExtepcion){
			throw new Exception("La conexion ha fallado");
		}
	};
	
	public ArrayList<Usuario> selectAll() throws Exception{
		ArrayList<Usuario> usuarios=null;
		comprobarConexion();
		usuarios=this.listaUsuarios;
		
		return usuarios;
		
	}
	
	public Usuario select(int id) throws Exception{
		comprobarConexion();
		
		Usuario usuario=null;
		Iterator<Usuario> i =this.listaUsuarios.iterator();
		while(i.hasNext()){
			Usuario u=i.next();
			if (u.getId()==id){
				usuario=u;
			}
		}

		return (usuario);

	}
	
	public void delete(int id) throws Exception{
		comprobarConexion();
		Iterator<Usuario> i =this.listaUsuarios.iterator();
		boolean encontrado=false;
		while(i.hasNext()){
			if (i.next().getId()==id){
				i.remove();
				encontrado=true;

			}
		}
		if(!encontrado){
			throw new Exception("Ese usuario no existe");
		}
	}
	
	public void update(Usuario usuario) throws Exception{
		comprobarConexion();
		boolean encontrado=false;
		Iterator<Usuario> i =this.listaUsuarios.iterator();
		while(i.hasNext()){
			Usuario u=i.next();
			if (u.getId()==usuario.getId()){
				u.setApellido(usuario.getApellido());
				u.setDni(usuario.getDni());
				u.setEdad(usuario.getEdad());
				u.setFecha_nac(usuario.getFecha_nac());
				u.setNombre(usuario.getNombre());
				encontrado=true;
			}
			
		}
		if(!encontrado){
			throw new Exception("Ese usuario no existe");
		}
		
		
	}
	
	public void insertar(Usuario usuario) throws Exception{
		comprobarConexion();
		boolean noEncontrado=true;
		Iterator<Usuario> i =this.listaUsuarios.iterator();
		while(i.hasNext()){
			if (i.next().getId()==usuario.getId()){
				noEncontrado=false;
			}
		}
		if(noEncontrado){
			this.listaUsuarios.add(usuario);
		}else{
			throw new Exception("Ese usuario ya existe");
		}
		
	}
}
