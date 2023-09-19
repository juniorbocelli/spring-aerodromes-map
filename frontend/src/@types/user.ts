export interface IUser {
  id: number;

  name: string;
  email: string;
};

export interface IUserWithToken extends IUser {
  token: string;
}