package com.senacpi.tela;

import javax.swing.JButton;

/**
 *
 * @author Jake mk
 */
public class BotoesInicio {
   
    public JButton btnCadFunc;
    public JButton btnListaFunc;
    public JButton btnCadPaci;
    public JButton btnListaPaci;

    public BotoesInicio(JButton btnCadFunc, JButton btnListaFunc, JButton btnCadPaci, JButton btnListaPaci) {
        this.btnCadFunc = btnCadFunc;
        this.btnListaFunc = btnListaFunc;
        this.btnCadPaci = btnCadPaci;
        this.btnListaPaci = btnListaPaci;
    }

    public JButton getBtnCadFunc() {
        return btnCadFunc;
    }

    public JButton getBtnListaFunc() {
        return btnListaFunc;
    }

    public JButton getBtnCadPaci() {
        return btnCadPaci;
    }

    public JButton getBtnListaPaci() {
        return btnListaPaci;
    }

}
