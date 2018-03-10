package corepeat.controller;

import corepeat.model.Corepeat;
import corepeat.service.CorepeatService;
import corepeat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CorepeatController {

    private CorepeatService corepeatService;

    @Autowired
    @Qualifier("corepeatService")
    public void setCorepeatService(CorepeatService corepeatService) {
        this.corepeatService = corepeatService;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getUser(@PathVariable String id) {
        Corepeat corepeat = corepeatService.getCorepeatById(new Integer(id));
        return null;
    }
}
