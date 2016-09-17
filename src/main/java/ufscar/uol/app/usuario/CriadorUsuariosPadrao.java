package ufscar.uol.app.usuario;

import ufscar.uol.app.DisparadorEmail;
import ufscar.uol.app.ServicoBrindes;
import ufscar.uol.app.ServicoMilhagens;

/**
 * Implementação da rotina padrão de criação de usuários. Essa classe é uma
 * coordenadora.
 */
public class CriadorUsuariosPadrao implements CriadorUsuarios {

	private BancoDadosUsuarios bancoDadosUsuarios;
	private ServicoMilhagens servicoMilhagens;
	private ServicoBrindes servicoBrindes;
	private DisparadorEmail disparadorEmail;

	public CriadorUsuariosPadrao(BancoDadosUsuarios bancoDadosUsuarios, ServicoMilhagens servicoMilhagens,
			ServicoBrindes servicoBrindes, DisparadorEmail disparadorEmail) {
		this.bancoDadosUsuarios = bancoDadosUsuarios;
		
		this.servicoMilhagens = servicoMilhagens;
		this.servicoBrindes = servicoBrindes;
		this.disparadorEmail = disparadorEmail;
	}

	@Override
	public void criar(DadosCriacaoUsuario dadosCriacaoUsuario) {
		
		// Salvando os dados
		Usuario usuario = bancoDadosUsuarios.cadastrar(dadosCriacaoUsuario);

		// Executando as rotinas de termino do cadastro do usuário.
		servicoMilhagens.criarContas(usuario);
		disparadorEmail.enviar(new EmailBoaVindas(usuario));
		servicoBrindes.enviarBrinde(usuario);
	}

}
