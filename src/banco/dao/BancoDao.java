package banco.dao;

import java.util.List;

import banco.entidades.Cuenta;
import banco.entidades.Movimiento;
import banco.entidades.MovimientoCuenta;
import banco.entidades.MovimientoTarjeta;
import banco.entidades.Tarjeta;
import banco.entidades.Usuario;
import banco.exceptions.BancoException;

public interface BancoDao {
	
	public List<Usuario> traerTodosUsuarios()throws BancoException;
	public boolean usuarioExistente(Usuario user)throws BancoException;
	public List<Cuenta> traerTodasLasCuentas(Usuario usuario) throws BancoException;
	public List<Tarjeta> traerTodasTarjetas(Cuenta cuenta) throws BancoException;
	public Cuenta obtenerDinero(Cuenta cuenta) throws BancoException;
	public void realizarExtraccion(Cuenta cuenta, int extraccion) throws BancoException;
	public void realizarDeposito(Cuenta cuenta, int extraccion) throws BancoException;
	public void generarMovimientoCuenta(Cuenta cuenta, String operacion, int dinero) throws BancoException;
	List<MovimientoCuenta> traerTodosMovimientosCuenta(Cuenta cuenta) throws BancoException;
	List<MovimientoTarjeta> traerTodosMovimientosTarjeta(Tarjeta tarjeta) throws BancoException;
}
