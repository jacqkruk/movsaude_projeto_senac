
package com.senacpi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe utilitária para gerenciamento de uma unidade de persistência com JPA.
 * 
 * Responsável por fornecer uma instância de EntityManager e gerenciar sua finalização.
 * 
 * @author Jake mk
 */
public class JpaUtil {
    private static final String PERSISTENCE_UNIT =  "mov_saude";
    private static EntityManagerFactory fabrica;
    private static final ThreadLocal<EntityManager> tl = new ThreadLocal<>();
    
    static {
        try {
            Map<String, String> props = new HashMap<>();
            props.put("jakarta.persistence.jdbc.driver", Env.get("DB_DRIVER"));
            props.put("jakarta.persistence.jdbc.url", Env.get("DB_URL"));
            props.put("jakarta.persistence.jdbc.user", Env.get("DB_USER"));
            props.put("jakarta.persistence.jdbc.password", Env.get("DB_PASSWORD"));
        
        fabrica = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT, props);
        } catch (Exception e) {
            System.err.println("Erro ao inicializar EntityManagerFactory: " + e.getMessage());
        }
         
    }
    
    /**
     * Método que obtém uma instância do EntityManager.
     * 
     * Caso a fábrica ou o EntityManager estejam fechados, uma nova instância é criada.
     * 
     * @return Uma instância ativa de EntityManager ou null em caso de erro.
     */
    public static EntityManager getEntityManager() {
        EntityManager em = tl.get();
        
        try {
            if (em == null || !em.isOpen()) {
                if (fabrica == null || !fabrica.isOpen()) {
                    throw new IllegalStateException("EntityManagerFactory não está disponível.");
                }
                em = fabrica.createEntityManager();
                tl.set(em);
            }
        } catch (PersistenceException e) {
            System.err.println("Erro ao criar EntityManager: " + e.getMessage());
            return null;
        }
        return em;
    }
    
    
   /**
    * Método que fecha o EntityManager e a fábrica de persistência.
    * Deve ser chamado ao finalizar operações com banco de dados para evitar vazamento de recursos.
    */
    public static void closeEntityManager() {
        EntityManager em = tl.get();
        
        if (em != null && em.isOpen()) {
            em.close();
        }
        tl.remove();
    }
    
    public static void closeFactory() {
        if (fabrica != null && fabrica.isOpen()) {
            fabrica.close();
        }
    }
}
