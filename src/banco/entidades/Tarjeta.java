package banco.entidades;

import java.util.ArrayList;

public class Tarjeta  {

	private int numero;
	private String mes;
	private int codigo;
	private int importeTotal;
	private ArrayList<Movimiento> movimiento;
	
	
	public Tarjeta(int numero, String mes, int codigo, int importeTotal, ArrayList<Movimiento> movimiento) {
		this.numero = numero;
		this.mes = mes;
		this.codigo = codigo;
		this.importeTotal = importeTotal;
		this.movimiento = movimiento;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getMes() {
		return mes;
	}


	public void setMes(String mes) {
		this.mes = mes;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public ArrayList<Movimiento> getMovimiento() {
		return movimiento;
	}


	public void setMovimiento(ArrayList<Movimiento> movimiento) {
		this.movimiento = movimiento;
	}


	public int getImporteTotal() {
		return importeTotal;
	}


	public void setImporteTotal(int importeTotal) {
		this.importeTotal = importeTotal;
	}
	
}
