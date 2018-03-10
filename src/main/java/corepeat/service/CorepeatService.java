package corepeat.service;

import corepeat.model.Corepeat;

public interface CorepeatService {

    void addCorepeat(Corepeat corepeat);
    Corepeat getCorepeatById(Integer id);
    String getCorepeatJSON(Integer id);
    void addCorepeatFromJSON(String corepeatBody);
}
