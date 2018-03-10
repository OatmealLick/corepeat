package corepeat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
    public String test(HttpServletRequest request) {
        return "{\"message\":\"Hello guyz\"}";
    }
}
