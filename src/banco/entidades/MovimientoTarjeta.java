package banco.entidades;

public class MovimientoTarjeta extends Movimiento {
	private int numeroTarjeta;

	public MovimientoTarjeta(String tipo, int numeroTarjeta, String operacion, int dinero) {
		super(tipo, operacion, dinero);
		this.numeroTarjeta = numeroTarjeta;
	}

	public int getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(int numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

}
