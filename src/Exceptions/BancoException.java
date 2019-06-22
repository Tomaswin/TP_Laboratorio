package Exceptions;

public class BancoException extends Exception{
	public BancoException() {
		
	}
	
	public BancoException(String mensaje) {
		super(mensaje);
	}
}
