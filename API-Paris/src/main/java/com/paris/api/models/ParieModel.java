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
    @Column(name="id_parie", nullable=false, updatable=false)
    private Long id;

    @Column(length=30)
    private Long idMatch;

    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn(name="id_cotea")
    private CoteModel idCoteA;

    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn(name="id_coteb")
    private CoteModel idCoteB;

    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn(name="id_coten")
    private CoteModel idCoteN;


}