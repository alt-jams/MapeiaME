/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Bean.Usuario;
import DAO.UsuarioDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Jamilly
 */
public class CBUsuarioModel extends DefaultComboBoxModel<Usuario>{
    private List<Usuario> usuarios;
    
    public CBUsuarioModel() {
        super();
        
        UsuarioDAO dao = new UsuarioDAO();
        usuarios = dao.carregaUsuarios();
        
        for(Usuario usuario : usuarios){
            addElement(usuario);
        }
    }
    
    @Override
    public Usuario getSelectedItem(){
        return (Usuario) super.getSelectedItem();
    }

    public List<Usuario> getEstados() {
        return usuarios;
    }
}
