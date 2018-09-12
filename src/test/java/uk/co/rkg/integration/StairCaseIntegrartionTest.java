package uk.co.rkg.integration;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StairCaseIntegrartionTest {

    private String baseUrl = "http://localhost:8080/staircase/stairs/";

    @Test
    public void testStairCaseServiceIsResponse(){
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
}
