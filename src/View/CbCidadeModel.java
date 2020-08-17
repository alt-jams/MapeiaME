/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Bean.Cidade;
import Bean.Estado;
import DAO.CidadeDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Jamilly
 */
public class CbCidadeModel extends DefaultComboBoxModel<Cidade>{
    private List<Cidade> cidades;
    private Estado estado;
    
    
    public CbCidadeModel(Estado estado) {
        super();
        this.estado = estado;
        
        CidadeDAO dao = new CidadeDAO();
        cidades = dao.comboCidades(estado);
        
        for(Cidade cidade : cidades){ 
            addElement(cidade);
        }
    }
    
    @Override
    public Cidade getSelectedItem(){
        return (Cidade) super.getSelectedItem();
    }

    public List<Cidade> getCidades() {
        return cidades;
    }
}
