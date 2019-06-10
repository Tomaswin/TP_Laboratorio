package basico.jdbc.Dao;

import java.util.List;

import Exceptions.Excepciones;
import basico.jdbc.Usuario;

public interface UsuarioDao {
	
	public void crearUsuario(Usuario user) throws Excepciones;
	public void modificarUsuario(Usuario user)throws Excepciones;
	public void eliminarUsuario(Usuario user)throws Excepciones;
	public List<Usuario> traerTodosUsuarios()throws Excepciones;
	public boolean usuarioExistente(Usuario user)throws Excepciones;
}
