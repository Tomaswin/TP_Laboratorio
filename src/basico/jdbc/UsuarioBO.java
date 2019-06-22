package basico.jdbc;

import java.util.ArrayList;
import java.util.List;

import Exceptions.BancoException;
import basico.jdbc.Dao.*;

public class UsuarioBO {
	private UsuarioJDBCDao userJDBC;

	// con otro throw levanto las de sql al handler
	public void crearUsuario(Usuario user) throws BancoException {
		if (camposCompletos(user)) {
			if (!validarUsuario(user)) {
				userJDBC.crearUsuario(user);
			} else {
				throw new BancoException("Usuario Existente");
			}
		} else {
			throw new BancoException("Campos Incompletos");
		}
	}

	public void modificarUsuario(Usuario user) throws BancoException {
		if (camposCompletos(user)) {
			if (validarUsuario(user)) {
				userJDBC.modificarUsuario(user);
			} else {
				throw new BancoException("Usuario Inexistente");
			}
		} else {
			throw new BancoException("Campos Incompletos");
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

	public boolean validarUsuario(Usuario user) throws BancoException {
		boolean correcto;
		correcto = userJDBC.usuarioExistente(user);

		return correcto;
	}

	public boolean camposCompletos(Usuario user) {
		boolean correcto = true;
		if (user.getNombre().equals("")) {
			correcto = false;
		}

		if (user.getApellido().equals("")) {
			correcto = false;
		}

		if (user.getPassword().equals("")) {
			correcto = false;
		}

		if (user.getEmail().equals("")) {
			correcto = false;
		}

		if (user.getDni() == 0) {
			correcto = false;
		}

		if (user.getSexo().equals("")) {
			correcto = false;
		}

		return correcto;
	}

	public void setUserJDBC(UsuarioJDBCDao userJDBC) {
		this.userJDBC = userJDBC;
	}

}
