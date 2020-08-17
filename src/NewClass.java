
import Bean.Cidade;
import Bean.Estado;
import Bean.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jamilly
 */
public class NewClass {
    public static void main(String[] args) {
        Estado e = new Estado("PR");
        Cidade c = new Cidade("Goio", e);
        Usuario u = new Usuario("Matheus", "email", "1", c, "presida");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MapeiaPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(e);
        em.persist(c);
        em.persist(u);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
    
}
