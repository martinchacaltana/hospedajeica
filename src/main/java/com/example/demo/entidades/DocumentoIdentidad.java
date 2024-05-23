package com.example.demo.entidades;

import jakarta.persistence.*;

@Entity
@Table (name = "documentoidentidad")
public class DocumentoIdentidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Idtipodocumento;

    @Column (name = "nombreDocumento")
    private String nombreDocumento;

    @Column (name = "abreviatura")
    private String abreviatura;

    public DocumentoIdentidad() {
    }

    public DocumentoIdentidad(long idtipodocumento, String nombreDocumento, String abreviatura) {
        Idtipodocumento = idtipodocumento;
        this.nombreDocumento = nombreDocumento;
        this.abreviatura = abreviatura;
    }

    public long getIdtipodocumento() {
        return Idtipodocumento;
    }

    public void setIdtipodocumento(long idtipodocumento) {
        Idtipodocumento = idtipodocumento;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }
}
