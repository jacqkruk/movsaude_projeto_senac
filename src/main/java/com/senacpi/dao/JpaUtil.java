
package com.senacpi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe utilitária para gerenciamento da unidade de persistência com JPA.
 * 
 * Responsável por fornecer uma instância de EntityManager e gerenciar sua finalização.
 * Utiliza {@link ThreadLocal} para que cada thread tenha sua própria instância de {@code EntityManager}, evitando conflitos em ambientes concorrentes.
 * 
 * As configurações de conexão são carregadas dinamicamente a partir de variáveis de ambiente por meio da classe {@code Env}.
 * 
 * <p>Importante: é necessário chamar {@link #closeEntityManager()} ao final de cada operação para liberar os recursos corretamente. <p>
 * 
 * @author Jake mk
 */
public class JpaUtil {
    private static final String PERSISTENCE_UNIT =  "mov_saude";
    private static EntityManagerFactory fabrica;
    private static final ThreadLocal<EntityManager> tl = new ThreadLocal<>();
    
    // Bloco estático para inicialização da fábrica de persistência
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
     * Método que obtém uma instância do EntityManage assiciada à thread atual.
     * 
     * Se não houver uma instância ativa ou se ela estiver fechada, uma nova será criada a partir da {@link EntityManagerFactory}. Caso a fábrica esteja indisponível, uma exceção será lançada e o método retornará {@code null}.
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
    * Método que fecha o EntityManager associado à thread atual, se estiver aberto.
    * 
    * Deve ser chamado ao final de cada operação com banco de dados para evitar vazamento de recursos.
    * Após o fechamento, a instância é removida do {@code ThreadLocal} para liberar memória.
    */
    public static void closeEntityManager() {
        EntityManager em = tl.get();
        
        if (em != null && em.isOpen()) {
            em.close();
        }
        tl.remove();
    }
    
    /**
     * Método que encerra a {@link EntityManagerFactory}, liberando todos os recursos associados.
     * 
     * Esse método deve ser chamado uma única vez, geralmente no encerramento da aplicação, para garantir que todos os recursos de persistência sejam liberados corretamente.
     */
    public static void closeFactory() {
        if (fabrica != null && fabrica.isOpen()) {
            fabrica.close();
        }
    }
}
