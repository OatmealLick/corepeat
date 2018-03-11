package corepeat.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import corepeat.model.Corepeat;
import corepeat.service.CorepeatService;
import corepeat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@Controller
public class CorepeatController {

    private CorepeatService corepeatService;
    private UserService userService;

    @Autowired
    @Qualifier("corepeatService")
    public void setCorepeatService(CorepeatService corepeatService) {
        this.corepeatService = corepeatService;
    }

    @Autowired
    @Qualifier("userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/corepeats", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    @CrossOrigin
    public String getCorepeats(HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        return this.corepeatService.getCorepeatsJSON();
    }

    @RequestMapping(value = "/corepeats/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    @CrossOrigin
    public String getCorepeatById(@PathVariable String id, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        return this.corepeatService.getCorepeatJSON(new Integer(id));
    }

    @RequestMapping(value = "/corepeats/{userId}", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    @CrossOrigin
    public void addCorepeat(@RequestBody String corepeatBody, @PathVariable String userId, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        Integer corepeatId = this.corepeatService.addCorepeatFromJSON(corepeatBody);
        this.userService.addUserToCorepeat(new Integer(userId), corepeatId);
        response.setStatus(200);
    }
}
