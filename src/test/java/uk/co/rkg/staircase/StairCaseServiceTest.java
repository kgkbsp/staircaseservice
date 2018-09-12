package uk.co.rkg.staircase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;


public class StairCaseServiceTest {

    private StairCaseService stairCaseService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        stairCaseService = new StairCaseService();
    }

    @Test
    public void testFibCalculatesCorrectly() {

        int stairsCount = 1;

        assertEquals(1, StairCaseService.fib(stairsCount));
    }

//    @Test
//    public void testFibHandlesStairsCountCorrectly() {
//
//        int stairsCount = -12;
//
//        //test type
//        thrown.expect(NameNotFoundException.class);
//
//        //test message
//        thrown.expectMessage(is("Name is empty!"));
//
//         StairCaseService.fib(stairsCount);
//
//
//    }
}