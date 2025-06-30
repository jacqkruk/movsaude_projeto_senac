
package com.senacpi.dao;

import com.senacpi.modelo.Paciente;
import jakarta.persistence.EntityManager;

/**
 * Classe responsável pelo gerenciamento de operações de persistência para Paciente.
 * 
 * Contém os métodos cadastrar, editar, obter, excluir.
 * 
 * @author Jake mk
 */
public class PacienteDao {
    
    /**
     * Cadastra um novo paciente no banco de dados.
     * 
     * @param p O paciente a ser cadastrado.
     */
    public void cadastrar(Paciente p) {
        EntityManager em = JpaUtil.getEntityManager();
         try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        finally {
            JpaUtil.closeEntityManager();
        }
    }
    
    /**
     * Edita um paciente existente no banco de dados.
     * 
     * @param p O paciente com as informações atualizadas.
     */
    public void editar (Paciente p) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally { 
            JpaUtil.closeEntityManager();
        }
    }
    
    /**
     * Obtém um paciente pelo seu ID.
     * 
     * @param id O ID do paciente.
     * @return  O paciente correspondente ao ID, ou null se não encontrado.
     */
    public Paciente obter(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.find(Paciente.class, id);
        } finally {
            JpaUtil.closeEntityManager();
        }
    }
    
    /**
     * Exclui um paciente do banco de dados pelo seu ID.
     * 
     * @param id O ID do paciente a ser excluído.
     */
    public void excluir(int id) {
    EntityManager em = JpaUtil.getEntityManager();
        try {
            Paciente p = em.find(Paciente.class, id);
            if (p != null) {
                em.getTransaction().begin();
                em.remove(p);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        finally {
            JpaUtil.closeEntityManager();
        }
    }
}
