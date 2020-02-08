package com.isa.isa19.testing.ServiceImpTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verify;

import com.isa.isa19.dto.LekDTO;
import com.isa.isa19.model.Lek;
import com.isa.isa19.model.Pregled;
import com.isa.isa19.model.StatusPregledaOperacije;
import com.isa.isa19.repository.LekRepo;
import com.isa.isa19.repository.PregledRepo;
import com.isa.isa19.service.LekServiceImp;
import com.isa.isa19.service.PregledServiceImp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PregledServiceImpTest {
	@Mock
	private PregledRepo pregledRepoMock;
	@Mock
	private Pregled pregledMock;
	@InjectMocks
	private PregledServiceImp pregledServiceImp;
	
	@Test
	public void testFindByIdPacijentAndStatus() {

		when(pregledRepoMock.findByIdPacijentAndStatus(1L, "IZVRSEN_PREGLED")).thenReturn(Arrays.asList(new Pregled()));
		List<Pregled> lekovi = pregledServiceImp.findByIdPacijentAndStatus(1L, "IZVRSEN_PREGLED");
		assertThat(lekovi).hasSize(1);

		verify(pregledRepoMock, times(1)).findByIdPacijentAndStatus(1L, "IZVRSEN_PREGLED");
        verifyNoMoreInteractions(pregledRepoMock);
        
	}
	

	
	@Test
	public void testFindByIdKlinikaAndOcenaKlinikaNotNull() {

		when(pregledRepoMock.findByIdKlinikaAndOcenaKlinikaNotNull(1L)).thenReturn(Arrays.asList(new Pregled()));
		List<Pregled> lekovi = pregledServiceImp.findByIdKlinikaAndOcenaKlinikaNotNull(1L);
		assertThat(lekovi).hasSize(1);

		verify(pregledRepoMock, times(1)).findByIdKlinikaAndOcenaKlinikaNotNull(1L);
        verifyNoMoreInteractions(pregledRepoMock);
        
	}

	
}
