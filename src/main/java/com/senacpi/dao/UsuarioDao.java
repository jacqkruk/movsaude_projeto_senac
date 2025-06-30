
package com.senacpi.dao;

import com.senacpi.modelo.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 * Classe responsável pelo acesso aos dados de usuários no banco de dados.
 * 
 * Contém métodos para validar um usuário com base em login e senha.
 * 
 * @author Jake mk
 */
public class UsuarioDao {
    
    /**
     * Método para validar usuário a partir de credenciais informadas.
     * 
     * Recebe um objeto usuário com informações de login e senha, e busca no banco de dados um usuário correspondente.
     * 
     * @param usuario Objeto Usurio contendo o login e senha a serem verificados.
     * @return Retorna uma lista com os usuários correspondentes, ou null se não for encontrado.
     */
    public static Usuario validarUsuario(Usuario usuario) {
        EntityManager em = JpaUtil.getEntityManager();
        
        try {
            String jpql = "SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha";
            TypedQuery<Usuario> consulta = em.createQuery(jpql, Usuario.class);
            
            consulta.setParameter("login", usuario.getLogin());
            consulta.setParameter("senha", usuario.getSenha());
            
            // retorna uma lista caso haja uma duplicata no banco de dados
            List<Usuario> usuarios = consulta.getResultList(); 
            
            // retorna nulo se a lista estiver vazia, ou o usuario no índice 0 lista
            return usuarios.isEmpty() ? null : usuarios.get(0); 

        } finally {
            JpaUtil.closeEntityManager();
        }
    }
}
