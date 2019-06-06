package basico.jdbc;

import java.util.ArrayList;

import basico.jdbc.Dao.*;

public class BO {
	UsuarioJDBCDao userJDBC = new UsuarioJDBCDao();
	
	public int crearUsuario(Usuarios user)
	{
		if(camposCompletos(user)) {
			if(!validarUsuario(user.getEmail().toString())) {
				userJDBC.crearUsuario(user);
				return 0;
			} else {
				return 1;
			}
		}else {
			return 2;
		}
	}
	
	public int modificarUsuario(Usuarios user)
	{
		if(camposCompletos(user)) {
			if(validarUsuario(user.getEmail().toString())) {
				userJDBC.modificarUsuario(user);
				return 0;
			} else {
				return 1;
			}
		}else {
			return 2;
		}
	}
	
	public int eliminarUsuario(String email)
	{
		if(validarUsuario(email)) {
			userJDBC.eliminarUsuario(email.toString());
			return 0;
		} else {
			return 1;
		}
	}
	
	public void traerTodos(ArrayList<Usuarios> user) {
		userJDBC.traerTodosUsuarios(user);
	}
	
	public boolean validarUsuario(String email)
	{
		boolean correcto;
		correcto = userJDBC.usuarioExistente(email);
		
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
