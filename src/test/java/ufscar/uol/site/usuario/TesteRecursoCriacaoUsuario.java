package ufscar.uol.site.usuario;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import ufscar.uol.app.usuario.CriadorUsuarios;
import ufscar.uol.app.usuario.DadosCriacaoUsuario;
import ufscar.uol.site.usuario.FormularioCriacaoUsuario;
import ufscar.uol.site.usuario.RecursoCriacaoUsuario;

public class TesteRecursoCriacaoUsuario {

	@Test
	public void deve_criar_um_usuario() {

		// Preparando os dados para o teste
		FormularioCriacaoUsuario formularioCriacaoUsuarios = new FormularioCriacaoUsuario();
		CriadorUsuarioTeste criadorUsuariosTeste = new CriadorUsuarioTeste();

		// Executando
		RecursoCriacaoUsuario recurso = new RecursoCriacaoUsuario(criadorUsuariosTeste);
		recurso.criarUsuario(formularioCriacaoUsuarios);

		// Validando
		MatcherAssert.assertThat(criadorUsuariosTeste.chamado, CoreMatchers.is(true));
		MatcherAssert.assertThat(criadorUsuariosTeste.dadosCriacaoUsuario,
				CoreMatchers.equalTo(formularioCriacaoUsuarios));
	}

	/**
	 * Implementação de faz de conta usadas durante o teste. Há bibliotecas que
	 * reduzem a necessidade de criação desse tipo de código de apoio, exemplo
	 * Mockiot. Não iremos usá-la aqui para reduzir a quantidade de material.
	 */
	private static class CriadorUsuarioTeste implements CriadorUsuarios {

		/**
		 * Informa que o sistema foi chamado para ser usado na validação do
		 * teste.
		 */
		boolean chamado;

		/**
		 * Disponibiliza os dados que foram repassados pela classe que
		 * representa o recurso de criação de usuários para ser usado na
		 * validação do teste.
		 */
		DadosCriacaoUsuario dadosCriacaoUsuario;

		/**
		 * Fazendo de conta que estou salvando, mas na verdade está apenas
		 * guardando informações sobre a interação do recurso com o serviço.
		 */
		@Override
		public void criar(DadosCriacaoUsuario dadosCriacaoUsuario) {
			this.dadosCriacaoUsuario = dadosCriacaoUsuario;
			this.chamado = true;
		}
	}
}
