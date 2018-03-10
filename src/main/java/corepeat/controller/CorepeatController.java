package corepeat.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import corepeat.model.Corepeat;
import corepeat.service.CorepeatService;
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

    @Autowired
    @Qualifier("corepeatService")
    public void setCorepeatService(CorepeatService corepeatService) {
        this.corepeatService = corepeatService;
    }

    @RequestMapping(value = "/corepeats/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getCorepeatById(@PathVariable String id) {
        return this.corepeatService.getCorepeatJSON(new Integer(id));
    }

    @RequestMapping(value = "/corepeats/{userId}", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public void addCorepeat(@RequestBody String corepeatBody, @PathVariable String userId, HttpServletResponse response) {
        this.corepeatService.addCorepeatFromJSON(corepeatBody);

        response.setStatus(200);
    }
}
