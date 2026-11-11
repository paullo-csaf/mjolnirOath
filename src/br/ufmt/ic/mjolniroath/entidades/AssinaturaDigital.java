import br.ufmt.ic.mjolniroath.entidades.enums.StatusValidacao;

import java.time.LocalDateTime;

public class AssinaturaDigital {

    private Long id;
    private Documento documento;
    private ParChaves parChaves;
    private byte[] bytesAssinatura;
    private String algoritmoAssinatura;
    private StatusValidacao statusValidacao;
    private LocalDateTime dataAssinatura;

    // Construtor principal
    public AssinaturaDigital(Documento documento, ParChaves parChaves, byte[] bytesAssinatura, String algoritmoAssinatura) {
        this.documento = documento;
        this.parChaves = parChaves;
        this.bytesAssinatura = bytesAssinatura;
        this.algoritmoAssinatura = algoritmoAssinatura;
        this.statusValidacao = StatusValidacao.PENDENTE_VERIFICACAO;
        this.dataAssinatura = LocalDateTime.now();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Documento getDocumento() { return documento; }
    public void setDocumento(Documento documento) { this.documento = documento; }

    public ParChaves getParChaves() { return parChaves; }
    public void setParChaves(ParChaves parChaves) { this.parChaves = parChaves; }

    public byte[] getBytesAssinatura() { return bytesAssinatura; }
    public void setBytesAssinatura(byte[] bytesAssinatura) { this.bytesAssinatura = bytesAssinatura; }

    public String getAlgoritmoAssinatura() { return algoritmoAssinatura; }
    public void setAlgoritmoAssinatura(String algoritmoAssinatura) { this.algoritmoAssinatura = algoritmoAssinatura; }

    public StatusValidacao getStatusValidacao() { return statusValidacao; }
    public void setStatusValidacao(StatusValidacao statusValidacao) { this.statusValidacao = statusValidacao; }

    // Apenas GET para a data de assinatura (imutável)
    public LocalDateTime getDataAssinatura() { return dataAssinatura; }
}