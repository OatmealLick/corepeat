package corepeat.dao;

import corepeat.model.CorepeatUser;

import java.util.stream.Stream;

public interface UserDAO {

    void addUser(CorepeatUser corepeatUser);
    CorepeatUser getUserById(Integer userId);
    Stream<CorepeatUser> getUserStream();
}
