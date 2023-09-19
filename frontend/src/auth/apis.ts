import { AxiosError } from 'axios';
import { IAxiosExceptionData } from 'src/@types/exception';

// APIs
import {
  loginAPI,
  checkSessionAPI,
  logoutAPI,
} from 'src/services/auth';
// Types and interfaces
import { IUserWithToken } from 'src/@types/user';
import { IAuthStates, } from 'src/auth/types';
// Others imports
import LocalStorage from 'src/utils/localStorage';
import SanitizerString from 'src/utils/sanitizerString';

export interface IUseAuthAPI {
  login: (username: string, password: string) => void;
  logout: () => void;
  checkSession: () => void;
};

// APIs =============================================================================================================================================
function useAuthAPIs(states: IAuthStates): IUseAuthAPI {
  const setLogged = (user: IUserWithToken) => {
    if (typeof user.id !== "undefined" && typeof user.token !== "undefined") {
      states.setLoggedUser({
        id: user.id,
        name: user.name,
        email: user.email,
      });

      LocalStorage.setToken(user.token || LocalStorage.getDefaultToken());
      LocalStorage.setId(typeof user.id !== 'undefined' ? String(user.id) : LocalStorage.getDefaultId());
    } else {
      throw new Error("Informações de login incompletas ou usuário desativado");
    };
  };

  const setNotLogged = () => {
    states.setLoggedUser(null);
    LocalStorage.setTokenAsDefault();
    LocalStorage.setIdAsDefault();
  };

  const login = (username: string, password: string) => {
    states.setIsQueryingAPI(true);

    loginAPI(username, password)
      .then(async response => {
        // Verify if user exist
        if (SanitizerString.stringOrNull(response.data.token) !== null) {
          const user = response.data;

          try {
            // Set loggedIn routines
            setLogged(user);

          } catch (error) {
            setNotLogged();
            states.setErrorMessage(error as string);
          };
        }
      })
      .catch((error: AxiosError<IAxiosExceptionData>) => {
        setNotLogged();
        states.setAxiosErrorMessage(error);
      })
      .finally(() => {
        states.setIsQueryingAPI(false);
      });
  };

  const logout = () => {
    setNotLogged();
    states.setIsQueryingAPI(true);

    logoutAPI()
      .then(response => {

      })
      .catch((error: AxiosError<IAxiosExceptionData>) => {
        states.setAxiosErrorMessage(error);
      })
      .finally(() => {
        states.setIsQueryingAPI(false);
      });
  };

  const checkSession = () => {
    // If not exist token, client is not logged
    if (LocalStorage.getToken() === LocalStorage.getDefaultToken()) {
      states.setLoggedUser(null);

      return;
    };

    states.setLoggedUser(undefined);

    checkSessionAPI(Number(LocalStorage.getId()))
      .then(response => {
        // Verify if user exist
        if (SanitizerString.stringOrNull(response.data.email) !== null) {
          const user = response.data;

          // Set loggedIn routines
          states.setLoggedUser(user);
        };
      })
      .catch((error: AxiosError<IAxiosExceptionData>) => {
        setNotLogged();
        states.setAxiosErrorMessage(error);
      })
      .finally(() => {

      });
  };

  return {
    login,
    logout,
    checkSession,
  };
};

export default useAuthAPIs;