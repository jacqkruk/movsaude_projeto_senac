
package com.senacpi.controle;

import com.senacpi.dao.ListaPacienteDao;
import com.senacpi.modelo.Paciente;
import com.senacpi.modelo.Usuario;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jake mk
 */
public class ListaPacienteControle {
    /**
     * Método que realiza uma pesquisa dinâmica de pacientes com base no texto inserido.
     * 
     * @param txtPesquisa Campo de texto onde o usuário digita a pesquisa.
     * @param tblPacientes  Tabela onde os resultados da pesquisa serão exibidos.
     */
    public static void pesquisaFiltroDinamico(JTextField txtPesquisa, JTable tblPacientes) {
        String pesquisa = txtPesquisa.getText();

        try {
            ListaPacienteDao listaDao = new ListaPacienteDao();
            //sem a linha abaixo dá erro 
            ListaPacienteControle lControle = new ListaPacienteControle();
            
            List<Paciente> lista = listaDao.pesquisar(pesquisa);

            lControle.preencherTabela(lista, tblPacientes);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu uma falha:\n" + e.getMessage());
        }
    }
    
    /** Método que preenche a tabela de pacientes com os dados obtidos da pesquisa.
     * 
     * @param pacientes Lista de pacientes a serem exibidos na tabela.
     * @param tabela Tabela onde os dados serão inseridos.
     */
     public void preencherTabela(List<Paciente> pacientes, JTable tabela) {
        String colunas[] = {"Id", "Nome", "CPF", "Email", "Telefone", "Nascimento"};
        String dados[][] = new String[pacientes.size()][colunas.length];
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        int i = 0;
        for (Paciente f : pacientes) {
            dados[i] = new String[] {
                String.valueOf(f.getId()),
                f.getNome(),
                f.getCpf(),
                f.getEmail(),
                f.getTelefone(),
                sdf.format(f.getDataNasc())
            };
            
            i++;
        }
        DefaultTableModel modelo = new DefaultTableModel(dados, colunas);
        tabela.setModel(modelo);
    }
     
    /**
     * Método que habilita ou desabilita botões de edição e exclusão de acordo com o perfil do usuário.
     * 
     * Apenas administradores podem excluir pacientes.
     * Administradores e financeiro podem editar pacientes.
     * 
     * @param usuario Objeto Usuario que contém as informações do perfil.
     * @param btnEditar Botão de edição de pacientes.
     * @param btnExcluir Botão de exclusão de pacientes.
     */
    public void habilitarBotoes(Usuario usuario, JButton btnEditar, JButton btnExcluir) {
        String perfil = usuario.getPerfil();
        
        // se o tipo de usuário for admin, habilitar botão Excluir e Editar
        if (perfil.equals("admin")) {
            btnEditar.setEnabled(true);
            btnExcluir.setEnabled(true);
        } else if (perfil.equals("fin")){ 
            btnEditar.setEnabled(true);
            btnExcluir.setEnabled(false);
        } else {
            btnEditar.setEnabled(false);
            btnExcluir.setEnabled(false);
        }
    }
}
