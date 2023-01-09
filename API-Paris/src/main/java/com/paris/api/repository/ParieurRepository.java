package com.paris.api.repository;

import com.paris.api.models.AssoParisParieurModel;
import com.paris.api.models.ParieurModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ParieurRepository extends JpaRepository<ParieurModel, Long> {


}

