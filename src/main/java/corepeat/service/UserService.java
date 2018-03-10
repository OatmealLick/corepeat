package corepeat.service;

import corepeat.model.CorepeatUser;

public interface UserService {

    void addUser(CorepeatUser corepeatUser);
    CorepeatUser getUser(Integer userID);

}
