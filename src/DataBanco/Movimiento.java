package DataBanco;

public class Movimiento {
	private int importe;
	private String operacion;
	
	public Movimiento(int valor, String operacion){
		
	}

	public int getValor() {
		return importe;
	}

	public void setValor(int valor) {
		this.importe = valor;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
}
