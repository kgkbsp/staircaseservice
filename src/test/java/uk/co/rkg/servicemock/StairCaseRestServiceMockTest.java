package uk.co.rkg.servicemock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class StairCaseRestServiceMockTest {
    private static final String MAPPING_JSON = "{\"request\":{\"method\":\"GET\",\"urlPattern\":\"/staircase/stairs/.*\"},\"response\":{\"status\":200,\"body\":\"Default Text\",\"transformers\":[\"bodyContentTransformer\"]}}";

    private WireMockServer server;

    @Before
    public void before() {
        server = new WireMockServer(wireMockConfig().extensions(StairCaseRestServiceMock.class));
        StubMapping stubMapping = StubMapping.buildFrom(MAPPING_JSON);
        server.addStubMapping(stubMapping);
        server.start();
    }

    @After
    public void after() {
        server.stop();
    }

    @Test
    public void testWithValidEndPoint() {

        given()
                .when()
                .get("http://localhost:8080/staircase/stairs/10")
                .then()
                .statusCode(200)
                .body(equalTo("10"));

        server.stop();
    }

    @Test
    public void testWithInValidEndPoint() {
        given()
                .when()
                .get("http://localhost:8080/invalid/path")
                .then()
                .statusCode(404);
    }
}
