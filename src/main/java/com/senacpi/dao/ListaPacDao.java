
package com.senacpi.dao;

import com.senacpi.modelo.Paciente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author Jake mk
 */
public class ListaPacDao {
    /**
     * Método que retorna a lista completa de pacientes cadastrados no banco de dados.
     * 
     * Utiliza uma consulta JPA para buscar todos os registros da entidade Paciente.
     * 
     * @return Lista de objetos Paciente.
     */
    public List<Paciente> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Paciente> pacientes = null;
        try {
            Query consulta = em.createQuery("SELECT p FROM Paciente p");
            pacientes = consulta.getResultList();
        } finally {
            JpaUtil.closeEntityManager();
        }
        
        return pacientes;
    }

    /**
     * Metodo que realiza uma pesquisa de pacientes com base em um filtro do nome.
     * 
     * Se o filtro estiver vazio, retorna todos os pacientes, caso contrário realiza uma busca parcial.
     * 
     * @param filtro Texto utilizado para buscar pacientes pelo nome.
     * @return Lista de pacientes que atendem ao critério de pesquisa.
     */
    public List<Paciente> pesquisar(String filtro) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Paciente> pacs = null;
        try {
            String textoQuery = "SELECT p FROM Paciente p WHERE (:nome is null OR p.nome LIKE :nome)";
            Query consulta = em.createQuery(textoQuery);
            
            // define o parâmetro da pesquisa como o texto digitado
            consulta.setParameter("nome", filtro.isEmpty() ? null : "%" + filtro + "%");
            
            pacs = consulta.getResultList();
        } finally {
            JpaUtil.closeEntityManager();
        }
        return pacs;
    }
}
