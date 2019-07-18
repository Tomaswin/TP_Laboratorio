package banco.bo;

import java.util.ArrayList;
import java.util.List;

import banco.dao.*;
import banco.entidades.Cuenta;
import banco.entidades.Movimiento;
import banco.entidades.MovimientoCuenta;
import banco.entidades.MovimientoTarjeta;
import banco.entidades.Tarjeta;
import banco.entidades.Usuario;
import banco.exceptions.BancoException;

public class BancoBO {
	private BancoJDBCDao bancoJDBC;
	private Usuario logueado;
	
	public void setBancoJDBC(BancoJDBCDao bancoJDBC) {
		this.bancoJDBC = bancoJDBC;
	}
	
	public List<Usuario> traerTodos() throws BancoException {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		listaUsuarios = bancoJDBC.traerTodosUsuarios();

		return listaUsuarios;
	}
	
	public List<Cuenta> traerTodasCuentas() throws BancoException {
		
		List<Cuenta> listaUsuarios = new ArrayList<Cuenta>();
		listaUsuarios = bancoJDBC.traerTodasLasCuentas(getLogueado());

		return listaUsuarios;
	}

	public List<Tarjeta> traerTodasTarjetas(Cuenta cuenta) throws BancoException {
		
		List<Tarjeta> listaTarjetas = new ArrayList<Tarjeta>();
		listaTarjetas = bancoJDBC.traerTodasTarjetas(cuenta);

		return listaTarjetas;
	}
	
	public Cuenta obtenerDinero(Cuenta cuenta) throws BancoException{
		Cuenta oCuenta = bancoJDBC.obtenerDinero(cuenta);
		return oCuenta;
	}
	
	public void realizarExtraccion(Cuenta cuenta, int extraccion) throws BancoException{
		if(validarExtraccion(cuenta, extraccion)) {
			bancoJDBC.realizarExtraccion(cuenta, extraccion);
		}
		else {
			throw new BancoException("No se puede extraer plata que no tenes");
		}
	}

	public void realizarDeposito(Cuenta cuenta, int deposito) throws BancoException{
		bancoJDBC.realizarDeposito(cuenta, deposito);
	}

	
	public boolean validarUsuario(Usuario user) throws BancoException {
		boolean correcto;
		correcto = bancoJDBC.usuarioExistente(user);

		return correcto;
	}
	
	public void login(Usuario user) throws BancoException {
		if (validarUsuario(user)) {
			setLogueado(user);
		} else {
			throw new BancoException("Usuario Inexistente");
		}
	}
	
	public boolean validarExtraccion(Cuenta cuenta, int extraccion) {
		if(cuenta.getDinero() < extraccion) {
			return false;
		}else {
			return true;
		}
	}

	public void generarMovimiento(Cuenta cuenta, String operacion, int dinero) throws BancoException {
		bancoJDBC.generarMovimientoCuenta(cuenta, operacion, dinero);
	}
	
	public List<MovimientoCuenta> traerMovimientoCuenta(Cuenta cuenta) throws BancoException {
		List<MovimientoCuenta> listMov = new ArrayList<MovimientoCuenta>();
		listMov = bancoJDBC.traerTodosMovimientosCuenta(cuenta);

		return listMov;
	}
	
	public List<MovimientoTarjeta> traerMovimientoTarjeta(Tarjeta tarjeta) throws BancoException {
		List<MovimientoTarjeta> listMov = new ArrayList<MovimientoTarjeta>();
		listMov = bancoJDBC.traerTodosMovimientosTarjeta(tarjeta);

		return listMov;
	}
	
	public Usuario getLogueado(){
	   return logueado;
	}

	public void setLogueado(Usuario logueado){
	   this.logueado = logueado;
	}

	

}
