package corepeat.service;

import corepeat.dao.CorepeatDAO;
import corepeat.model.Corepeat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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
        return null;
    }
}
