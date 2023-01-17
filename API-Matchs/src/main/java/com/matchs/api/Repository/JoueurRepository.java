package com.matchs.api.Repository;

import com.matchs.api.Model.Joueur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Long> {
    Page<Joueur> findByNomContains(String rechercher, Pageable pageable);
}
