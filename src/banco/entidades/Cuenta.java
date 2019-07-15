package banco.entidades;

import java.util.ArrayList;

public class Cuenta {
	private int DNI;
	private int dinero;
	private ArrayList<Tarjeta> tarjeta;
	
	public Cuenta(int DNI, int Dinero, ArrayList<Tarjeta> Tarjeta) {
		this.setDNI(DNI);
		this.setDinero(Dinero);
		this.setTarjeta(Tarjeta);
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

	public ArrayList<Tarjeta> getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(ArrayList<Tarjeta> Tarjeta) {
		this.tarjeta = Tarjeta;
	}
}
