/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Bean.Estado;
import DAO.CidadeDAO;

/**
 *
 * @author Jamilly
 */
public class CidadeModel {

    public CidadeModel() {
    }
    
    public void carregaCidades(Estado estado){
        CidadeDAO dao = new CidadeDAO();
        dao.comboCidades(estado);
    }
}
