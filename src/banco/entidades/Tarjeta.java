package banco.entidades;

import java.util.ArrayList;

public class Tarjeta  {

	private int numero;
	private String mes;
	private int codigo;
	private int importeTotal;
	
	public Tarjeta(int numero, String mes, int codigo, int importeTotal) {
		this.numero = numero;
		this.mes = mes;
		this.codigo = codigo;
		this.importeTotal = importeTotal;
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

	public int getImporteTotal() {
		return importeTotal;
	}


	public void setImporteTotal(int importeTotal) {
		this.importeTotal = importeTotal;
	}
	
}
