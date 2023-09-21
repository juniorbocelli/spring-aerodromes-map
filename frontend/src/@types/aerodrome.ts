import { IRunway } from './runway';

export interface IAerodrome {
  id: number;

  name: string;
  city: string;
  description: string;
  createdAt: string;

  dms: string;

  runways: IRunway[];
}