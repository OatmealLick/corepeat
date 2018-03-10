package corepeat.service;

import corepeat.model.Corepeat;

public interface CorepeatService {

    void addCorepeat(Corepeat corepeat);
    Corepeat getCorepeatById(Integer id);
}
