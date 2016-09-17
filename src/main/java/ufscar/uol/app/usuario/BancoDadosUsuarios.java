package ufscar.uol.app.usuario;

/**
 * Abstração do banco de dados que guarda informações do usuário.
 */
public interface BancoDadosUsuarios {

	Usuario cadastrar(DadosCriacaoUsuario dadosCriacaoUsuario);

}
