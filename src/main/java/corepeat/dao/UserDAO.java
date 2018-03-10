package corepeat.dao;

import corepeat.model.CorepeatUser;

public interface UserDAO {

    public void addUser(CorepeatUser corepeatUser);

    public CorepeatUser getUser(Integer userID);
}
