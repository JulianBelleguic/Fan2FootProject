package com.matchs.api.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "matchs")

public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id", nullable = false, updatable = false)
    private long id_match;

    @ManyToOne
    private Equipe id_equipe1;

    @ManyToOne
    private Equipe id_equipe2;

    public Match(Long id_match) {
        this.id_match = id_match;
    }

    public long getId_match() {
        return id_match;
    }

    public void setId_match(long id_match) {
        this.id_match = id_match;
    }

    public Equipe getId_equipe1() {
        return id_equipe1;
    }

    public void setId_equipe1(Equipe id_equipe1) {
        this.id_equipe1 = id_equipe1;
    }

    public Equipe getId_equipe2() {
        return id_equipe2;
    }

    public void setId_equipe2(Equipe id_equipe2) {
        this.id_equipe2 = id_equipe2;
    }
}
