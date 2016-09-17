package ufscar.uol.app.usuario;

/**
 * Abstração do processo de criação de um usuário
 */
public interface CriadorUsuarios {

	/**
	 * Implementações desse método devem executar todas as rotinas necessárias
	 * para salvar o usuário para uso posterior, fazendo as validações
	 * necessárias.
	 */
	void criar(DadosCriacaoUsuario dadosCriacaoUsuario);

}
