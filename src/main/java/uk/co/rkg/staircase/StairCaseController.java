package uk.co.rkg.staircase;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiError;
import org.jsondoc.core.annotation.ApiErrors;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Api(
        name = "StairCase API",
        description = "Methods for manipulating staircase objects",
        group = "staircase service")
@RestController
@RequestMapping(value = "/staircase/stairs")
@RefreshScope
public class StairCaseController {

    private static final String template = "Number of ways = , %s!";

    private StairCaseService stairCaseService;

    @Autowired
    public StairCaseController(final StairCaseService stairCaseService) {
        this.stairCaseService = stairCaseService;
    }

    @ApiMethod(description = "Retrieves staircase probability for stairs count", stage = ApiStage.BETA)
    @ApiErrors(apierrors = {
            @ApiError(code = "400", description = "Staircase Empty Response"),
            @ApiError(code = "500", description = "No staircase model available error")
    })
    @RequestMapping(method = RequestMethod.GET)
    public @ApiResponseObject
    int countWays(@ApiPathParam(name = "stairsCount", description = "The number of stairs to calculate ways to reach top.")
                  @RequestParam(name = "stairsCount") final int stairsCount) {

        final int probabilityCount = stairCaseService.countWays(stairsCount);

        return probabilityCount;
    }

}
