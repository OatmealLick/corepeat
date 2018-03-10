package corepeat.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import corepeat.dao.CorepeatDAO;
import corepeat.dao.UserDAO;
import corepeat.model.Corepeat;
import corepeat.model.CorepeatUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;
    private CorepeatDAO corepeatDAO;

    @Autowired
    @Qualifier("userDAO")
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Autowired
    @Qualifier("corepeatDAO")
    public void setCorepeatDAO (CorepeatDAO corepeatDAO) {
        this.corepeatDAO = corepeatDAO;
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

    @Override
    @Transactional
    public String getCorepeatsWithUserOfId(Integer userId) {
        CorepeatUser corepeatUser = this.userDAO.getUserById(userId);
        List<Corepeat> corepeats = new ArrayList<>(corepeatUser.getCorepeats());
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new Hibernate5Module());
            return mapper.writeValueAsString(corepeats);
        } catch (JsonProcessingException e) {
            return "redirect:error";
        }
    }

    @Override
    @Transactional
    public String addUserToCorepeat(Integer id, Integer corepeatId) {
        CorepeatUser corepeatUser = this.userDAO.getUserById(id);
        Corepeat corepeat = this.corepeatDAO.getCorepeatById(corepeatId);
        corepeat.setCurrentParticipants(corepeat.getCurrentParticipants()+1);
        corepeatUser.getCorepeats().add(corepeat);
        corepeat.getParticipants().add(corepeatUser);
        return "1";
    }

    @Override
    @Transactional
    public String deleteUserFromCorepeat(Integer id, Integer corepeatId) {
        CorepeatUser corepeatUser = this.userDAO.getUserById(id);
        Corepeat corepeat = this.corepeatDAO.getCorepeatById(corepeatId);
        corepeatUser.getCorepeats().remove(corepeat);
        corepeat.setCurrentParticipants(corepeat.getCurrentParticipants()-1);
        corepeat.getParticipants().remove(corepeatUser);
        return "1";
    }


}
