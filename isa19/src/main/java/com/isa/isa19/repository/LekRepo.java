package com.isa.isa19.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.isa.isa19.model.Lek;

public interface LekRepo extends JpaRepository<Lek, Long>{
	

}
