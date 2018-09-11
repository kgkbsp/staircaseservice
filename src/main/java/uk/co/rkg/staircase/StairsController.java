package uk.co.rkg.staircase;

import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class StairsController {

    private static final String template = "Number of ways = , %s!";

    @RequestMapping("/staircase/stairs")
    public Stairs stairs(@RequestAttribute(value = "name") String name) {
        return new Stairs();
    }

}
