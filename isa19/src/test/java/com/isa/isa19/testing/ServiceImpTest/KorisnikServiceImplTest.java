package com.isa.isa19.testing.ServiceImpTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.isa.isa19.dto.LekarDTO;
import com.isa.isa19.model.Korisnik;
import com.isa.isa19.model.Lekar;
import com.isa.isa19.model.Usluga;
import com.isa.isa19.repository.KorisnikRepo;
import com.isa.isa19.repository.UslugaRepo;
import com.isa.isa19.service.KorisnikServiceImpl;
import com.isa.isa19.service.UslugaServiceImp;
@RunWith(SpringRunner.class)
@SpringBootTest
public class KorisnikServiceImplTest {
	

	@Mock
	private KorisnikRepo korisnikRepoMock;
	@Mock
	private Korisnik korisnikMock;
	@InjectMocks
	private KorisnikServiceImpl korisnikService;
	
	@Test
	public void testFindByEmail() {

		when(korisnikRepoMock.findByEmail("aca@gmail.com")).thenReturn(Optional.of(korisnikMock));
		Korisnik dbKorisnik = korisnikService.findByEmail("aca@gmail.com").get();
		assertEquals(korisnikMock, dbKorisnik);
		
		verify(korisnikRepoMock, times(1)).findByEmail("aca@gmail.com");
        verifyNoMoreInteractions(korisnikRepoMock);
        
	}
	
	@Test
	public void testFindLekarKlSpec() {

		when(korisnikRepoMock.findLekarKlSpec(1L, "NEUROLOGIJA")).thenReturn(Arrays.asList(new Lekar() ));
		List<Lekar>lekari = korisnikService.findLekarKlSpec(1L, "NEUROLOGIJA");
		assertThat(lekari).hasSize(1);
		
		verify(korisnikRepoMock, times(1)).findLekarKlSpec(1L, "NEUROLOGIJA");
        verifyNoMoreInteractions(korisnikRepoMock);
        
	}

}
