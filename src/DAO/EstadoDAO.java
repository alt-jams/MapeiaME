/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Estado;
import Bean.Usuario;
import java.util.List;

/**
 *
 * @author Jamilly
 */
public class EstadoDAO extends GenericDAO<Integer, Usuario>{

    public List<Estado> comboEstados() {
        List<Estado> estados;
        estados = em.createQuery("FROM Estado").getResultList();
        
        return estados;
    }
    
}
