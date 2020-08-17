/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jamilly
 */

@Entity
@Table(name = "cidade")

public class Cidade {
    private int id;
    private String cidade;
    private Estado estado;
    private List<Usuario> usuarios;

    public Cidade(String cidade, Estado estado) {
        this.cidade = cidade;
        this.estado = estado;
    }

    
    private Cidade(){
        
    }
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

@Column(name="cidade", nullable = false)
    public String getCidadeNome() {
        return cidade;
    }

    public void setCidadeNome(String cidade) {
        this.cidade = cidade;
    }

 
    @ManyToOne
    @JoinColumn(name="id_estado")
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @OneToMany(mappedBy ="cidade")
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
 @Override
    public String toString() {
        return this.cidade;
    }    
     
    
}
