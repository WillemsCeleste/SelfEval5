package be.cegeka.selfEval5.application;

import be.cegeka.selfEval5.domain.highway.Highway;
import be.cegeka.selfEval5.domain.highway.HighwayService;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HighwayControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private HighwayController highwayController;

    @Mock
    private HighwayService highwayService;

    @Test
    public void whenCallingAddHighway_ShouldCallOnHighwayService() throws Exception {
        highwayController.addHighway("E40", 300);

        verify(highwayService).addHighway("E40", 300);
    }

    @Test
    public void whenCallingGetHighwayDetails_ShouldCallOnHighwayService() throws Exception {
        Highway straat = new Highway ("T76", 685);

        when(highwayService.getHighwayDetails(straat.getId())).thenReturn(straat);
        Assertions.assertThat(highwayController.getHighwayDetails(straat.getId())).isEqualTo(straat);
    }

    @Test
    public void whenCallingGetAllHighways_ShouldCallOnHighwayService() throws Exception {
        highwayController.getAllHighways();
        verify(highwayService).getAllHighways();
    }
}