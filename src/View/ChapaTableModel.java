/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Bean.Cidade;
import Bean.Usuario;
import DAO.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jamilly
 */
public class ChapaTableModel extends AbstractTableModel {
    
    protected List<Usuario> membros;
    private String[] colunas = {"Cargo", "Nome"}; 

    
    public ChapaTableModel() {
        this.membros =  new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
       return membros.size();
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
            return membros.get(linha).getCargo();
        }
        else if (coluna == 1){
            return membros.get(linha).getNome();
        }
       return null;  
    }
    
    public void carregarDados(Cidade cidade){
        UsuarioDAO dao = new UsuarioDAO();
        membros = dao.carregaMembros(cidade);
        fireTableDataChanged();
    }
    
    public Usuario getMembro(int i){
       return membros.get(i); 
    }  
   
}

   
