package corepeat.controller;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import corepeat.model.CorepeatUser;
import corepeat.service.AchievementService;
import corepeat.service.CorepeatService;
import corepeat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.*;
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

}
