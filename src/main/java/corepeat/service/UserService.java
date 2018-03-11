package corepeat.service;

import corepeat.model.CorepeatUser;
import corepeat.model.Login;

import java.util.List;

public interface UserService {

    void addUser(CorepeatUser corepeatUser);
    CorepeatUser getUser(Integer userId);
    CorepeatUser validateUser(Login login);
    Login createLoginFromJSON(String loginBody);
    String getUserJSON(Integer userId);
    String getCorepeatsWithUserOfId(Integer userId);
    String addUserToCorepeat(Integer id, Integer corepeatId);
    String deleteUserFromCorepeat(Integer id, Integer corepeatId);
    String addMentorToCorepeat(Integer id, Integer corepeatId);
    String deleteMentorFromCorepeat(Integer id, Integer corepeatId);
    Integer addUserFromJSON(String userBody);
}
