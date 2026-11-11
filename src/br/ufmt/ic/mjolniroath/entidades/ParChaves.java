package br.ufmt.ic.mjolniroath.entidades;

import java.time.LocalDateTime;
import java.util.Base64;

public class ParChaves {

    private Long id;
    private Usuario usuario;
    private String algoritmo;
    private byte[] chavePublica;
    private byte[] chavePrivadaCifrada;
    private Boolean ehPosQuantico;
    private LocalDateTime dataCriacao;

    // construtor
    public ParChaves(Usuario usuario, String algoritmo, byte[] chavePublica, byte[] chavePrivadaCifrada, Boolean ehPosQuantico) {
        this.usuario = usuario;
        this.algoritmo = algoritmo;
        this.chavePublica = chavePublica;
        this.chavePrivadaCifrada = chavePrivadaCifrada;
        this.ehPosQuantico = ehPosQuantico;
        this.dataCriacao = LocalDateTime.now();
    }


    public String getChavePublicaBase64() {
        return (chavePublica != null) ? Base64.getEncoder().encodeToString(chavePublica) : "";
    }

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String getAlgoritmo() { return algoritmo; }
    public void setAlgoritmo(String algoritmo) { this.algoritmo = algoritmo; }

    public byte[] getChavePublica() { return chavePublica; }
    public void setChavePublica(byte[] chavePublica) { this.chavePublica = chavePublica; }

    public byte[] getChavePrivadaCifrada() { return chavePrivadaCifrada; }
    public void setChavePrivadaCifrada(byte[] chavePrivadaCifrada) { this.chavePrivadaCifrada = chavePrivadaCifrada; }

    public Boolean getEhPosQuantico() { return ehPosQuantico; }
    public void setEhPosQuantico(Boolean ehPosQuantico) { this.ehPosQuantico = ehPosQuantico; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
}
