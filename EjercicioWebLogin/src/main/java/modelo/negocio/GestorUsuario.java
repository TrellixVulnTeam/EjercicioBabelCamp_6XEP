package modelo.negocio;

import modelo.entidad.Usuario;
import modelo.persistencia.DaoUsuarioMySql;
import modelo.persistencia.interfaz.DaoUsuario;

public class GestorUsuario {
	
	private DaoUsuario daoUsuario = new DaoUsuarioMySql();
	
	public boolean estaRegistrado(String nombre, String contrase�a) {
		Usuario u = daoUsuario.buscarPorCredenciales(nombre, contrase�a);
		
		if(u==null) {
			return false;
		}else{
			return true;
		}
	}
	
}
