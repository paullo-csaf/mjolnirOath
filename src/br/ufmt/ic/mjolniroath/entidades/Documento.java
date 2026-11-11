import java.time.LocalDateTime;

public class Documento {

    private Long id;
    private Usuario usuario;
    private String titulo;
    private byte[] conteudoCifrado;
    private String hashSHA256;
    private Long tamanhoBytes;
    private LocalDateTime dataUpload;

    public Documento(Usuario usuario, String titulo, byte[] conteudoCifrado, String hashSHA256, Long tamanhoBytes) {
        this.usuario = usuario;
        this.titulo = titulo;
        this.conteudoCifrado = conteudoCifrado;
        this.hashSHA256 = hashSHA256;
        this.tamanhoBytes = tamanhoBytes;
        this.dataUpload = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public byte[] getConteudoCifrado() { return conteudoCifrado; }
    public void setConteudoCifrado(byte[] conteudoCifrado) { this.conteudoCifrado = conteudoCifrado; }

    public String getHashSHA256() { return hashSHA256; }
    public void setHashSHA256(String hashSHA256) { this.hashSHA256 = hashSHA256; }

    public Long getTamanhoBytes() { return tamanhoBytes; }
    public void setTamanhoBytes(Long tamanhoBytes) { this.tamanhoBytes = tamanhoBytes; }

    public LocalDateTime getDataUpload() { return dataUpload; }

}