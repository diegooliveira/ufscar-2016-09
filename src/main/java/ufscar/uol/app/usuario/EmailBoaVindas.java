package ufscar.uol.app.usuario;

import ufscar.uol.app.Email;

public class EmailBoaVindas implements Email {

	/**
	 * Usuário do email de boas vindas. 
	 */
	private Usuario usuario;

	public EmailBoaVindas(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
