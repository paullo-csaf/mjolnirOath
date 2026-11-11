package br.ufmt.ic.mjolniroath.entidades;

import br.ufmt.ic.mjolniroath.entidades.enums.TipoOperacao;
import java.time.LocalDateTime;

public class LogAuditoria {

    private Long id;
    private Usuario usuario;
    private TipoOperacao tipoOperacao;
    private String algoritmo;
    private Double tempoExecucaoMs;
    private Long tamanhoSaidaBytes;
    private LocalDateTime dataHora;

    // Construtor principal
    public LogAuditoria(Usuario usuario, TipoOperacao tipoOperacao, String algoritmo, Double tempoExecucaoMs, Long tamanhoSaidaBytes) {
        this.usuario = usuario;
        this.tipoOperacao = tipoOperacao;
        this.algoritmo = algoritmo;
        this.tempoExecucaoMs = tempoExecucaoMs;
        this.tamanhoSaidaBytes = tamanhoSaidaBytes;
        this.dataHora = LocalDateTime.now();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public TipoOperacao getTipoOperacao() { return tipoOperacao; }
    public void setTipoOperacao(TipoOperacao tipoOperacao) { this.tipoOperacao = tipoOperacao; }

    public String getAlgoritmo() { return algoritmo; }
    public void setAlgoritmo(String algoritmo) { this.algoritmo = algoritmo; }

    public Double getTempoExecucaoMs() { return tempoExecucaoMs; }
    public void setTempoExecucaoMs(Double tempoExecucaoMs) { this.tempoExecucaoMs = tempoExecucaoMs; }

    public Long getTamanhoSaidaBytes() { return tamanhoSaidaBytes; }
    public void setTamanhoSaidaBytes(Long tamanhoSaidaBytes) { this.tamanhoSaidaBytes = tamanhoSaidaBytes; }

    // Apenas GET para dataHora (imutável)
    public LocalDateTime getDataHora() { return dataHora; }
}