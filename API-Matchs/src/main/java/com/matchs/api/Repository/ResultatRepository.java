package com.matchs.api.Repository;

import com.matchs.api.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultatRepository extends JpaRepository<Resultat, Long> {
    @Query(value = "SELECT SUM(resultat) FROM resultat WHERE id_equipe_equipe_id = :id", nativeQuery = true)
    //public List<Resultat> findResulats(@Param("id") Long id);
    public Float findResulats(@Param("id") Long id);
}