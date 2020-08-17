/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.table.AbstractTableModel;
import Bean.Mensagem;
import Bean.Usuario;
import DAO.MensagemDAO;

/**
 *
 * @author Jamilly
 */
public class MensagemTableModel extends AbstractTableModel{
    protected List<Mensagem> mensagens;
    private int op;
    private String[] colunas = {"Remetente", "título"}; 

    
    public MensagemTableModel() {
        this.mensagens =  new ArrayList<>();
        
    }
    
    @Override
    public int getRowCount() {
       return mensagens.size();
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
            return mensagens.get(linha).getRemetente().getEmail();
        }
        else if (coluna == 1){
            return mensagens.get(linha).getTitulo();
        }
       return null;  
    }
    
    public void carregarDadosEntrada(Usuario user){
        MensagemDAO dao = new MensagemDAO();
        mensagens = dao.carregaMensagensEntrada(user);
        fireTableDataChanged();
    }
    
    public void carregarLixeira(Usuario user){
        MensagemDAO dao = new MensagemDAO();
        mensagens = dao.carregaLixeira(user);
        fireTableDataChanged();
    }
    
    public void carregarDadosSaida(Usuario user){
        MensagemDAO dao = new MensagemDAO();
        mensagens = dao.carregaMensagensSaida(user);
        fireTableDataChanged(); 
    } 
    
    public Mensagem getMensagem(int i){
       Mensagem msg =  mensagens.get(i);
       MensagemDAO dao = new MensagemDAO();
       return dao.get(msg.getId());
    } 
    
    public void apagar(int pk){
        MensagemDAO dao = new MensagemDAO();
        dao.remove(pk);
    }
}
