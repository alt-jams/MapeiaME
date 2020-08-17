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
@Table(name = "usuario")

public class Usuario {
    
    private int id;
    private String nome;
    private String email;
    private String senha;
    private Cidade cidade;
    private String cargo;
    private List<Mensagem> enviadas;
    private List<Mensagem> recebidas;

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha, Cidade cidade, String cargo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cidade = cidade;
        this.cargo = cargo;
    }

    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="nome", nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name="email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="senha", nullable = false)
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @ManyToOne
    @JoinColumn(name="id_cidade")
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Column(name="cargo", nullable = false)
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    @OneToMany(mappedBy = "remetente")
    public List<Mensagem> getEnviadas() {
        return enviadas;
    }

    public void setEnviadas(List<Mensagem> enviadas) {
        this.enviadas = enviadas;
    }

    @OneToMany(mappedBy = "destinatario")
    public List<Mensagem> getRecebidas() {
        return recebidas;
    }

    public void setRecebidas(List<Mensagem> recebidas) {
        this.recebidas = recebidas;
    }
    
    @Override
    public String toString() {
        return this.email;
    }    
    
}
