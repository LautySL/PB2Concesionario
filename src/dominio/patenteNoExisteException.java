package dominio;

public class patenteNoExisteException extends Exception {
	public patenteNoExisteException(String mensaje) {
		super(mensaje);
	}
}
