/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import Bean.Estado;
import DAO.EstadoDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Jamilly
 */
public class CbEstadoModel extends DefaultComboBoxModel<Estado>{
    private List<Estado> estados;
    
    public CbEstadoModel() {
        super();
        
        EstadoDAO dao = new EstadoDAO();
        estados = dao.comboEstados();
        
        for(Estado estado : estados){
            addElement(estado);
        }
    }
    
    @Override
    public Estado getSelectedItem(){
        return (Estado) super.getSelectedItem();
    }

    public List<Estado> getEstados() {
        return estados;
    }
}
