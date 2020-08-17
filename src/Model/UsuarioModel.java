/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.UsuarioDAO;
import Bean.Cidade;
import Bean.Estado;
import Bean.Usuario;
import Util.Retorno;

/**
 *
 * @author Jamilly
 */
public class UsuarioModel {

    public UsuarioModel() {
    }
    
    
    public String cadastrar(String nome, Estado estado, 
            Cidade cidade, String cargo, String email, String senha1, String senha2){
        
        if (nome.equals("") || cargo.equals("") || email.equals("")|| senha1.equals("") || senha2.equals("")) {
            return "Preencha todos os campos";
        }
        if(senha1.equals(senha2) == false){
            return "Senhas não são iguais";
        }
        else{
            UsuarioDAO dao = new UsuarioDAO();
            Usuario u = dao.buscaPorEmail(email);
            
            if (u == null) {
                u = new Usuario(nome, email, senha1, cidade, cargo); 
                dao.create(u);
                return null;
            }
            else{
                return "Email já existente";
            }
        }
        
    }
    
    
     public Retorno<String, Usuario>  Logar(String email, String senha){
        Usuario retorno = null;
        String msg = null;
        
        if (email.equals("") || senha.equals("")) {
            msg = "Preencha todos os campos.";
        }
        else{
            UsuarioDAO dao = new UsuarioDAO();
            
            retorno = dao.logar(email, senha);
            
            if (retorno == null) {
                msg = "Email ou senha incorretos.";
            }
        }
        
        return new Retorno<String, Usuario>(msg, retorno);// hora retorna string, hora retorna usuario
    }
    
}
