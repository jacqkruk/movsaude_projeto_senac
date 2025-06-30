
package com.senacpi.modelo;

/**
 *
 * @author Jake mk
 */

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.util.Date;

/** Classe base abstrata para entidades que representam pessoas.
 * 
 * Anotada com @MappedSuperclass para servir como superclasse das entidades 
 * persistentes, como Funcionário e Paciente.
 * Contém atributos id, nome, CPF, email, telefone e data de nascimento.
 * 
 * @author Jake mk
 */
@MappedSuperclass
abstract public class Pessoa {
    
    /** Identificador único da pessoa, gerado automaticamente pelo banco de dados. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    
    protected String nome;
    protected String cpf;
    protected String email;
    protected String telefone;
    
    @Column(name = "data_nascimento")
    protected Date dataNasc;

    /** Construtor padrão obrigatório para Hibernate. */
    public Pessoa() {
        
    }
    
    /**
     * Construtor completo com todos os atributos da pessoa.
     * 
     * @param nome
     * @param cpf
     * @param email
     * @param telefone
     * @param dataNasc 
     */
    public Pessoa(String nome, String cpf, String email, String telefone, Date dataNasc) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
    }
    
    // Getters e setters
    public int getId() {
        return id;
        
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
}

