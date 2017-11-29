package be.cegeka.selfEval5.domain.highway;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class HighwayServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private HighwayService highwayService;

    @Mock
    private HighwayRepository highwayRepository;

    @Test
    public void whenCallingAddHighway_ShouldCallHighwayRepository() throws Exception {
        highwayService.addHighway("R22", 57);
        verify(highwayRepository).addHighway(new Highway("R22", 57));
    }

    @Test
    public void whenCallingGetHighwayDetails_ShouldCallHighwayRepository() throws Exception {
        highwayService.getHighwayDetails(2);
        verify(highwayRepository).getHighwayDetails(2);
    }

    @Test
    public void whenCallingGetAllHighway_ShouldCallHighwayRepository() throws Exception {
        highwayService.getAllHighways();
        verify(highwayRepository).getAllHighways();
    }
}