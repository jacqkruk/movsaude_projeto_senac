
package com.senacpi.modelo;

import jakarta.persistence.Entity;

/**
 * Entidade que representa um funcionário no sistema.
 * 
 * Herda atributos e comportamentos da classe Pessoa (nome, CPF, email, telefone e data de nascimento)
 * e adiciona o campo específico 'setor', que indica o departamento de atuação do funcionário.
 * 
 * @author Jake mk
 */
@Entity
public class Funcionario extends Pessoa {
    private String setor;

    /** Construtor padrão obrigatório para Hibernate. */
    public Funcionario() {
        
    }
   
    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "Nome: " + nome;
    }
}
