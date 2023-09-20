export interface IUser {
  id: number;

  name: string;
  email: string;
};

export interface ILoggedUser extends IUser {
  token: string;
}