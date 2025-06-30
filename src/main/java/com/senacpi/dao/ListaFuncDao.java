
package com.senacpi.dao;

import com.senacpi.modelo.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

/**
 * Classe responsável pelo acesso aos dados dos funcionários no banco de dados.
 * Contém os métodos para listar e pesquisar funcionários utilizando JPA.
 * 
 * @author Jake mk
 */
public class ListaFuncDao {
    
    /**
     * Método que retorna a lista completa de funcionários cadastrados no banco de dados.
     * 
     * Utiliza uma consulta JPA para buscar todos os registros da entidade Funcionario.
     * 
     * @return Lista de objetos Funcionario.
     */
    public List<Funcionario> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Funcionario> funcionarios = null;
        try {
            Query consulta = em.createQuery("SELECT f FROM Funcionario f");
            funcionarios = consulta.getResultList();
        } finally {
            JpaUtil.closeEntityManager();
        }
        
        return funcionarios;
    }

    /**
     * Metodo que realiza uma pesquisa de funcionários com base em um filtro do nome.
     * 
     * Se o filtro estiver vazio, retorna todos os funcionários, caso contrário realiza uma busca parcial.
     * 
     * @param filtro Texto utilizado para buscar funcionários pelo nome.
     * @return Lista de funcionários que atendem ao critério de pesquisa.
     */
    public List<Funcionario> pesquisar(String filtro) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Funcionario> funcs = null;
        try {
            String textoQuery = "SELECT f FROM Funcionario f WHERE (:nome is null OR f.nome LIKE :nome)";
            Query consulta = em.createQuery(textoQuery);
            
            // define o parâmetro da pesquisa como o texto digitado
            consulta.setParameter("nome", filtro.isEmpty() ? null : "%" + filtro + "%");
            
            funcs = consulta.getResultList();
        } finally {
            JpaUtil.closeEntityManager();
        }
        return funcs;
    }
}
