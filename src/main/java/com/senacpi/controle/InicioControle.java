
package com.senacpi.controle;

import com.senacpi.modelo.Usuario;
import javax.swing.JButton;

/**
 * Classe responsável pelo controle da Tela de Início.
 * 
 * Contém o método habilitarBotoes.
 * 
 * @author Jake mk
 */
public class InicioControle {
    
    /**
     * Método que habilita ou desabilita botões da interface conforme o perfil do usuário.
     * 
     * @param usuario Objeto Usuario que contém as informações do perfil.
     * @param btnCadFunc Botão para cadastro de funcionários.
     * @param btnListaFunc Botão para listagem de funcionários.
     * @param btnCadPaci Botão para cadastro de pacintes.
     * @param btnListaPaci Botão para listagem de pacientes.
     */
    public void habilitarBotoes(Usuario usuario, JButton btnCadFunc, JButton btnListaFunc, JButton btnCadPaci, JButton btnListaPaci) {
        
        String perfil = usuario.getPerfil();
        
        // se o tipo de usuário for admin, habilitar botão Excluir
        if (perfil.equals("psi")) {
            btnCadFunc.setEnabled(false);
            btnCadPaci.setEnabled(false);
            btnListaFunc.setEnabled(false);
            btnListaPaci.setEnabled(true);
            
        } else if (perfil.equals("fin")) { 
            btnListaFunc.setEnabled(false);
            btnListaPaci.setEnabled(true);
            btnCadFunc.setEnabled(false);
            btnCadPaci.setEnabled(true);
        }
    }
}
