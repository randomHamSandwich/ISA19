package com.isa.isa19.dto;

import com.isa.isa19.model.Sala;

public class SalaDTO {
	
	public Long idSala;

	public SalaDTO(Sala s) {
		this(s.getIdSala());
	}
	
	public SalaDTO(Long idSala) {
		super();
		this.idSala = idSala;
	}

	public SalaDTO() {
		super();
	}

	public Long getIdSala() {
		return idSala;
	}

	public void setIdSala(Long idSala) {
		this.idSala = idSala;
	}


}
