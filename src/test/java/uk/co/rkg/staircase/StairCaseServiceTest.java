package uk.co.rkg.staircase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;


public class StairCaseServiceTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private StairCaseService stairCaseService;

    @Before
    public void setUp() {
        stairCaseService = new StairCaseService();
    }

    @Test
    public void testCountWaysCalculatesFor0Correctly() {
        int stairsCount = 0;
        assertEquals(0, StairCaseService.countWays(stairsCount));
    }

    @Test
    public void testCountWaysCalculatesFor1Correctly() {
        int stairsCount = 1;
        assertEquals(1, StairCaseService.countWays(stairsCount));
    }

    @Test
    public void testCountWaysCalculatesFor2Correctly() {
        int stairsCount = 2;
        assertEquals(2, StairCaseService.countWays(stairsCount));
    }

    @Test
    public void testCountWaysCalculatesForGraterThan2Correctly() {
        int stairsCount = 4;
        assertEquals(5, StairCaseService.countWays(stairsCount));
    }

    @Test(expected = NullPointerException.class)
    public void testCountWaysCalculatesForNullCorrectly() throws Exception {
        assertEquals(5, StairCaseService.countWays(Integer.getInteger("")));
    }

    //TODO - dev to confirm exact error
    @Test(expected = Exception.class)
    public void testCountWaysCalculatesForNegativeIntegerCorrectly() {
        int stairsCount = -6;
        StairCaseService.countWays(stairsCount);
    }
}