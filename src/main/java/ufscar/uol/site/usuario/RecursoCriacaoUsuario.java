package ufscar.uol.site.usuario;

import ufscar.uol.app.usuario.CriadorUsuarios;

/**
 * Representa um endereço http em que o post com os dados que deverão ser usados
 * para criar o usuário irá acontecer.
 */
public class RecursoCriacaoUsuario {

	/**
	 * Referencia para um abstração que permite criar usuários. Pode haver mais
	 * de uma implementação, não estamos preocupado com isso aqui.
	 */
	private final CriadorUsuarios criadorUsuarios;

	/**
	 * Inversão de controle é útil para ser usado com injeção de dependência.
	 * 
	 * @param criadorUsuarios
	 *            - Quem quiser usar a classe que informe a estratégia de
	 *            criação de usuários a ser usada.
	 */
	public RecursoCriacaoUsuario(final CriadorUsuarios criadorUsuarios) {
		this.criadorUsuarios = criadorUsuarios;
	}

	/**
	 * Método de entrada para o POST na URL "/usuarios"
	 * @param formularioCriacaoUsuarios Os dados que devem vir no corpo do POST
	 */
	public void criarUsuario(final FormularioCriacaoUsuario formularioCriacaoUsuarios) {
		// Aqui entrará quaisquer validações da camada HTTP pertinentes a
		// resolução do problema,
		// como por exemplo validar cookies, etc

		criadorUsuarios.criar(formularioCriacaoUsuarios);

	}

}
