package com.paris.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "parie")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ParieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="idParie", nullable=false, updatable=false)
    private Long id;

    @Column(length=30)
    private Long idMatch;

    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn(name="idCoteA")
    private CoteModel idCoteA;

    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn(name="idCoteB")
    private CoteModel idCoteB;

    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn(name="idCoteN")
    private CoteModel idCoteN;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(Long idMatch) {
        this.idMatch = idMatch;
    }

    public CoteModel getIdCoteA() {
        return idCoteA;
    }

    public void setIdCoteA(CoteModel idCoteA) {
        this.idCoteA = idCoteA;
    }

    public CoteModel getIdCoteB() {
        return idCoteB;
    }

    public void setIdCoteB(CoteModel idCoteB) {
        this.idCoteB = idCoteB;
    }

    public CoteModel getIdCoteN() {
        return idCoteN;
    }

    public void setIdCoteN(CoteModel idCoteN) {
        this.idCoteN = idCoteN;
    }

    public ParieModel(Long id, Long idMatch, CoteModel id_coteA, CoteModel id_coteB, CoteModel id_coteN){
        this.id = id;
        this.idMatch = idMatch;
        this.idCoteA = id_coteA;
        this.idCoteB = id_coteB;
        this.idCoteN = id_coteN;
    }
}