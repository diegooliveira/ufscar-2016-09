package ufscar.uol.app.usuario;

/**
 * Implementação da etapa de criação das contas de milhagem no processo de
 * criação do usuário.
 */
public class EtapaCriacaoContaMilhagens implements EtapaConclusaoCriacaoUsuario {

	/**
	 * Executa toda a lógica de criação das contas de milhagens, como por
	 * exemplo: qual o saldo inicial da conta; tem data de aniversário; etc.
	 */
	@Override
	public void continuaProcessoCriacao(Usuario usuario) {

		System.out.println("Criando contas de milhagens para o usuário " + usuario);
	}

}
