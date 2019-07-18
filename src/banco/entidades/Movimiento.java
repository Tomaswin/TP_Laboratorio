package banco.entidades;

public class Movimiento {
	private String tipo;
	private int dinero;
	private String operacion;
	
	public Movimiento(String tipo, String operacion, int dinero){
		this.tipo = tipo;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
