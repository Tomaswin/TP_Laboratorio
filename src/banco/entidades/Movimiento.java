package banco.entidades;

public class Movimiento {
	private int dinero;
	private int numeroCuenta;
	private String operacion;
	
	public Movimiento(int numeroCuenta, String operacion, int dinero){
		this.setNumeroCuenta(numeroCuenta);
		this.operacion = operacion;
		this.dinero = dinero;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
}
