package ufscar.uol.app;

/**
 * Interface que representa o processo de envio de emails.
 */
public interface DisparadorEmail {

	/**
	 * Implementações desse método devem executar toda a lógica necessária para
	 * enviar o email.
	 */
	void enviar(Email email);

}
