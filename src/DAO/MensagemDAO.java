/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Cidade;
import Bean.Estado;
import Bean.Mensagem;
import Bean.Usuario;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jamilly
 */
public class MensagemDAO extends GenericDAO<Integer, Mensagem>{
   
    
    public List<Mensagem> carregaMensagensSaida(Usuario u){
        List<Mensagem> mensagens;
        
        TypedQuery<Mensagem> query = 
                em.createQuery("SELECT m FROM Mensagem m WHERE m.remetente = :remetente AND m.viewRemetente = :viewRemetente", Mensagem.class);
        query.setParameter("remetente", u);
        query.setParameter("viewRemetente", 1);
        
        try{
           mensagens = query.getResultList();
        }catch(NoResultException e){  
            return null;
        }finally{
            
        }  
        return mensagens;        
    }
    
   public List<Mensagem> carregaMensagensEntrada (Usuario u){
       List<Mensagem> mensagens;
       TypedQuery<Mensagem> query = 
                em.createQuery("SELECT m FROM Mensagem m WHERE m.destinatario = :destinatario AND m.viewDestinatario = :viewDestinatario", Mensagem.class);
        query.setParameter("destinatario", u);
        query.setParameter("viewDestinatario", 1);
        
        try{
           mensagens = query.getResultList();
        }catch(NoResultException e){ 
            return null;
        }finally{
            
       }  
        return mensagens;        
    }
   
   public List<Mensagem> carregaLixeira (Usuario u){
       List<Mensagem> mensagens;
       TypedQuery<Mensagem> query = 
                em.createQuery("SELECT m FROM Mensagem m WHERE m.destinatario = :destinatario AND m.viewDestinatario = :viewDestinatario", Mensagem.class);
        query.setParameter("destinatario", u);
        query.setParameter("viewDestinatario", 0);
        
        try{
           mensagens = query.getResultList();
        }catch(NoResultException e){  
           return null;
        }finally{  
       }  
        return mensagens;        
    }
   
   public void apagaMensagem(Mensagem msg, int viewdest, int viewrem){
       Mensagem m = msg;//isso é na model caralhozfsgesgs
       m.setViewDestinatario(viewdest);
       m.setViewRemetente(viewrem);
       
       super.update(m);
   }
}    
        
  
    

