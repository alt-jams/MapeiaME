/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Jamilly
 */

@Entity
@Table(name = "mensagem")

public class Mensagem {
    private int id;
    private String titulo;
    private String corpo;
    private Usuario remetente;
    private Usuario destinatario;
    private int viewRemetente;
    private int viewDestinatario;

    public Mensagem(String titulo, String corpo, Usuario remetente, Usuario destinatario) {
        this.titulo = titulo;
        this.corpo = corpo;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.viewDestinatario = 1; //usuário que recebeu vai ver a mensagem
        this.viewRemetente = 1; // usuário que enviou vai ver a mensagem
    }

    public Mensagem() {
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Column(name="titulo", nullable = false)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Column(name="corpo", nullable = false)
    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

   @ManyToOne
    @JoinColumn(name="id_remetente")
    public Usuario getRemetente() {
        return remetente;
    }

    public void setRemetente(Usuario remetente) {
        this.remetente = remetente;
    }

    @ManyToOne
    @JoinColumn(name="id_destinatario")
    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    @Column(name="view_remetente", nullable = false)
    public int getViewRemetente() {
        return viewRemetente;
    }

    public void setViewRemetente(int viewRemetente) {
        this.viewRemetente = viewRemetente;
    }

    @Column(name="view_destinatario", nullable = false)
    public int getViewDestinatario() {
        return viewDestinatario;
    }

    public void setViewDestinatario(int viewDestinatario) {
        this.viewDestinatario = viewDestinatario;
    }
    
    
}
