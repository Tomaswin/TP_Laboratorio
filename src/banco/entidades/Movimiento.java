package banco.entidades;

public class Movimiento {
	private int importe;
	private String operacion;
	
	public Movimiento(int importe, String operacion){
		this.importe = importe;
		this.operacion = operacion;
	}

	public int getImporte() {
		return importe;
	}

	public void setImporte(int importe) {
		this.importe = importe;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
}
