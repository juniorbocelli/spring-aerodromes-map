import axios from 'src/utils/axios';
import * as Routes from 'src/routes/apis';

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