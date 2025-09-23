
package com.senacpi.controle;

import com.senacpi.modelo.Funcionario;
import com.senacpi.tela.CadastroFuncionarioTela;
import com.senacpi.tela.FuncionarioForm;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 * Classe responsável pelo controle do cadastro de funcionários.
 * 
 * Contém os métodos preencherComboSetor e prepararCadastro.
 * 
 * @author Jake mk
 */
public class CadastroFuncionarioControle {
    
    /**
     * Método para preencher um JComboBox com opções de setores disponíveis.
     * 
     * @param cbox 
     */
    public static void preencherComboSetor(JComboBox cbox) {
        cbox.addItem("psicologia");
        cbox.addItem("financeiro");
    }
    
    /**
     * Método que prepara um objeto Funcionario para cadastro com os dados informados pelo usuário.
     * 
     * @param cboxSetor ComboBox contendo o setor do funcionário.
     * @param txtNome Campo de texto para o nome do funcionário.
     * @param txtCpf Campo de texto para o Cpf do funcionário.
     * @param txtEmail Campo de texto para o email do funcionário.
     * @param txtTel Campo de texto para o Teledone do funcionário.
     * @param fmtTxtNasc Campo de texto para a data de nascimento do funcionário.
     * @return Retorna um objeto Funcionario com os atributos preenchidos.
     */
    public static Funcionario prepararCadastro(JComboBox cboxSetor, JTextField txtNome,
            JTextField txtCpf, JTextField txtEmail, JTextField txtTel,
            JFormattedTextField fmtTxtNasc) {
       
        String setor = cboxSetor.getSelectedItem().toString();
        String nome = txtNome.getText();
        String cpf = txtCpf.getText();
        String email = txtEmail.getText();
        String tel = txtTel.getText();
        
        // cria objeto Funcionario que vai receber o input do usuario
        Funcionario novoFuncionario = new Funcionario();
        
        // seta os atributos do objeto novoFuncionario
        novoFuncionario.setNome(nome);
        novoFuncionario.setCpf(cpf);
        novoFuncionario.setEmail(email);
        novoFuncionario.setTelefone(tel);
        novoFuncionario.setSetor(setor);
        //novoFuncionario.setCrp(crp);
        
        // formatar data
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            novoFuncionario.setDataNasc(sdf.parse(fmtTxtNasc.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(CadastroFuncionarioTela.class.getName()).log(Level.SEVERE, null, ex);
        }

        return novoFuncionario;
    }
    
    /**
      * Método que prepara a edição dos dados de um paciente.
      * preenche os campos da tela de cadastro com os dados do funcionário selecionado.
      * @param f Objeto funcionário com os dados atuais.
      * @param form 
      */
    public static void prepararEdicao(Funcionario f, FuncionarioForm form) {
        // obter informações do paciente selecionado na tabela da tela Listagem
        String id = String.valueOf(f.getId());
        String nome = f.getNome();
        String cpf = f.getCpf();
        String email = f.getEmail();
        String tel = f.getTelefone();
        Date nasc = f.getDataNasc();
        String setor = f.getSetor();
        
        // colocar essas informações nos campos da tela Cadastro
        form.getTxtId().setText(id);
        form.getTxtNome().setText(nome);
        form.getTxtCpf().setText(cpf);
        form.getTxtEmail().setText(email);
        form.getTxtTel().setText(tel);
        form.getCboxSetor().setSelectedItem(setor);
        
        SimpleDateFormat sdf = new SimpleDateFormat();
        form.getFmtTxtNasc().setText(sdf.format(nasc));
    }
}
