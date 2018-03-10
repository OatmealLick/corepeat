export class Corepeat {
  id: number;
  name: string;
  city: string;
  latitude: number;
  longtitude: number;
  description: string;
  maxParticipants: number;
  maxMentors: number;
  currentParticipants: number;
  currentMentors: number;
  participants: User[];
  mentor: User;

  constructor() {}
}
