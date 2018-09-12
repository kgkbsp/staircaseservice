package uk.co.rkg.staircase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StairCaseServiceTest {

    @InjectMocks
    private StairCaseController stairCaseController;

    @Test
    public void testGetProbability_ShouldCallService_AndReturnLProbabilityCount() {
        //GIVEN
        final int stairsCount = 3;

        final int actualWaysResponse = stairCaseController.countWays(3);
        assertEquals(2, actualWaysResponse);
    }
}
