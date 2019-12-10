package com.isa.isa19.security.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.isa19.model.RoleNaziv;
import com.isa.isa19.model.Roles;

@Repository
public interface RoleRepo extends JpaRepository<Roles, Long>{
	Optional<Roles> findByNazivRole(RoleNaziv roleNaziv);

}
