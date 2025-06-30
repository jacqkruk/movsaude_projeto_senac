
package com.senacpi.modelo;

import jakarta.persistence.Entity;
import java.util.Date;

/**
 *  Entidade que representa um paciente no sistema.
 * 
 * Herda atributos e comportamentos da classe Pessoa (nome, CPF, email, telefone e data de nascimento).
 * @author Jake mk
 */
@Entity
public class Paciente extends Pessoa {
       
    /**
     * Construtor completo com todos os atributos da pessoa.
     * 
     * @param nome
     * @param cpf
     * @param email
     * @param telefone
     * @param dataNasc 
     */
    public Paciente(String nome, String cpf, String email, String telefone, Date dataNasc) {
        super(nome, cpf, email, telefone, dataNasc);
    }

    /** Construtor padrão obrigatório para Hibernate. */
    public Paciente() {
    }

}
