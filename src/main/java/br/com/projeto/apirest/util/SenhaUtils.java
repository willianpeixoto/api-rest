package br.com.projeto.apirest.util;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaUtils {
	
	/**
	 * Gera um hash utilizando o BCrypt.
	 * 
	 * @param senha
	 * @return
	 */
	/*public static String gerarBCrypt(String senha) {
		if(senha == null) {
			return null;
		}
		return new BCryptPasswordEncoder().encode(senha);
	}*/
	
	/**
	 * Verifica se a senha é válida.
	 * 
	 * @param senha
	 * @param senhaEncoded
	 * @return
	 */
	/*public static Boolean validaSenha(String senha, String senhaEncoded) {
		return new BCryptPasswordEncoder().matches(senha, senhaEncoded);
	}*/

}
