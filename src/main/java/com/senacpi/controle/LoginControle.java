
package com.senacpi.controle;

/**
 * Classe responsável pelo controle da listagem de funcionários.
 * 
 * Contém os métodos formatosInvalidos, camposVazios
 * 
 * @author Jake mk
 */
import javax.swing.JOptionPane;

public class LoginControle {
    
    /**
     * Método que verifica se há formatos inválidos nos campos preenchidos.
     * 
     * @param login Login do usuário.
     * @param senha Senha do usuário.
     * @return 
     */
    public boolean formatosInvalidos(String login, String senha) {
        boolean invalido = false;
        
        // login que aceita letras maiúsculas, minúsculas, números e símbolos
        boolean validaLogin = login.matches("^[a-zA-Z0-9._%+-]+$");
        // senha de três dígitos numéricos
        boolean validaSenha = senha.matches("^\\d{4}$");
        
        if (!validaLogin) {
            JOptionPane.showMessageDialog(null, "ATENÇÃO! Digite um usuário válido.");
            invalido = true;
        } else if (!validaSenha) {
            JOptionPane.showMessageDialog(null, "ATENÇÃO! Digite uma senha válida.");
            invalido = true;
        }

        return invalido;
    }
    
    /**
     * Método que verifica se há campos vazios nos campos preenchidos.
     * 
     * @param login Login do usuário.
     * @param senha Senha do usuário.
     * @return 
     */
    public boolean camposVazios(String login, String senha) {
       boolean vazio = false;
       if (login.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo usuário.");
            vazio = true;
        }else if (senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo senha.");
            vazio = true;
        }
       
       return vazio;
    }
}
