package ufscar.uol.app.usuario;

/**
 * Implementação da rotina padrão de criação de usuários. Essa classe é uma
 * coordenadora.
 */
public class CriadorUsuariosPadrao implements CriadorUsuarios {

	private BancoDadosUsuarios bancoDadosUsuarios;
	private EtapaConclusaoCriacaoUsuario etapaConclusaoCriacaoUsuario;

	public CriadorUsuariosPadrao(BancoDadosUsuarios bancoDadosUsuarios,
			EtapaConclusaoCriacaoUsuario etapaConclusaoCriacaoUsuario) {

		this.bancoDadosUsuarios = bancoDadosUsuarios;
		this.etapaConclusaoCriacaoUsuario = etapaConclusaoCriacaoUsuario;
	}

	@Override
	public void criar(DadosCriacaoUsuario dadosCriacaoUsuario) {

		// Salvando os dados
		Usuario usuario = bancoDadosUsuarios.cadastrar(dadosCriacaoUsuario);

		// Executando as rotinas de termino do cadastro do usuário.
		etapaConclusaoCriacaoUsuario.continuaProcessoCriacao(usuario);
	}
}
