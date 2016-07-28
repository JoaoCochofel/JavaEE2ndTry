package Entities;

//
// This file was generated by the JPA Modeler
//

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoUtilizador implements Serializable {

    @Column(unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTipoUtilizador;

    @Basic
    private String designacao;

    public TipoUtilizador() {

    }

    public Long getIdTipoUtilizador() {
        return this.idTipoUtilizador;
    }

    public void setIdTipoUtilizador(Long idTipoUtilizador) {
        this.idTipoUtilizador = idTipoUtilizador;
    }

    public String getDesignacao() {
        return this.designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
}
