package com.matchs.api.Repository;

import com.matchs.api.Model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRolename(String rolename);

}
