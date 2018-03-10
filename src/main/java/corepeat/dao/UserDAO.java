package corepeat.dao;

import corepeat.model.CorepeatUser;

public interface UserDAO {

    void addUser(CorepeatUser corepeatUser);
    CorepeatUser getUserById(Integer userId);
}
