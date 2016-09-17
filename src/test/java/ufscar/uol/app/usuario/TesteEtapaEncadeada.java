package ufscar.uol.app.usuario;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class TesteEtapaEncadeada {

	@Test
	public void deve_executar_sequencia() {

		// Preparando o teste.
		Usuario usuario = new Usuario();
		AtomicInteger contador = new AtomicInteger(0);
		List<EtapaTeste> etapas = Arrays.asList(new EtapaTeste(contador), new EtapaTeste(contador),
				new EtapaTeste(contador));

		EtapaEncadeada etapaEncadeada = new EtapaEncadeada();
		etapaEncadeada.adiciona(etapas.get(0));
		etapaEncadeada.adiciona(etapas.get(1));
		etapaEncadeada.adiciona(etapas.get(2));

		
		// Executando
		etapaEncadeada.continuaProcessoCriacao(usuario);
		
		// Validando
		for (int indice = 0; indice < 3; indice++) {
			
			EtapaTeste etapa = etapas.get(indice);
			
			assertThat(etapa.chamado, equalTo(true));
			assertThat(etapa.ordem, equalTo(indice + 1));
		}

	}

	private static class EtapaTeste implements EtapaConclusaoCriacaoUsuario {

		AtomicInteger contador;
		boolean chamado;
		int ordem;

		public EtapaTeste(AtomicInteger contador) {
			this.contador = contador;
		}

		@Override
		public void continuaProcessoCriacao(Usuario usuario) {
			this.chamado = true;
			this.ordem = this.contador.incrementAndGet();
		}
	}

}
