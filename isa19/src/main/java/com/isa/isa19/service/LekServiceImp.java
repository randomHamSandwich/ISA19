package com.isa.isa19.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isa.isa19.dto.LekDTO;
import com.isa.isa19.model.Lek;
import com.isa.isa19.model.Lekar;
import com.isa.isa19.repository.LekRepo;

@Service
@Transactional(readOnly = true)
public class LekServiceImp  implements LekService{
	
	@Autowired
	private LekRepo lekRepo;

	public Optional<Lek> findOne(Long id) {
		return lekRepo.findById(id);
	}

	@Override
	public List<LekDTO> findAlergijeKorisnika(Long idKarton) {
		List<Lek> lekoviAlergican =  lekRepo.findAlergijeKorisnika(idKarton);
		List<LekDTO> alergijeDTO = new ArrayList<LekDTO>();
		
		
		for (Lek lek : lekoviAlergican) {
			alergijeDTO.add(new LekDTO(lek));
		}
		
		return alergijeDTO;
	}

}
