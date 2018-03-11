package corepeat.controller;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import corepeat.model.CorepeatUser;
import corepeat.service.AchievementService;
import corepeat.service.CorepeatService;
import corepeat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;

@Controller
public class AchievementController {


    private CorepeatService corepeatService;

    private UserService userService;

    private AchievementService achievementService;

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

    @Autowired
    @Qualifier("achievementService")
    public void setAchievementService(AchievementService achievementService) {
        this.achievementService = achievementService;
    }


    @RequestMapping(value = "/grant", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public String grantBaseProgress(){
        achievementService.grantBaseProgress();
        return "done";
    }

    @RequestMapping(value = "/achievements/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public String getAchievementsOfUser(@PathVariable String id, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        return "{\"achievements\": " + new GsonBuilder().create().toJson(achievementService.getAchievementsOfUser(new Integer(id))) + " }";
    }


}
