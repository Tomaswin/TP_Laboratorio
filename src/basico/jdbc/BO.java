package basico.jdbc;

import java.util.ArrayList;

import basico.jdbc.Dao.*;

public class BO {
	UsuarioJDBCDao userJDBC = new UsuarioJDBCDao();
	
	public void crearUsuario(Usuarios user)
	{
		if(!validarUsuario(user)) {
			userJDBC.crearUsuario(user);
		} else {
			//Mostrar error porque los ingresos de datos son iguales a otro usuario existente	
		}
	}
	
	public void modificarUsuario(Usuarios user)
	{
		if(validarUsuario(user)) {
			userJDBC.modificarUsuario(user);
		} else {
			//Mostrar error ya que esta intentando modificar un usuario que no existe, ofrecemos crearlo?
		}
	}
	
	public void eliminarUsuario(Usuarios user)
	{
		if(validarUsuario(user)) {
			userJDBC.eliminarUsuario(user.getEmail());
		} else {
			//Mostrar error ya que esta intentado borrar un usuario que no existe
		}
	}
	
	public ArrayList<Usuarios> traerTodos(Usuarios user) {
		ArrayList<Usuarios> allUsers;
		allUsers = userJDBC.traerTodosUsuarios();
		
		return allUsers;
	}
	
	public boolean validarUsuario(Usuarios user)
	{
		boolean correcto;
		correcto = userJDBC.usuarioExistente(user);
		
		return correcto;
	}
	
}
