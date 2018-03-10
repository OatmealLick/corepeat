import {InMemoryDbService} from "angular-in-memory-web-api";

export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const users = [
      {id: 1, name: 'Mściwój', surname: 'Brzęczyszczykiewicz'},
      {id: 2, name: 'Alojzy', surname: 'Brzdęk'},
      {id: 3, name: 'Grażyna', surname: 'Karyna'}
    ];
    const mentor = {id: 4, name: 'Adam', surname: 'Małysz'};
    const corepeats = [
      {id: 1, name: 'Nauka do egzaminu z analizy', city: 'Kraków', latitude: 50.5, longtitude: 19.0, description: 'Krótki opis corepeata', maxParticipants: 15, maxMentors: 1, currentParticipants: 3, currentMentors: 0, participants: users, mentor: null},
      {id: 2, name: 'Powtórka przed egzaminem gimnazjalnym z przyry', city: 'Kraków', latitude: 50.5, longtitude: 19.0, description: 'Krótki opis corepeata', maxParticipants: 15, maxMentors: 1, currentParticipants: 0, currentMentors: 0, participants: [], mentor: null},
      {id: 3, name: 'Nauka do egzaminu z anatomii', city: 'Warszawa', latitude: 52.3, longtitude: 20.0, description: 'Krótki opis corepeata', maxParticipants: 10, maxMentors: 1, currentParticipants: 3, currentMentors: 1, participants: users, mentor: mentor}
    ];
    return {corepeats, users}
  }
}
