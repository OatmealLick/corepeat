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
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CorepeatServiceImpl implements CorepeatService {

    private CorepeatDAO corepeatDAO;
    private UserDAO userDAO;

    @Autowired
    @Qualifier("corepeatDAO")
    public void setCorepeatDAO(CorepeatDAO corepeatDAO) {
        this.corepeatDAO = corepeatDAO;
    }

    @Override
    @Transactional
    public void addCorepeat(Corepeat corepeat) {
        this.corepeatDAO.addCorepeat(corepeat);
    }

    @Override
    @Transactional
    public Corepeat getCorepeatById(Integer id) {
        return this.corepeatDAO.getCorepeatById(id);
    }

    @Override
    @Transactional
    public String getCorepeatJSON(Integer id) {
        Corepeat corepeat = this.corepeatDAO.getCorepeatById(id);
        //System.out.println(corepeat.getParticipants());
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new Hibernate5Module());
            return mapper.writeValueAsString(corepeat);
        } catch (JsonProcessingException e) {
            return "redirect:error";
        }
    }

    @Override
    @Transactional
    public Integer addCorepeatFromJSON(String corepeatBody) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Hibernate5Module());
        try {
            Corepeat corepeat = mapper.readValue(corepeatBody, Corepeat.class);
            this.corepeatDAO.addCorepeat(corepeat);
            return corepeat.getCorepeatId();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    @Transactional
    public String getCorepeatsJSON() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Hibernate5Module());
        try {
            List<Corepeat> corepeats = this.corepeatDAO.getCorepeats();
            return mapper.writeValueAsString(corepeats);
        } catch (IOException e) {
            e.printStackTrace();
            return "0";
        }
    }

}
