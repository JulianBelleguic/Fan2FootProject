package com.paris.api.repository;

import com.paris.api.models.ParieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParieRepository extends JpaRepository<ParieModel, Long> {

}