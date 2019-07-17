package banco.paneles;

import java.util.ArrayList;
import java.util.List;

import banco.dao.*;
import banco.entidades.Cuenta;
import banco.entidades.Movimiento;
import banco.entidades.Tarjeta;
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

	public List<Tarjeta> traerTodasTarjetas(Cuenta cuenta) throws BancoException {
		
		List<Tarjeta> listaTarjetas = new ArrayList<Tarjeta>();
		listaTarjetas = userJDBC.traerTodasTarjetas(cuenta);

		return listaTarjetas;
	}
	
	public Cuenta obtenerDinero(Cuenta cuenta) throws BancoException{
		Cuenta oCuenta = userJDBC.obtenerDinero(cuenta);
		return oCuenta;
	}
	
	public void realizarExtraccion(Cuenta cuenta, int extraccion) throws BancoException{
		if(validarExtraccion(cuenta, extraccion)) {
			userJDBC.realizarExtraccion(cuenta, extraccion);
		}
		else {
			throw new BancoException("No se puede extraer plata que no tenes");
		}
	}

	public void realizarDeposito(Cuenta cuenta, int deposito) throws BancoException{
		userJDBC.realizarDeposito(cuenta, deposito);
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
	
	public boolean validarExtraccion(Cuenta cuenta, int extraccion) {
		if(cuenta.getDinero() < extraccion) {
			return false;
		}else {
			return true;
		}
	}

	public void generarMovimiento(Cuenta cuenta, String operacion, int dinero) throws BancoException {
		userJDBC.generarMovimiento(cuenta, operacion, dinero);
	}
	
	public List<Movimiento> traerMovimientos(Cuenta cuenta) throws BancoException {
		List<Movimiento> listMov = new ArrayList<Movimiento>();
		listMov = userJDBC.traerTodosMovimientos(cuenta);

		return listMov;
	}

	

}
