package corepeat.service;

import corepeat.model.Corepeat;
import corepeat.model.CorepeatUser;

import java.util.List;

public interface UserService {

    void addUser(CorepeatUser corepeatUser);
    CorepeatUser getUser(Integer userId);
    String getUserJSON(Integer userId);
    String getCorepeatsWithUserOfId(Integer userId);
    String addUserToCorepeat(Integer id, Integer corepeatId);
}
