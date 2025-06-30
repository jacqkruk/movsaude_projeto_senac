
package com.senacpi.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Classe que representa um usuário no sistema.
 * 
 * Contém informações como identificador, nome, login, senha e perfil de acesso. 
 * @author Jake mk
 */
@Entity
public class Usuario {
    
    /** Identificador único do usuário, gerado automaticamente pelo banco de dados. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    /** Nome completo do usuário */
    private String nome;
    
    /** Login do usuário para autenticação. */
    private String login;
    
    /** Senha do usuário para autenticação. */
    private String senha;
    
    /** Perfil do usuário que define suas permissões no sistema */
    private String perfil;

    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
