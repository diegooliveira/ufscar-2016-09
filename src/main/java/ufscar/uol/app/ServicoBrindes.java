package ufscar.uol.app;

import ufscar.uol.app.usuario.Usuario;

/**
 * Interface que representa o serviço de envio de brindes.
 */
public interface ServicoBrindes {

	/**
	 * Implementações desse método devem fazer toda a atividade de envio de
	 * brindes.
	 * 
	 * @param usuario
	 *            O usuário que deve receber o brinde.
	 */
	void enviarBrinde(Usuario usuario);

}
