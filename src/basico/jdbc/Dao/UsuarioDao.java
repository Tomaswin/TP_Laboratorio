package basico.jdbc.Dao;

import java.util.ArrayList;

import basico.jdbc.Usuarios;

public interface UsuarioDao {
	
	public void crearUsuario(Usuarios user);
	public void modificarUsuario(Usuarios user);
	public void eliminarUsuario(String user);
	public ArrayList<Usuarios> traerTodosUsuarios();
	public boolean usuarioExistente(Usuarios user);
}
