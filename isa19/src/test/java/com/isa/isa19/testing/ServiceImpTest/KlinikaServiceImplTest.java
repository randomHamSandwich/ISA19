package com.isa.isa19.testing.ServiceImpTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
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

import com.isa.isa19.model.Klinika;
import com.isa.isa19.model.Usluga;
import com.isa.isa19.repository.KlinikaRepo;
import com.isa.isa19.repository.UslugaRepo;
import com.isa.isa19.service.KlinikaServiceImpl;
import com.isa.isa19.service.UslugaServiceImp;
@RunWith(SpringRunner.class)
@SpringBootTest

public class KlinikaServiceImplTest {
	
	@Mock
	private KlinikaRepo klinikaRepoMock;
	@Mock
	private Klinika klinikaMock;
	@InjectMocks
	private KlinikaServiceImpl klinikaService;
	
	@Test
	public void testFindClincSpec() {

		when(klinikaRepoMock.findClincSpec("NEUROLOGIJA" )).thenReturn(Arrays.asList(new Klinika( )));
		List<Klinika >klinike= klinikaService.findClincSpec("NEUROLOGIJA");
		assertThat(klinike).hasSize(1);
		
		verify(klinikaRepoMock, times(1)).findClincSpec("NEUROLOGIJA");
        verifyNoMoreInteractions(klinikaRepoMock);
        
	}

}
