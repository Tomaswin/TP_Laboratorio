package banco.entidades;

import java.util.ArrayList;

public class Cuenta {
	private int DNI;
	private int dinero;
	
	public Cuenta(int DNI, int Dinero) {
		this.setDNI(DNI);
		this.setDinero(Dinero);
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
}
