package basico.jdbc;

import java.util.ArrayList;

import basico.jdbc.Dao.*;

public class BO {
	UsuarioJDBCDao userJDBC = new UsuarioJDBCDao();
	
	public int crearUsuario(Usuarios user)
	{
		if(camposCompletos(user)) {
			if(!validarUsuario(user)) {
				userJDBC.crearUsuario(user);
				return 0;
			} else {
				return 1;
			}
		}else {
			return 2;
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
	
	public boolean camposCompletos(Usuarios user) {
		boolean correcto = true;
		if(user.getNombre().toString().equals("")) {
			correcto = false;
		}
		
		if(user.getApellido().toString().equals("")) {
			correcto = false;
		}
		
		if(user.getPassword().toString().equals("")) {
			correcto = false;
		}
		
		if(user.getEmail().toString().equals("")) {
			correcto = false;
		}
		
		if(user.getDni().toString().equals("")) {
			correcto = false;
		}
		
		if(user.getSexo().toString().equals("")) {
			correcto = false;
		}
		
		return correcto;
	}
	
}
