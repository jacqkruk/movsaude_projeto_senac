/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senacpi.tela;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 *
 * @author Jake mk
 */
public class PacienteForm {
    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtCpf;
    private JTextField txtEmail;
    private JTextField txtTel;
    private JFormattedTextField fmtTxtNasc;

    public PacienteForm() {
    }

    public PacienteForm(JTextField txtId, JTextField txtNome, JTextField txtCpf, JTextField txtEmail, JTextField txtTel, JFormattedTextField fmtTxtNasc) {
        this.txtId = txtId;
        this.txtNome = txtNome;
        this.txtCpf = txtCpf;
        this.txtEmail = txtEmail;
        this.txtTel = txtTel;
        this.fmtTxtNasc = fmtTxtNasc;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public JTextField getTxtCpf() {
        return txtCpf;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JTextField getTxtTel() {
        return txtTel;
    }

    public JFormattedTextField getFmtTxtNasc() {
        return fmtTxtNasc;
    }
    
    
}
