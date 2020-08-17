/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Bean.Mensagem;
import Bean.Usuario;
import DAO.MensagemDAO;

/**
 *
 * @author Jamilly
 */
public class MensagemModel {

    public MensagemModel() {
    }
    
    private String titulo;
    private String corpo;
    private Usuario remetente;
    private Usuario destinatario;
    private int viewRemetente;
    private int viewDestinatario;

    public String novaMsg(String titulo, String corpo, 
            Usuario remetente, Usuario destinatario){
        
        if (titulo.equals("") || corpo.equals("")) {
            return "Preencha todos os campos";
        }
        else{
            MensagemDAO dao = new MensagemDAO();
            Mensagem m = new Mensagem(titulo, corpo, remetente, destinatario); 
            dao.create(m);
            return null;
        }    
    }
    
    public String novaMsg(Mensagem m, String corpo){
        if (corpo.equals("")) {
            return "você não escreveu uma mensagem!";
        }
        else{
            MensagemDAO dao = new MensagemDAO(); 
            dao.create(m);
            return null;
        }   
    } 
    
    public String novaMsg(Mensagem m){
            MensagemDAO dao = new MensagemDAO();
            dao.create(m);
            return null;
       
    }
    
    public void apagaMensagem(Mensagem msg, int viewdest, int viewrem){
       Mensagem m = msg;
       m.setViewDestinatario(viewdest);
       m.setViewRemetente(viewrem);
       MensagemDAO dao = new MensagemDAO();
       dao.update(m);
   }
}
