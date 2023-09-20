import axios from 'src/utils/axios';
import * as Routes from 'src/routes/apis';
import { IUser, ILoggedUser } from 'src/@types/user';

// ----------------------------------------------------------------------

export function loginAPI(email: string, password: string) {
  return axios.post<ILoggedUser>(Routes.API_AUTH_URL.login,
    {
      email,
      password,
    }
  );
};

export function checkSessionAPI(id: number) {
  return axios.get<IUser>(Routes.API_USER_URL.getUser.replace(':id', String(id)));
};

export function logoutAPI() {
  return axios.patch(Routes.API_AUTH_URL.logout);
};