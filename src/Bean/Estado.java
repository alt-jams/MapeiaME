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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jamilly
 */

@Entity
@Table(name = "estado")

public class Estado {
    private int id;
    private String estado;
    private List<Cidade> cidades;

    
    public Estado(String estado) {
        this.estado = estado;
    }
    
    public Estado(){
        
    }
    
@Id @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

@Column(name="estado", nullable = false)
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

@OneToMany(mappedBy ="estado")
    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
    
@Override
    public String toString() {
        return this.estado;
    }    
     
}
