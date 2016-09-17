package ufscar.uol.site.usuario;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import ufscar.uol.app.DisparadorEmail;
import ufscar.uol.app.Email;
import ufscar.uol.app.ServicoBrindes;
import ufscar.uol.app.ServicoMilhagens;
import ufscar.uol.app.usuario.BancoDadosUsuarios;
import ufscar.uol.app.usuario.CriadorUsuariosPadrao;
import ufscar.uol.app.usuario.DadosCriacaoUsuario;
import ufscar.uol.app.usuario.Usuario;

public class TesteCriadorUsuariosPadrao {

	private Usuario usuario = new Usuario();

	@Test
	public void deve_criar_usuario() {

		// Preparação do teste
		DadosCriacaoUsuario dados = new DadosParaTeste();

		BancoDadosUsuarioTeste bancoDadosUsuarioTeste = new BancoDadosUsuarioTeste();
		ServicoMilhagensTeste servicoMilhagensTeste = new ServicoMilhagensTeste();
		ServicoBrindesTeste servicoBrindesTeste = new ServicoBrindesTeste();
		DisparadorEmailsTeste disparadorEmailTeste = new DisparadorEmailsTeste();

		// Executando o teste
		CriadorUsuariosPadrao criadorUsuarioPadrao = new CriadorUsuariosPadrao(bancoDadosUsuarioTeste,
				servicoMilhagensTeste, servicoBrindesTeste, disparadorEmailTeste);
		criadorUsuarioPadrao.criar(dados);

		// Validação
		assertThat(bancoDadosUsuarioTeste.quantidadeChamadas, equalTo(1));
		assertThat(servicoMilhagensTeste.quantidadeChamadas, equalTo(1));
		assertThat(servicoBrindesTeste.quantidadeChamadas, equalTo(1));
		assertThat(disparadorEmailTeste.quantidadeChamadas, equalTo(1));
	}

	/******************************************************************************
	 * Implementações de faz de conta usadas durante o teste. Há bibliotecas que
	 * reduzem a necessidade de criação desse tipo de código de apoio, exemplo
	 * Mockiot. Não iremos usá-la aqui para reduzir a quantidade de material.
	 ******************************************************************************/

	private static class DadosParaTeste implements DadosCriacaoUsuario {

	}

	private static class ServicoMilhagensTeste implements ServicoMilhagens {

		private int quantidadeChamadas;

		@Override
		public void criarContas(Usuario usuario) {
			quantidadeChamadas++;
		}

	}

	public class BancoDadosUsuarioTeste implements BancoDadosUsuarios {

		private int quantidadeChamadas;

		@Override
		public Usuario cadastrar(DadosCriacaoUsuario dadosCriacaoUsuario) {
			quantidadeChamadas++;
			return usuario;
		}

	}

	private class ServicoBrindesTeste implements ServicoBrindes {

		private int quantidadeChamadas;

		@Override
		public void enviarBrinde(Usuario usuario) {
			quantidadeChamadas++;
		}
	}

	private static class DisparadorEmailsTeste implements DisparadorEmail {

		private int quantidadeChamadas;

		@Override
		public void enviar(Email email) {
			quantidadeChamadas++;
		}

	}

}
