
package com.senacpi.controle;

import com.senacpi.modelo.Funcionario;
import com.senacpi.tela.CadFuncTela;
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
public class CadFuncControle {
    
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
            Logger.getLogger(CadFuncTela.class.getName()).log(Level.SEVERE, null, ex);
        }

        return novoFuncionario;
    }
    
    /**
      * Método que prepara a edição dos dados de um paciente.
      * preenche os campos da tela de cadastro com os dados do funcionário selecionado.
      * @param f Objeto funcionário com os dados atuais.
     * @param txtId
      * @param cboxSetor ComboBox para o setor do funcionário.
      * @param txtNome Campo de texto para o nome do funcionário.
      * @param txtCpf Campo de texto para o CPF do funcionário.
      * @param txtEmail Campo de texto para o email do funcionário.
      * @param txtTel Campo de texto para o telefone do funcionário.
      * @param fmtTxtNasc Campo de texto formatado para a data de nascimento do funcionário.
      */
    public static void prepararEdicao(Funcionario f, JTextField txtId, JComboBox cboxSetor, JTextField txtNome, JTextField txtCpf, JTextField txtEmail, JTextField txtTel, JFormattedTextField fmtTxtNasc) {
        // obter informações do paciente selecionado na tabela da tela Listagem
        String id = String.valueOf(f.getId());
        String nome = f.getNome();
        String cpf = f.getCpf();
        String email = f.getEmail();
        String tel = f.getTelefone();
        Date nasc = f.getDataNasc();
        String setor = f.getSetor();
        
        // colocar essas informações nos campos da tela Cadastro
        txtId.setText(id);
        txtNome.setText(nome);
        txtCpf.setText(cpf);
        txtEmail.setText(email);
        txtTel.setText(tel);
        cboxSetor.setSelectedItem(setor);
        
        SimpleDateFormat sdf = new SimpleDateFormat();
        fmtTxtNasc.setText(sdf.format(nasc));
    }
}
