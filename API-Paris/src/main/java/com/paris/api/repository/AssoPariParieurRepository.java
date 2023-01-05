package com.paris.api.repository;

import com.paris.api.models.AssoParisParieurModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssoPariParieurRepository extends JpaRepository<AssoParisParieurModel, Long> {
    List<AssoParisParieurModel> findAllByIdParieur(Long idParieur);
}