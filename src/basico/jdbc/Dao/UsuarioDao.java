package basico.jdbc.Dao;

import java.util.List;

import Exceptions.BancoException;
import basico.jdbc.Usuario;

public interface UsuarioDao {
	
	public void crearUsuario(Usuario user) throws BancoException;
	public void modificarUsuario(Usuario user)throws BancoException;
	public void eliminarUsuario(Usuario user)throws BancoException;
	public List<Usuario> traerTodosUsuarios()throws BancoException;
	public boolean usuarioExistente(Usuario user)throws BancoException;
}
