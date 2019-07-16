package banco.paneles;

import java.util.ArrayList;
import java.util.List;

import banco.dao.*;
import banco.entidades.Cuenta;
import banco.entidades.Usuario;
import banco.exceptions.BancoException;

public class UsuarioBO {
	private UsuarioJDBCDao userJDBC;
	private Usuario logueado;

	public void crearUsuario(Usuario user) throws BancoException {
		if (!validarUsuario(user)) {
			userJDBC.crearUsuario(user);
		} else {
			throw new BancoException("Usuario Existente");
		}
	}

	public void modificarUsuario(Usuario user) throws BancoException {
		if (validarUsuario(user)) {
			userJDBC.modificarUsuario(user);
		} else {
			throw new BancoException("Usuario Inexistente");
		}
	}

	public void eliminarUsuario(Usuario user) throws BancoException {
		if (validarUsuario(user)) {
			userJDBC.eliminarUsuario(user);
		} else {
			throw new BancoException("Usuario Inexistente");
		}
	}

	public List<Usuario> traerTodos() throws BancoException {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		listaUsuarios = userJDBC.traerTodosUsuarios();

		return listaUsuarios;
	}
	
	public List<Cuenta> traerTodasCuentas() throws BancoException {
		
		List<Cuenta> listaUsuarios = new ArrayList<Cuenta>();
		listaUsuarios = userJDBC.traerTodasLasCuentas(logueado);

		return listaUsuarios;
	}

	public boolean validarUsuario(Usuario user) throws BancoException {
		boolean correcto;
		correcto = userJDBC.usuarioExistente(user);

		return correcto;
	}
	
	public void login(Usuario user) throws BancoException {
		if (validarUsuario(user)) {
			logueado = user;
		} else {
			throw new BancoException("Usuario Inexistente");
		}
	}

	public void setUserJDBC(UsuarioJDBCDao userJDBC) {
		this.userJDBC = userJDBC;
	}

}
