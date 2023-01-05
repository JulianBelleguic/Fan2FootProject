package com.matchs.api.Repository;

import com.matchs.api.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultatRepository extends JpaRepository<Resultat, Long> {
    public List<Resultat> findById_equipe(Long id_equipe);
}