package corepeat.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import corepeat.model.CorepeatUser;
import corepeat.model.Login;
import corepeat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    @Qualifier("userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    @CrossOrigin
    public void addUser(@RequestBody String userBody, HttpServletResponse response) {
        this.userService.addUserFromJSON(userBody);
        response.setStatus(200);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public void loginUser(@RequestBody String loginBody, HttpServletResponse response) {
        Login login = this.userService.createLoginFromJSON(loginBody);
        response.setStatus(401);
        if (login != null) {
            CorepeatUser corepeatUser = this.userService.validateUser(login);
            if (corepeatUser != null) {
                if (login.getPassword().equals(new String(corepeatUser.getPasswordHash()))) response.setStatus(200);
            }
        }
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public String getUserById(@PathVariable String id) {
        return userService.getUserJSON(new Integer(id));
    }

    @RequestMapping(value = "/users/{id}/corepeats", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public String getCorepeatsWithUserOfId(@PathVariable String id) {
        return userService.getCorepeatsWithUserOfId(new Integer(id));
    }

    @RequestMapping(value = "/users/{id}/corepeats/{corepeatId}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public String addUserToCorepeat(@PathVariable("id") String id, @PathVariable("corepeatId") String corepeatId) {
        return userService.addUserToCorepeat(new Integer(id), new Integer (corepeatId));
    }

    @RequestMapping(value = "/users/{id}/corepeats/{corepeatId}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public String deleteUserFromCorepeat(@PathVariable("id") String id, @PathVariable("corepeatId") String corepeatId) {
        return userService.deleteUserFromCorepeat(new Integer(id), new Integer (corepeatId));
    }

    @RequestMapping(value = "/users/{id}/mentor/{corepeatId}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public String addMentorToCorepeat(@PathVariable("id") String id, @PathVariable("corepeatId") String corepeatId) {
        return userService.addMentorToCorepeat(new Integer(id), new Integer (corepeatId));
    }

    @RequestMapping(value = "/users/{id}/mentor/{corepeatId}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public String deleteMentorFromCorepeat(@PathVariable("id") String id, @PathVariable("corepeatId") String corepeatId) {
        return userService.deleteMentorFromCorepeat(new Integer(id), new Integer (corepeatId));
    }
}
