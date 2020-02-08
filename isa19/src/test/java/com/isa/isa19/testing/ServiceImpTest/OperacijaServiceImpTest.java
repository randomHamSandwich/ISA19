package com.isa.isa19.testing.ServiceImpTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.isa.isa19.model.Operacija;
import com.isa.isa19.repository.OperacijaRepo;
import com.isa.isa19.service.OperacijaServiceImp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperacijaServiceImpTest {

	@Mock
	private OperacijaRepo operacijaRepoMock;
	@Mock
	private Operacija operacijaMock;
	@InjectMocks
	private OperacijaServiceImp operacijaService;

	@Test
	public void findByIdLekarAndOcenaLekaraNotNull() {

		when(operacijaRepoMock.findByIdLekarAndOcenaLekaraNotNull(1L)).thenReturn(Arrays.asList(
				new Operacija(1L, LocalDateTime.now(), LocalDateTime.now(), null, null, null, null, null, null, null)));
		List<Operacija > operacije= operacijaService.findByIdLekarAndOcenaLekaraNotNull(1L);
		assertThat(operacije).hasSize(1);

		verify(operacijaRepoMock, times(1)).findByIdLekarAndOcenaLekaraNotNull( 1L);
		verifyNoMoreInteractions(operacijaRepoMock);
	}
	
	@Test
	public void findByIdKlinikaAndOcenaKlinikaNotNull() {

		when(operacijaRepoMock.findByIdKlinikaAndOcenaKlinikaNotNull(1L)).thenReturn(Arrays.asList(
				new Operacija(1L, LocalDateTime.now(), LocalDateTime.now(), null, null, null, null, null, null, null)));
		List<Operacija > operacije= operacijaService.findByIdKlinikaAndOcenaKlinikaNotNull(1L);
		assertThat(operacije).hasSize(1);

		verify(operacijaRepoMock, times(1)).findByIdKlinikaAndOcenaKlinikaNotNull( 1L);
		verifyNoMoreInteractions(operacijaRepoMock);

	}
	
	@Test
	public void findByIdPacijentAndStatus() {

		when(operacijaRepoMock.findByIdPacijentAndStatus(1L, "Status")).thenReturn(Arrays.asList(
				new Operacija(1L, LocalDateTime.now(), LocalDateTime.now(), null, null, null, null, null, null, null)));
		List<Operacija > operacije= operacijaService.findByIdPacijentAndStatus(1L, "Status");
		assertThat(operacije).hasSize(1);

		verify(operacijaRepoMock, times(1)).findByIdPacijentAndStatus( 1L, "Status");
		verifyNoMoreInteractions(operacijaRepoMock);

	}
	
	
	
	
}
