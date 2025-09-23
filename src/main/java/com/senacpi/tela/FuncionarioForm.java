package com.senacpi.tela;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class FuncionarioForm {
    private JTextField txtId;
    private JComboBox cboxSetor;
    private JTextField txtNome;
    private JTextField txtCpf;
    private JTextField txtEmail;
    private JTextField txtTel;
    private JFormattedTextField fmtTxtNasc;

    public FuncionarioForm(JTextField txtId, JComboBox cboxSetor, 
                        JTextField txtNome, JTextField txtCpf, JTextField txtEmail, 
                        JTextField txtTel, JFormattedTextField fmtTxtNasc) {
        this.txtId = txtId;
        this.cboxSetor = cboxSetor;
        this.txtNome = txtNome;
        this.txtCpf = txtCpf;
        this.txtEmail = txtEmail;
        this.txtTel = txtTel;
        this.fmtTxtNasc = fmtTxtNasc;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JComboBox getCboxSetor() {
        return cboxSetor;
    }

    public void setCboxSetor(JComboBox cboxSetor) {
        this.cboxSetor = cboxSetor;
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public void setTxtNome(JTextField txtNome) {
        this.txtNome = txtNome;
    }

    public JTextField getTxtCpf() {
        return txtCpf;
    }

    public void setTxtCpf(JTextField txtCpf) {
        this.txtCpf = txtCpf;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public JTextField getTxtTel() {
        return txtTel;
    }

    public void setTxtTel(JTextField txtTel) {
        this.txtTel = txtTel;
    }

    public JFormattedTextField getFmtTxtNasc() {
        return fmtTxtNasc;
    }

    public void setFmtTxtNasc(JFormattedTextField fmtTxtNasc) {
        this.fmtTxtNasc = fmtTxtNasc;
    }

   

    
    
}
