package com.isa.isa19.testing.ServiceImpTest;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.isa.isa19.model.Usluga;
import com.isa.isa19.repository.UslugaRepo;
import com.isa.isa19.service.UslugaServiceImp;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UslugaServiceImpTest {
	
	@Mock
	private UslugaRepo uslugaRepoMock;
	@Mock
	private Usluga uslugaMock;
	@InjectMocks
	private UslugaServiceImp uslugaService;
	
	@Test
	public void findUsluga() {

		when(uslugaRepoMock.findUsluga("NEUROLOGIJA",1L )).thenReturn(Optional.of(uslugaMock));
		Usluga dbUsluga = uslugaService.findUsluga("NEUROLOGIJA",1L).get();
		assertEquals(uslugaMock, dbUsluga);
		
		verify(uslugaRepoMock, times(1)).findUsluga("NEUROLOGIJA",1L);
        verifyNoMoreInteractions(uslugaRepoMock);
        
	}
	
	
	

}
