package basico.jdbc;

import java.util.ArrayList;
import java.util.List;

import Exceptions.Excepciones;
import basico.jdbc.Dao.*;

public class BO {
	UsuarioJDBCDao userJDBC = new UsuarioJDBCDao();
	
	public void crearUsuario(Usuario user) throws Excepciones
	{
		if(camposCompletos(user)) {
			if(!validarUsuario(user)) {
				userJDBC.crearUsuario(user);
				} else {
				throw new Excepciones("Usuario Existente");
				}
		} else {
			throw new Excepciones("Campos Incompletos");
		}
	}
	
	public void modificarUsuario(Usuario user) throws Excepciones
	{
		if(camposCompletos(user)) {
			if(validarUsuario(user)) {
				userJDBC.modificarUsuario(user);
			} else {
				throw new Excepciones("Usuario Inexistente");
			}
		}else {
			throw new Excepciones("Campos Incompletos");
		}
	}
	
	public void eliminarUsuario(Usuario user) throws Excepciones
	{
		if(validarUsuario(user)) {
			userJDBC.eliminarUsuario(user);
		} else {
			throw new Excepciones("Usuario Inexistente");
		}
	}
	
	public List<Usuario> traerTodos() {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		listaUsuarios = userJDBC.traerTodosUsuarios();
		
		return listaUsuarios;
	}
	
	public boolean validarUsuario(Usuario user)
	{
		boolean correcto;
		correcto = userJDBC.usuarioExistente(user);
		
		return correcto;
	}
	
	public boolean camposCompletos(Usuario user) {
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
		
		if(user.getDni() == 0) {
			correcto = false;
		}
		
		if(user.getSexo().toString().equals("")) {
			correcto = false;
		}
		
		return correcto;
	}
	
}
