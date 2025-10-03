
package com.senacpi.controle;

import com.senacpi.modelo.Usuario;
import com.senacpi.tela.BotoesInicio;

/**
 * Classe responsável pelo controle da Tela de Início.
 * 
 * Contém o método habilitarBotoes.
 * 
 * @author Jake mk
 */
public class MenuControle {
    
    /**
     * Método que habilita ou desabilita botões da interface conforme o perfil do usuário.
     * 
     * @param usuario Objeto Usuario que contém as informações do perfil.
     * @param botoes
     */
    public void habilitarBotoes(Usuario usuario, BotoesInicio botoes) {
        
        String perfil = usuario.getPerfil();
        
        // se o tipo de usuário for admin, habilitar botão Excluir
        if (perfil.equals("psi")) {
            botoes.getBtnCadFunc().setEnabled(false);
            botoes.getBtnCadPaci().setEnabled(false);
            botoes.getBtnListaFunc().setEnabled(false);
            botoes.getBtnListaPaci().setEnabled(true);
            
        } else if (perfil.equals("fin")) { 
            botoes.getBtnListaFunc().setEnabled(false);
            botoes.getBtnListaPaci().setEnabled(true);
            botoes.getBtnCadFunc().setEnabled(false);
            botoes.getBtnCadPaci().setEnabled(true);
        }
    }
}
