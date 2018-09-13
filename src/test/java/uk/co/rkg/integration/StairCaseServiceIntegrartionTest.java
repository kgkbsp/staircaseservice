package uk.co.rkg.integration;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StairCaseServiceIntegrartionTest {
    //TODO - This goes in the env.properties
    private String baseUrl = "http://localhost:8080/staircase/stairs/";

    @Test
    public void testStairCaseServiceIsResponsive(){
        int count = 3;
        given().
                when().
                get(baseUrl + count).
                then().
                assertThat().
                statusCode(200).
                and().
                assertThat().body(org.hamcrest.Matchers.equalTo("3"));
    }

    @Test
    public void testCORSBySetOrigin(){
        //TODO
    }

    @Test
    public void testJSONDocs(){
        //TODO
    }
}
