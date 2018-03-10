package corepeat.dao;

import corepeat.model.Corepeat;

import java.util.List;

public interface CorepeatDAO {

    void addCorepeat(Corepeat corepeat);
    Corepeat getCorepeatById(Integer id);
    List<Corepeat> getCorepeats();
}
