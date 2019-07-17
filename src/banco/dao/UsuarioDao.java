package banco.dao;

import java.util.List;

import banco.entidades.Cuenta;
import banco.entidades.Tarjeta;
import banco.entidades.Usuario;
import banco.exceptions.BancoException;

public interface UsuarioDao {
	
	public void crearUsuario(Usuario user) throws BancoException;
	public void modificarUsuario(Usuario user)throws BancoException;
	public void eliminarUsuario(Usuario user)throws BancoException;
	public List<Usuario> traerTodosUsuarios()throws BancoException;
	public boolean usuarioExistente(Usuario user)throws BancoException;
	public List<Cuenta> traerTodasLasCuentas(Usuario usuario) throws BancoException;
	public List<Tarjeta> traerTodasTarjetas(Cuenta cuenta) throws BancoException;
}
