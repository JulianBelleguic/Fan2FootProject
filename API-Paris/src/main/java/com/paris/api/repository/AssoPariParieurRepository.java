package com.paris.api.repository;

import com.paris.api.models.AssoParisParieurModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssoPariParieurRepository extends JpaRepository<AssoParisParieurModel, Long> {

}