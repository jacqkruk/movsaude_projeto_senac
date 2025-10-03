
package com.senacpi.controle;

import com.senacpi.dao.PacienteDao;
import com.senacpi.modelo.Paciente;
import com.senacpi.tela.PacienteForm;
import java.util.Date;
import javax.swing.JOptionPane;
import util.ConversorDeDatas;

/**
 * Classe responsável pelo controle do cadastro de funcionários.
 * 
 * Contém os métodos prepararCadastro, prepararEdicao, validarCampos, camposVazios e formatosInvalidos.
 * 
 * @author Jake mk
 */
public class CadastroPacienteControle {
    
    /**
     *  Método que prepara um objeto Funcionario para cadastro com os dados informados pelo usuário.
     * 
     * @param form
     * @return Retorna um objeto Paciente com os atributos preenchidos.
     */
    public static Paciente prepararCadastro(PacienteForm form) {
        String nome = form.getTxtNome().getText();
        String cpf = form.getTxtCpf().getText();
        String email = form.getTxtEmail().getText();
        String tel = form.getTxtTel().getText();
        String dataString = form.getFmtTxtNasc().getText();
        Date dataNasc = ConversorDeDatas.converteStringParaDate(dataString);
        /*
        String nome = txtNome.getText();
        String cpf = txtCpf.getText();
        String email = txtEmail.getText();
        String tel = txtTel.getText();
        */
        
        // cria objeto Paciente que vai receber o input do usuario
        Paciente novoPaciente = new Paciente();
        
        // seta os atributos do objeto novoPaciente
        novoPaciente.setNome(nome);
        novoPaciente.setCpf(cpf);
        novoPaciente.setEmail(email);
        novoPaciente.setTelefone(tel);
        novoPaciente.setDataNasc(dataNasc);
        
        return novoPaciente;
    }
     
    /**
     * Método que prepara a edição dos dados de um paciente.
     * preenche os campos da tela de cadastro com os dados do paciente selecionado.
     * @param p Objeto paciente com os dados atuais.
     * @param form
     */
    public static void prepararEdicao(Paciente p, PacienteForm form) {
        // obtém informações do paciente selecionado na tabela da tela Listagem
        String id = String.valueOf(p.getId());
        String nome = p.getNome();
        String cpf = p.getCpf();
        String email = p.getEmail();
        String tel = p.getTelefone();
        Date dataNasc = p.getDataNasc();

        // coloca essas informações nos campos da tela Cadastro
        form.getTxtId().setText(id);
        form.getTxtNome().setText(nome);
        form.getTxtCpf().setText(cpf);
        form.getTxtEmail().setText(email);
        form.getTxtTel().setText(tel);
        form.getFmtTxtNasc().setText(
            ConversorDeDatas.converteDateParaString(dataNasc));     
    }
    
    //faz o cadastro do objeto Paciente
    public void cadastrarPaciente(Paciente novoPaciente, Paciente pacienteEdicao) {
        PacienteDao pacienteDao = new PacienteDao();
        
        if (pacienteEdicao == null) {
            pacienteDao.cadastrar(novoPaciente);
            // mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso.");

            // edita o objeto Paciente existente
        } else {
            pacienteDao.editar(pacienteEdicao);
            // mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Paciente atualizado com sucesso.");
        }
    }
    
}