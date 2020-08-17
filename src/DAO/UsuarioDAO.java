/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Cidade;
import Bean.Usuario;
import java.util.List;  
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jamilly
 */
public class UsuarioDAO extends GenericDAO<Integer, Usuario>{

    public UsuarioDAO() {
    }
    
    public Usuario buscaPorEmail(String email) {

        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email",
                Usuario.class);
        query.setParameter("email", email);

        Usuario u = null;

        try {
            u = query.getSingleResult();
        } catch (NoResultException e) {
            u = null;
        } finally {
        }

        return u;
    }
    
    public Usuario logar(String email, String senha) {

        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha",
                Usuario.class);
        query.setParameter("email", email);
        query.setParameter("senha", senha);

        Usuario u = null;

        try {
            u = query.getSingleResult();
        } catch (NoResultException e) {
            u = null;
        } finally {
        }

        return u;
    }
    
    public List<Usuario> carregaMembros(Cidade cidade){
        List<Usuario> membros;
        
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.cidade.id = :cidadeid",
                Usuario.class);
        query.setParameter("cidadeid", cidade.getId());    

        try {
            membros = query.getResultList();
        } catch (NoResultException e) {
            membros = null;
        } finally {
        }
        
        return membros;
    }
   
    public List<Usuario> carregaUsuarios(){
        List<Usuario> usuarios = em.createQuery("FROM Usuario").getResultList();
        return usuarios;
    }
}
