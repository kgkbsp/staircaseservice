package uk.co.rkg.servicemock;

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.extension.ResponseDefinitionTransformer;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.ResponseDefinition;

public class StairCaseRestServiceMock extends ResponseDefinitionTransformer {
    @Override
    public ResponseDefinition transform(Request request, ResponseDefinition responseDefinition, FileSource files, Parameters parameters) {
        String[] urlParts = request.getAbsoluteUrl().split("/");

        return new ResponseDefinitionBuilder()
                .withStatus(200)
                .withBody(urlParts[urlParts.length - 1])
                .build();
    }

    public String getName() {
        return "bodyContentTransformer";
    }

    @Override
    public boolean applyGlobally() {
        return false;
    }
}
