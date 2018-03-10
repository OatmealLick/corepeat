package corepeat.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import corepeat.dao.CorepeatDAO;
import corepeat.model.Corepeat;
import corepeat.model.CorepeatUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.IOException;

public class CorepeatServiceImpl implements CorepeatService {

    private CorepeatDAO corepeatDAO;

    @Autowired
    @Qualifier("corepeatDAO")
    public void setCorepeatDAO(CorepeatDAO corepeatDAO) {
        this.corepeatDAO = corepeatDAO;
    }

    @Override
    public void addCorepeat(Corepeat corepeat) {
    }

    @Override
    public Corepeat getCorepeatById(Integer id) {
        return this.corepeatDAO.getCorepeatById(id);
    }

    @Override
    public String getCorepeatJSON(Integer id) {
        Corepeat corepeat = this.corepeatDAO.getCorepeatById(id);
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new Hibernate5Module());
            return mapper.writeValueAsString(corepeat);
        } catch (JsonProcessingException e) {
            return "redirect:error";
        }
    }

    @Override
    public void addCorepeatFromJSON(String corepeatBody) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Hibernate5Module());
        try {
            Corepeat corepeat = mapper.readValue(corepeatBody, Corepeat.class);
            this.corepeatDAO.addCorepeat(corepeat);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
