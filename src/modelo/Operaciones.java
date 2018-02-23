package modelo;
import java.util.ArrayList;
import java.util.Iterator;

import Test.MockUsuarioModelo;

public class Operaciones {
	public double calcularEdadMedia(MockUsuarioModelo usuarioModelo) throws Exception{
		double suma=0;
		int cont=0;
			ArrayList<Usuario> usuarios= usuarioModelo.selectAll();
			Iterator<Usuario> i =usuarios.iterator();
			while(i.hasNext()){
				suma=suma+i.next().getEdad();
				cont++;
			}
			return suma/cont;
		
	}
}
