package com.paris.api.repository;

import com.paris.api.models.CoteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoteRepository extends JpaRepository<CoteModel, Long> {

}