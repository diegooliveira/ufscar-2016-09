package ufscar.uol.app.usuario;

/**
 * Abstração das etapas que são executadas no processo de criação de usuários.
 */
public interface EtapaConclusaoCriacaoUsuario {

	/**
	 * Implementações desse método devem continuar o processo de criação do
	 * usuário que faz sentido para seu caso.
	 * 
	 * @param usuario
	 *            O usuário que deve ter o processo de criação continuado.
	 */
	void continuaProcessoCriacao(Usuario usuario);

}
