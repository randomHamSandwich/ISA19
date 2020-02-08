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

import com.isa.isa19.model.Karton;
import com.isa.isa19.repository.KartonRepo;
import com.isa.isa19.service.KartonServiceImp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KartonServiceImpTest {
	
	@Mock
	private KartonRepo kartonRepoMock;
	@Mock
	private Karton kartonMock;
	@InjectMocks
	private KartonServiceImp kartonService;
	
	@Test
	public void testGetDTO() {

		when(kartonRepoMock.findKartonByPacijentID(1L)).thenReturn(Optional.of(kartonMock));
		Karton karton= kartonService.findKartonByPacijentID(1L).get();
		assertEquals(kartonMock, karton);
		
		verify(kartonRepoMock, times(1)).findKartonByPacijentID(1L);
        verifyNoMoreInteractions(kartonRepoMock);
        
	}


}
