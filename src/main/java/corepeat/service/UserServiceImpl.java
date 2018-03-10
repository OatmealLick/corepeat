package corepeat.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import corepeat.dao.UserDAO;
import corepeat.model.CorepeatUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    @Qualifier("userDAO")
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void addUser(CorepeatUser corepeatUser) {
        this.userDAO.addUser(corepeatUser);
    }

    @Override
    @Transactional
    public CorepeatUser getUser(Integer userId) {
        return this.userDAO.getUserById(userId);
    }

    @Override
    @Transactional
    public String getUserJSON(Integer userId) {
        CorepeatUser corepeatUser = this.userDAO.getUserById(userId);
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new Hibernate5Module());
            return mapper.writeValueAsString(corepeatUser);
        } catch (JsonProcessingException e) {
            return "redirect:error";
        }
    }

}
