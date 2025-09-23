
package com.senacpi.dao;

import com.senacpi.modelo.Funcionario;
import jakarta.persistence.EntityManager;

/**
 * Classe responsável pelo gerenciamento de operações de persistência para Funcionário.
 * 
 * Contém os métodos cadastrar, editar, obter, excluir.
 * 
 * @author Jake mk
 */
public class FuncionarioDao {

    /**
     * Cadastra um novo funcionário no banco de dados.
     * 
     * @param f O funcionário a ser cadastrado.
     */
    public void cadastrar(Funcionario f) {
        EntityManager em = JpaUtil.getEntityManager();
         try {
            em.getTransaction().begin();
            em.persist(f);
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
     * Edita um funcionário existente no banco de dados.
     * 
     * @param f O funcionário com as informações atualizadas.
     */
    public void editar (Funcionario f) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(f);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally { 
            JpaUtil.closeEntityManager();
        }
    }
    
    /**
     * Obtém um funcionário pelo seu ID.
     * 
     * @param id O ID do funcionário.
     * @return  O funcionário correspondente ao ID, ou null se não encontrado.
     */
    public Funcionario obter(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.find(Funcionario.class, id);
        } finally {
            JpaUtil.closeEntityManager();
        }
    }
    
    /**
     * Exclui um funcionário do banco de dados pelo seu ID.
     * 
     * @param id O ID do funcionário a ser excluído.
     */
    public void excluir(int id) {
    EntityManager em = JpaUtil.getEntityManager();
        try {
            Funcionario f = em.find(Funcionario.class, id);
            if (f != null) {
                em.getTransaction().begin();
                em.remove(f);
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
