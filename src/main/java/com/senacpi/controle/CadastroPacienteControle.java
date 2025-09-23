
package com.senacpi.controle;

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
      */
    public static void prepararEdicao(Paciente p, PacienteForm form) {
        // obter informações do paciente selecionado na tabela da tela Listagem
        String id = String.valueOf(p.getId());
        String nome = p.getNome();
        String cpf = p.getCpf();
        String email = p.getEmail();
        String tel = p.getTelefone();
        Date dataNasc = p.getDataNasc();

        // colocar essas informações nos campos da tela Cadastro
        form.getTxtId().setText(id);
        form.getTxtNome().setText(nome);
        form.getTxtCpf().setText(cpf);
        form.getTxtEmail().setText(email);
        form.getTxtTel().setText(tel);
        form.getFmtTxtNasc().setText(
                ConversorDeDatas.converteDateParaString(dataNasc));     
    }
    
    /**
     * Método que valida os campos preenchidos pelo usuário.
     * 
     * Verifica se há campos vazios ou formatos inválidos.
     * 
     * @param nome
     * @param cpf
     * @param email
     * @param tel
     * @param dataString
     * @return 
     */
    public boolean validarCampos(String nome, String cpf, String email, String tel, String dataString) {
        boolean valido = !camposVazios(nome, cpf, email, tel, dataString) 
                && !formatosInvalidos(nome, cpf, email, tel, dataString);
        
        return valido;
    }
    
    /**
     * Método que verifica se há campos com formatos inválidos.
     * 
     * Exibe mensagens de erro caso algum campo não esteja no padrão correto.
     * 
     * @param nome Nome do paciente.
     * @param cpf CPF do paciente.
     * @param email Email do paciente.
     * @param tel Telefone do paciente.
     * @param dataNasc Data de nascimento do paciente.
     * @return Retorna verdadeiro se algum campo for inválido, falso caso contrário.
     */
    public boolean formatosInvalidos(String nome, String cpf, String email, String tel, String dataNasc) {
         boolean invalido = false;
        
        // login que aceita letras maiúsculas, minúsculas, números e símbolos
        boolean validaNome = nome.matches("^[A-Za-zÀ-ÿ\\s]+$");
        // cpf no formato ###.###.###-##
        boolean validaCpf = cpf.matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$");
        // número de telefone com nove dígitos e DDD
        boolean validaTel = tel.matches("^\\(\\d{2}\\)\\d{5}-\\d{4}$"); 
        // email no formato nomeComSimbolosENumeros.email.com
        boolean validaEmail = email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        // data no formato dd/mm/aaaa
        boolean validaData = dataNasc.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$");
       
        
        if (!validaNome) {
            JOptionPane.showMessageDialog(null, "Nome deve conter somente letras.");
            invalido = true;
        } else if (!validaCpf) {
            JOptionPane.showMessageDialog(null, "CPF deve conter somente dígitos numéricos e ser no formato 999.999.999-99");
            invalido = true;
        }  else if (!validaData) {
            JOptionPane.showMessageDialog(null, "Data de nascimento deve ser no formato dd/mm/aaaa.");
            invalido = true;
        } else if (!validaEmail) {
            JOptionPane.showMessageDialog(null, "ATENÇÃO! Digite um email válido.");
            invalido = true;
        } else if (!validaTel) {
            JOptionPane.showMessageDialog(null, "Telefone deve conter somente dígitos numéricos e ser no formato (99)99999-9999.");
            invalido = true;
        }
        return invalido;
    }
    
    /**
     * Método que verifica se os campos obrigatórios estão vazios.
     * 
     * Caso haja campos vazios, retorna uma mensagem de sugestão de preenchimento ao usuário.
     * 
     * @param nome Nome do paciente.
     * @param cpf CPF do paciente.
     * @param email Email do paciente.
     * @param tel Telefone do paciente.
     * @param dataNasc Data de nascimento do paciente.
     * @return 
     */
    public boolean camposVazios(String nome, String cpf, String email, String tel, String dataNasc) {
        boolean vazio = false;
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo nome.");
            vazio = true;
        } else if (cpf.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo CPF.");
            vazio = true;
        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo email.");
            vazio = true;
        } else if (tel.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo telefone.");
            vazio = true;
        } else if (dataNasc.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o campo data de nascimento.");
            vazio = true;
        }
       return vazio;
    }
    
}
