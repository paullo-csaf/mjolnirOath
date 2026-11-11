import br.ufmt.ic.mjolniroath.entidades.enums.NivelAcesso;
import java.time.LocalDateTime;

public class Usuario {

    // atributos
    private long id;
    private String nome;
    private String email;
    private String hashSenha;
    private NivelAcesso nivelAcesso;
    private LocalDateTime dataCriacao;

    //construtor
    public Usuario(long id, String nome, String email, String hashSenha, NivelAcesso nivelAcesso, LocalDateTime dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.hashSenha = hashSenha;
        this.nivelAcesso = nivelAcesso;
        this.dataCriacao = dataCriacao != null ? dataCriacao : LocalDateTime.now();
    }

    // getters e setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome){ this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getHashSenha() { return hashSenha; }
    public void setHashSenha(String hashSenha) { this.hashSenha = hashSenha; }

    public NivelAcesso getNivelAcesso() { return nivelAcesso; }
    public void setNivelAcesso(NivelAcesso nivelAcesso) { this.nivelAcesso = nivelAcesso; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
}
