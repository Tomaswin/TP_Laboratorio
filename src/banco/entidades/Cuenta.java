package banco.entidades;

import java.util.ArrayList;

public class Cuenta {
	private int DNI;
	private int dinero;
	private int numeroCuenta;
	
	public Cuenta(int dinero, int DNI, int numeroCuenta) {
		this.dinero = dinero;
		this.DNI = DNI;
		this.numeroCuenta = numeroCuenta;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int Dni) {
		DNI = Dni;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int Dinero) {
		this.dinero = Dinero;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
}
