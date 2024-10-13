package pe.com.utp.service.uit.exception;

public class ResultNoFoundException extends RuntimeException{
	
	private static String message="La consulta no obtuvo resultados";
	
	public ResultNoFoundException() {
		super(message);
	}
}
