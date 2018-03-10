package corepeat.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import corepeat.model.Corepeat;
import corepeat.service.CorepeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/corepeats", method = RequestMethod.POST)
    @ResponseBody
    public void addCorepeat(HttpServletRequest request, HttpServletResponse response) {
        try {
            String corepeatBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            this.corepeatService.addCorepeatFromJSON(corepeatBody);
        } catch (IOException e) {
            response.setStatus(500);
        }
    }
}
