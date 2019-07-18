package banco.entidades;

public class MovimientoCuenta extends Movimiento {
	private int numeroCuenta;

	public MovimientoCuenta(String tipo, int numeroCuenta, String operacion, int dinero) {
		super(tipo, operacion, dinero);
		this.numeroCuenta = numeroCuenta;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

}
