package basico.jdbc;

import java.util.ArrayList;

import basico.jdbc.Dao.UsuarioDao;

public class BO {
	UsuarioDao userDao;
	
	public void crearUsuario(Usuarios user)
	{
		if(validarUsuario(user)) {
			userDao.crearUsuario(user);
		} else {
			//Mostrar error porque los ingresos de datos son iguales a otro usuario existente	
		}
	}
	
	public void modificarUsuario(Usuarios user)
	{
		if(validarUsuario(user)) {
			userDao.modificarUsuario(user);
		} else {
			//Mostrar error ya que esta intentando modificar un usuario que no existe, ofrecemos crearlo?
		}
	}
	
	public void eliminarUsuario(Usuarios user)
	{
		if(validarUsuario(user)) {
			userDao.eliminarUsuario(user.getUser());
		} else {
			//Mostrar error ya que esta intentado borrar un usuario que no existe
		}
	}
	
	public ArrayList<Usuarios> traerTodos(Usuarios user) {
		ArrayList<Usuarios> allUsers;
		allUsers = userDao.traerTodosUsuarios();
		
		return allUsers;
	}
	
	public boolean validarUsuario(Usuarios user)
	{
		boolean correcto;
		correcto = userDao.usuarioExistente(user);
		
		return correcto;
	}
	
}
