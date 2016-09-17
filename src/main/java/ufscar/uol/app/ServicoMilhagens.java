package ufscar.uol.app;

import ufscar.uol.app.usuario.Usuario;

/**
 * Interface que define o serviço que controla milhagens. Se essa classe começar
 * a crescer pode ser necessário refatorar para que ela tenha apenas uma
 * responsabilidade.
 */
public interface ServicoMilhagens {

	/**
	 * Implementação desse método deverá criar as contas de milhagens.
	 * 
	 * @param usuario
	 *            O usuário que deve ter as contas de milhagens criadas.
	 */
	void criarContas(Usuario usuario);

}
