import { Person } from "./person";

export interface Root {
    enum: string;
  id: string;
  person: Person;
  random: number;
  random_float: number;
  bool: boolean;
  date: string;
  regEx: string;
  elt: string;
  creationDate: string;
}
