package ufscar.uol.site.usuario;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import ufscar.uol.app.usuario.BancoDadosUsuarios;
import ufscar.uol.app.usuario.CriadorUsuariosPadrao;
import ufscar.uol.app.usuario.DadosCriacaoUsuario;
import ufscar.uol.app.usuario.EtapaConclusaoCriacaoUsuario;
import ufscar.uol.app.usuario.Usuario;

public class TesteCriadorUsuariosPadrao {

	private Usuario usuario = new Usuario();

	@Test
	public void deve_criar_usuario() {

		// Preparação do teste
		DadosCriacaoUsuario dados = new DadosParaTeste();

		BancoDadosUsuarioTeste bancoDadosUsuarioTeste = new BancoDadosUsuarioTeste();
		EtapaTeste etapaTeste = new EtapaTeste();

		// Executando o teste
		CriadorUsuariosPadrao criadorUsuarioPadrao = new CriadorUsuariosPadrao(bancoDadosUsuarioTeste, etapaTeste);
		criadorUsuarioPadrao.criar(dados);

		// Validação
		assertThat(bancoDadosUsuarioTeste.quantidadeChamadas, equalTo(1));
		assertThat(etapaTeste.quantidadeChamadas, equalTo(1));
	}

	/******************************************************************************
	 * Implementações de faz de conta usadas durante o teste. Há bibliotecas que
	 * reduzem a necessidade de criação desse tipo de código de apoio, exemplo
	 * Mockiot. Não iremos usá-la aqui para reduzir a quantidade de material.
	 ******************************************************************************/

	private static class DadosParaTeste implements DadosCriacaoUsuario {

	}

	private static class EtapaTeste implements EtapaConclusaoCriacaoUsuario {

		private int quantidadeChamadas;

		@Override
		public void continuaProcessoCriacao(Usuario usuario) {
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
}
