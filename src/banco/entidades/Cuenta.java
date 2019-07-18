package banco.entidades;

import java.util.ArrayList;

public class Cuenta {
	private String tipo;
	private int DNI;
	private double dinero;
	private int numeroCuenta;
	
	public Cuenta(String tipo, double dinero, int DNI, int numeroCuenta) {
		this.tipo = tipo;
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

	public double getDinero() {
		return dinero;
	}

	public void setDinero(double Dinero) {
		this.dinero = Dinero;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
