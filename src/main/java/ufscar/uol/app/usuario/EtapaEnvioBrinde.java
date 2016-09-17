package ufscar.uol.app.usuario;

/**
 * Implementação do processo de envio de brindes na conclusão do cadastro do
 * usuário.
 */
public class EtapaEnvioBrinde implements EtapaConclusaoCriacaoUsuario {

	/**
	 * Executa toda a lógica necessária para enviar o brindo, como por exemplo:
	 * qual o brinde enviado atualmente; temos esse item em estoque; como
	 * descubro o endereço do usuário; como falo com o correio ou imprimo
	 * etiqueta:
	 */
	@Override
	public void continuaProcessoCriacao(Usuario usuario) {

		System.out.println("Executando lógica de envio de brindes para o usuário" + usuario);

	}

}
