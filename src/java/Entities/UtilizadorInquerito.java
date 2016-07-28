package Entities;

//
// This file was generated by the JPA Modeler
//

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UtilizadorInquerito implements Serializable {

    @ManyToOne(targetEntity = Inquerito.class)
    private Inquerito inquerito;

    @Column(unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUtilizadorInqerito;

    @ManyToOne(targetEntity = Utilizador.class)
    private Utilizador utilizador;

    public UtilizadorInquerito() {

    }

    public Inquerito getInquerito() {
        return this.inquerito;
    }

    public void setInquerito(Inquerito inquerito) {
        this.inquerito = inquerito;
    }

    public Long getIdUtilizadorInqerito() {
        return this.idUtilizadorInqerito;
    }

    public void setIdUtilizadorInqerito(Long idUtilizadorInqerito) {
        this.idUtilizadorInqerito = idUtilizadorInqerito;
    }

    public Utilizador getUtilizador() {
        return this.utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }
}