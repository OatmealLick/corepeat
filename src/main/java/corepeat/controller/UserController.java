package corepeat.controller;

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
public class UserController {

    private UserService userService;

    @Autowired
    @Qualifier("userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String test(HttpServletRequest request) {
        return "Person added, it's totally okay :)";
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getUserById(@PathVariable String id) {
        return userService.getUserJSON(new Integer(id));
    }

    @RequestMapping(value = "/users/{id}/corepeats", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getCorepeatsWithUserOfId(@PathVariable String id) {
        return userService.getCorepeatsWithUserOfId(new Integer(id));
    }

    @RequestMapping(value = "/users/{id}/corepeats/{corepeatId}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public String addUserToCorepeat(@PathVariable("id") String id, @PathVariable("corepeatId") String corepeatId) {
        return userService.addUserToCorepeat(new Integer(id), new Integer (corepeatId));
    }

    @RequestMapping(value = "/users/{id}/corepeats/{corepeatId}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public String deleteUserFromCorepeat(@PathVariable("id") String id, @PathVariable("corepeatId") String corepeatId) {
        return userService.deleteUserFromCorepeat(new Integer(id), new Integer (corepeatId));
    }

    @RequestMapping(value = "/users/{id}/mentor/{corepeatId}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public String addMentorToCorepeat(@PathVariable("id") String id, @PathVariable("corepeatId") String corepeatId) {
        return userService.addMentorToCorepeat(new Integer(id), new Integer (corepeatId));
    }

    @RequestMapping(value = "/users/{id}/mentor/{corepeatId}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public String deleteMentorFromCorepeat(@PathVariable("id") String id, @PathVariable("corepeatId") String corepeatId) {
        return userService.deleteMentorFromCorepeat(new Integer(id), new Integer (corepeatId));
    }
}
