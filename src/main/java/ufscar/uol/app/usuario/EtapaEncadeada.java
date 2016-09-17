package ufscar.uol.app.usuario;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementação que permite encadear uma sequencia de atividades no processo de
 * continuação da criação do usuário.
 */
public class EtapaEncadeada implements EtapaConclusaoCriacaoUsuario {

	/**
	 * Lista de etapas a serem executadas.
	 */
	private List<EtapaConclusaoCriacaoUsuario> etapa = new LinkedList<>();

	/**
	 * Adiciona uma etapa na cadeia.
	 * 
	 * @param etapaConclusaoCriacaoUsuario
	 *            A etapa a ser executada.
	 */
	public void adiciona(EtapaConclusaoCriacaoUsuario etapaConclusaoCriacaoUsuario) {
		this.etapa.add(etapaConclusaoCriacaoUsuario);
	}

	/**
	 * Executa cada elemento da sequencia de atividades do processo de conclusão
	 * de novo cadastro.
	 */
	@Override
	public void continuaProcessoCriacao(Usuario usuario) {

		for (EtapaConclusaoCriacaoUsuario etapaConclusaoCriacaoUsuario : etapa) {
			etapaConclusaoCriacaoUsuario.continuaProcessoCriacao(usuario);
		}
	}

}
