package uk.co.rkg.staircase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StairCaseController {

    private StairCaseService stairCaseService;

    @Autowired
    public StairCaseController(final StairCaseService stairCaseService) {
        this.stairCaseService = stairCaseService;
    }


    @RequestMapping(value = "/staircase/stairs/{N}", method = RequestMethod.GET)
    @ResponseBody
    public int countWays(@PathVariable("N") int stairsCount) {

        final int probabilityCount = stairCaseService.countWays(stairsCount);

        return probabilityCount;
    }

}
