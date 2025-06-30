
package com.senacpi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

/**
 * Classe utilitária para gerenciamento de uma unidade de persistência com JPA.
 * 
 * Responsável por fornecer uma instância de EntityManager e gerenciar sua finalização.
 * 
 * @author Jake mk
 */
public class JpaUtil {
    private static final String PERSISTENCE_UNIT =  "mov_saude";
    private static EntityManager em;
    private static EntityManagerFactory fabrica;
    
    /**
     * Método que obtém uma instância do EntityManager.
     * 
     * Caso a fábrica ou o EntityManager estejam fechados, uma nova instância é criada.
     * 
     * @return Uma instância ativa de EntityManager ou null em caso de erro.
     */
    public static EntityManager getEntityManager() {
        try {
            if (fabrica == null || !fabrica.isOpen()) {
                fabrica = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            }
            if (em == null || !em.isOpen()) {
                em = fabrica.createEntityManager();
        } 
            return em; 
        } catch (PersistenceException e) {
            return null;
        }
    }
    
    
   /**
    * Método que fecha o EntityManager e a fábrica de persistência.
    * Deve ser chamado ao finalizar operações com banco de dados para evitar vazamento de recursos.
    */
    public static void closeEntityManager() {
        if (em.isOpen() && em != null) {
            em.close();
            fabrica.close();
        }
    }  
}
