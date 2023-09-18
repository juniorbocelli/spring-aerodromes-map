import { AxiosError } from 'axios';

// interfaces
import {
  IUseRegisterAPIs,

  IUseRegisterStates,
} from 'src/sections/user/register/types';
import { IAxiosExceptionData } from 'src/@types/exception';
// contexts
import { useFeedbackContext } from 'src/hooks/feedbacks';
// services
import { createUserAPI } from 'src/services/user';

export function useRegisterAPIs(states: IUseRegisterStates): IUseRegisterAPIs {
  const { states: feedbackStates } = useFeedbackContext();
  const { setIsQueryingAPI, setErrorMessageFromAxiosError } = feedbackStates;

  const registerUser = (name: string, email: string, password: string) => {
    setIsQueryingAPI(true);

    createUserAPI(name, email, password)
      .then(response => {
        if (process.env.NODE_ENV === 'development')
          console.log('Response -> createUserAPI', response);

        states.setIsSuccess(true);
      })
      .catch((error: AxiosError<IAxiosExceptionData>) => {
        setErrorMessageFromAxiosError(error);
      })
      .finally(() => {
        setIsQueryingAPI(false);
      });
  };

  return {
    registerUser,
  }
}