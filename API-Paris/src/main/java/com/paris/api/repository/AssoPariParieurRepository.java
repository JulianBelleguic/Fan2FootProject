package com.paris.api.repository;

import com.paris.api.models.ParierModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssoPariParieurRepository extends JpaRepository<ParierModel, Long> {
    List<ParierModel> findAllByIdParieur(Long idParieur);
    @Query(value = "SELECT asso_pari_parieur.* FROM asso_pari_parieur join parie on parie.id_parie=asso_pari_parieur.id_paris\n" +
            " where id_match=:id and coteChoisie like :cote", nativeQuery = true)
    List<ParierModel> findUpdParieur(@Param("id") Long id, @Param("cote") String cote);
}