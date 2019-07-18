package banco.ui;

import java.util.List;

import javax.swing.JOptionPane;

import banco.bo.BancoBO;
import banco.dao.BancoJDBCDao;
import banco.entidades.Cuenta;
import banco.entidades.Movimiento;
import banco.entidades.MovimientoCuenta;
import banco.entidades.MovimientoTarjeta;
import banco.entidades.Tarjeta;
import banco.entidades.Usuario;
import banco.exceptions.BancoException;
import banco.paneles.*;

public class Handler {

	private BancoBO bo;
	private PrincipalFrame frame;

	public Handler() {
		frame = new PrincipalFrame(this);
		bo = new BancoBO();
		bo.setBancoJDBC(new BancoJDBCDao());
	}

	public void init() {
		frame.setVisible(true);
		mostrarLoginUsuario();
	}
		
	public void mostrarLoginUsuario(){
		try {
			List<Usuario> usuarios = bo.traerTodos();
			frame.cambiarPanel(new MiPanelLogin("", this, usuarios));
		} catch (BancoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	
	public void mostrarTodasCuentas(){
		try {
			List<Cuenta> cuentas = bo.traerTodasCuentas();
			frame.cambiarPanel(new MiPanelMostrarCuenta("", this ,cuentas));
		} catch (BancoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void mostrarTarjeta(Cuenta cuenta) {
		try {
			List<Tarjeta> tarjetas = bo.traerTodasTarjetas(cuenta);
			frame.cambiarPanel(new MiPanelMostrarTarjeta("", this ,tarjetas));
		} catch (BancoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public void mostrarMovimientosCuenta(Cuenta cuenta) {
		try {
			List<MovimientoCuenta> mov = bo.traerMovimientoCuenta(cuenta);
			frame.cambiarPanel(new MiPanelMovimientoCuenta("", this, mov));
		} catch (BancoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public void mostrarMovimientoTarjeta(Tarjeta tarjeta) {
		try {
			List<MovimientoTarjeta> mov = bo.traerMovimientoTarjeta(tarjeta);
			frame.cambiarPanel(new MiPanelMovimientoTarjeta("", this, mov));
		} catch (BancoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public void mostrarPanelExtraccion(Cuenta cuenta) {
		try {
			Cuenta oCuenta = bo.obtenerDinero(cuenta);
			frame.cambiarPanel(new MiPanelExtraccion("", this, oCuenta));
		} catch (BancoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}
	
	public void mostrarPanelDeposito(Cuenta cuenta) {
		try {
			Cuenta oCuenta = bo.obtenerDinero(cuenta);
			frame.cambiarPanel(new MiPanelDeposito("", this, oCuenta));
		} catch (BancoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}
	
	public void login(Usuario user) {
		try {
			bo.login(user);
			frame.loginSuccess();
		} catch (BancoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void realizarExtraccion(Cuenta cuenta, int extraccion) {
		try {
			bo.realizarExtraccion(cuenta, extraccion);
		} catch (BancoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		generarMovimientoCuenta(cuenta, "Extraccion", extraccion);
	}
	
	public void realizarDeposito(Cuenta cuenta, int deposito) {
		try {
			bo.realizarDeposito(cuenta, deposito);
		} catch (BancoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		generarMovimientoCuenta(cuenta, "Deposito", deposito);
	}
	
	public void generarMovimientoCuenta(Cuenta cuenta, String nombreOperacion, int dinero) {
		try {
			bo.generarMovimiento(cuenta, nombreOperacion, dinero);
		} catch (BancoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}
