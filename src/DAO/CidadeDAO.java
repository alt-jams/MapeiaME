/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Cidade;
import Bean.Estado;
import Bean.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;



/**
 *
 * @author Jamilly
 */
public class CidadeDAO extends GenericDAO<Integer, Cidade>{


    public CidadeDAO() {
      
    }
    
    public List<Cidade> comboCidades(Estado estado){
        List<Cidade> cidades;
        
        TypedQuery<Cidade> query = em.createQuery("SELECT c FROM Cidade c WHERE c.estado.id = :estadoid",
                Cidade.class);
        query.setParameter("estadoid", estado.getId());      
        
        cidades = query.getResultList();
        
        return cidades;
    }

    public List<Cidade> tabelaCidades() {
        List<Cidade> cidades = em.createQuery("FROM " + Cidade.class.getName()).getResultList(); 
        return cidades;       
    }
    
    
}
