package corepeat.dao;

import corepeat.model.Corepeat;

public interface CorepeatDAO {

    void addCorepeat(Corepeat corepeat);
    Corepeat getCorepeatById(Integer id);
}
