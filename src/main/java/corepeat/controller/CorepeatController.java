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
        Corepeat corepeat = corepeatService.getCorepeatById(new Integer(id));
        try {
            return new ObjectMapper().writeValueAsString(corepeat);
        } catch (JsonProcessingException e) {
            return "redirect:error";
        }
    }
}
