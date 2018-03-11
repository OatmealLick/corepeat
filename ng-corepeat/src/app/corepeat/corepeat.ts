import {User} from "../user/user";

export class Corepeat {
  corepeatId: number;
  name: string;
  city: string;
  date: Date;
  coordinates: string;
  description: string;
  maxParticipants: number;
  maxMentors: number;
  currentParticipants: number;
  currentMentors: number;
  participants: User[];
  mentor: User;

  constructor() {}
}
