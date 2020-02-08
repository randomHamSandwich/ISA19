package com.isa.isa19.testing.ServiceImpTest;

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
import com.isa.isa19.repository.LekRepo;
import com.isa.isa19.service.LekServiceImp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LekServiceImpTest {
	@Mock
	private LekRepo lekRepoMock;
	@Mock
	private Lek lekMock;
	@InjectMocks
	private LekServiceImp lekServiceImp;
	
	@Test
	public void testFindAlergijeKorisnika() {

		when(lekRepoMock.findAlergijeKorisnika(1L)).thenReturn(Arrays.asList(new Lek(1L, "TEST1", null, null, null)));
		List<LekDTO> lekovi = lekServiceImp.findAlergijeKorisnika(1L);
		assertThat(lekovi).hasSize(1);

		verify(lekRepoMock, times(1)).findAlergijeKorisnika(1L);
        verifyNoMoreInteractions(lekRepoMock);
        
	}
	
	

}
