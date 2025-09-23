
package com.senacpi.controle;

import com.senacpi.dao.ListaFuncionarioDao;
import com.senacpi.modelo.Funcionario;
import com.senacpi.modelo.Usuario;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Classe responsável pelo controle da listagem de funcionários.
 * 
 * Contém os métodos para pesquisa dinâmica, preenchimento da tabela e habiliatação de botões de acordo com o perfil do usuário.
 * 
 * @author Jake mk
 */
public class ListaFuncionarioControle {
    
    /**
     * Método que realiza uma pesquisa dinâmica de funcionários com base no texto inserido.
     * 
     * @param txtPesquisa Campo de texto onde o usuário digita a pesquisa.
     * @param tblFuncionarios  Tabela onde os resultados da pesquisa serão exibidos.
     */
    public static void pesquisaFiltroDinamico(JTextField txtPesquisa, JTable tblFuncionarios) {
        String pesquisa = txtPesquisa.getText();

        try {
            ListaFuncionarioDao listaDao = new ListaFuncionarioDao();
            //sem a linha abaixo dá erro 
            ListaFuncionarioControle lControle = new ListaFuncionarioControle();
            
            List<Funcionario> lista = listaDao.pesquisar(pesquisa);

            lControle.preencherTabela(lista, tblFuncionarios);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu uma falha:\n" + e.getMessage());
        }
    }
    
    /** Método que preenche a tabela de funcionários com os dados obtidos da pesquisa.
     * 
     * @param funcionarios Lista de funcionários a serem exibidos na tabela.
     * @param tabela Tabela onde os dados serão inseridos.
     */
     public void preencherTabela(List<Funcionario> funcionarios, JTable tabela) {
        String colunas[] = {"Id", "Nome", "CPF", "Setor", "Email", "Telefone", "Nascimento"};
        String dados[][] = new String[funcionarios.size()][colunas.length];
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        int i = 0;
        for (Funcionario f : funcionarios) {
            dados[i] = new String[] {
                String.valueOf(f.getId()),
                f.getNome(),
                f.getCpf(),
                f.getSetor(),
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
     * Apenas administradores podem editar ou excluir funcionários.
     * 
     * @param usuario Objeto Usuario que contém as informações do perfil.
     * @param btnEditar Botão de edição de funcionários.
     * @param btnExcluir Botão de exclusão de funcionários.
     */
    public void habilitarBotoes(Usuario usuario, JButton btnEditar, JButton btnExcluir) {
        String perfil = usuario.getPerfil();
        
        // se o tipo de usuário for admin, habilitar botão Excluir e Editar
        if (perfil.equals("admin")) {
            btnEditar.setEnabled(true);
            btnExcluir.setEnabled(true);
        } else { 
            btnEditar.setEnabled(false);
            btnExcluir.setEnabled(false);
        }
    }
}
