
package com.senacpi.controle;

import com.senacpi.modelo.Funcionario;
import com.senacpi.tela.FuncionarioForm;
import java.util.Date;
import javax.swing.JComboBox;
import util.ConversorDeDatas;

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
     * @param form
     * @return Retorna um objeto Funcionario com os atributos preenchidos.
     */
    public static Funcionario prepararCadastro(FuncionarioForm form) {
       
        String setor = form.getCboxSetor().getSelectedItem().toString();
        String nome = form.getTxtNome().getText();
        String cpf = form.getTxtCpf().getText();
        String email = form.getTxtEmail().getText();
        String tel = form.getTxtTel().getText();
        String dataString = form.getFmtTxtNasc().getText();
        Date dataNasc = ConversorDeDatas.converteStringParaDate(dataString);
        
        // cria objeto Funcionario que vai receber o input do usuario
        Funcionario novoFuncionario = new Funcionario();
        
        // seta os atributos do objeto novoFuncionario
        novoFuncionario.setNome(nome);
        novoFuncionario.setCpf(cpf);
        novoFuncionario.setEmail(email);
        novoFuncionario.setTelefone(tel);
        novoFuncionario.setSetor(setor);
        novoFuncionario.setDataNasc(dataNasc);
        //novoFuncionario.setCrp(crp);
        
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
        form.getFmtTxtNasc().setText(
            ConversorDeDatas.converteDateParaString(nasc));
        form.getCboxSetor().setSelectedItem(setor);
        
    }
}
