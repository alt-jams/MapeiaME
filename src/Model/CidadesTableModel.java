/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Bean.Cidade;
import DAO.CidadeDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jamilly
 */
public class CidadesTableModel extends AbstractTableModel{
    protected List<Cidade> cidades;
    private int op;
    private String[] colunas = {"Cidade", "Estado"}; 
    
    public CidadesTableModel() {
        this.cidades =  new ArrayList<>();
        
    }
    
    @Override
    public int getRowCount() {
       return cidades.size();
    }

    @Override
    public int getColumnCount() {
       return colunas.length; 
    }
    
    public String getColumnName(int i){
        return colunas[i];
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
         if (coluna == 0){ 
            return cidades.get(linha).getCidadeNome();
        }
        else if (coluna == 1){
            return cidades.get(linha).getEstado().getEstado();
        }
       return null;
                    
    }
    
    
    public void carregarDados(){
        CidadeDAO dao = new CidadeDAO();
        cidades = dao.tabelaCidades();
        
        fireTableDataChanged();
    }
    
    
    public Cidade getMensagem(int i){
       return cidades.get(i); 
    }  
}
