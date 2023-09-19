import axios from 'src/utils/axios';
import * as Routes from 'src/routes/apis';
import { IUser } from 'src/@types/user';

// ----------------------------------------------------------------------

export function createUserAPI(name: string, email: string, password: string) {
  return axios.post(Routes.API_USER_URL.newUser,
    {
      name,
      email,
      password
    }
  );
};

export function getUserAPI(id: number) {
  return axios.get<IUser[]>(Routes.API_USER_URL.getUser.replace(':id', String(id)));
};