package com.paris.api.repository;

import com.paris.api.models.ParieurModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParieurRepository extends JpaRepository<ParieurModel, Long> {


}

