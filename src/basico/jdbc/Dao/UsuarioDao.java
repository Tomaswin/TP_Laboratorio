package basico.jdbc.Dao;

import java.util.List;

import basico.jdbc.Usuario;

public interface UsuarioDao {
	
	public void crearUsuario(Usuario user);
	public void modificarUsuario(Usuario user);
	public void eliminarUsuario(Usuario user);
	public List<Usuario> traerTodosUsuarios();
	public boolean usuarioExistente(Usuario user);
}
