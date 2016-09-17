package ufscar.uol.app.usuario;

import ufscar.uol.app.DisparadorEmail;

public class EtapaEnviarBoasVindas implements EtapaConclusaoCriacaoUsuario {

	private DisparadorEmail disparadorEmail;

	@Override
	public void continuaProcessoCriacao(Usuario usuario) {
		disparadorEmail.enviar(new EmailBoaVindas(usuario));
	}

}
