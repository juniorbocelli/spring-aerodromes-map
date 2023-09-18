import { IRunway } from './runway';

export interface IAerodrome {
  name: string;
  city: string;
  description: string;
  created_at: string;

  runways: IRunway[];
}