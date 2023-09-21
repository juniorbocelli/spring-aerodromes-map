import { AxiosError } from 'axios';

// interfaces
import { IAxiosExceptionData } from 'src/@types/exception';
import {
  IUseDashboardAPIs,

  IUseDashboardStates,
} from 'src/sections/dashboard/Dashboard/types'
// services
import {
  getAllAerodromesAPI,
  newFromUploadAPI,
} from 'src/services/aerodrome';
// contexts
import { useFeedbackContext } from 'src/hooks/feedbacks';

export default function useDashboardAPIs(states: IUseDashboardStates): IUseDashboardAPIs {
  const { states: feedbackStates } = useFeedbackContext();

  const {
    setIsQueryingAPI,

    setErrorMessageFromAxiosError,
  } = feedbackStates;

  const getAllAerodromes = () => {
    setIsQueryingAPI(true);
    const { setAerodromes } = states;

    getAllAerodromesAPI()
      .then(response => {
        if (process.env.NODE_ENV === 'development')
          console.log('Response -> getAllAerodromesAPI', response);

        setAerodromes(response.data);
      })
      .catch((error: AxiosError<IAxiosExceptionData>) => {
        setErrorMessageFromAxiosError(error);
      })
      .finally(() => {
        setIsQueryingAPI(false);
      });
  };

  const newFromUpload = async (file: FormData) => {
    setIsQueryingAPI(true);

    try {
      const response = await newFromUploadAPI(file);
      if (process.env.NODE_ENV === 'development')
        console.log('Response -> newFromUploadAPI', response);

      return response.data;
    } catch (e) {
      setErrorMessageFromAxiosError(e);

      return null;
    } finally {
      setIsQueryingAPI(false);
    };


    // 

    // newFromUploadAPI(file)
    //   .then(response => {
    //     if (process.env.NODE_ENV === 'development')
    //       console.log('Response -> newFromUploadAPI', response);
    //   })
    //   .catch((error: AxiosError<IAxiosExceptionData>) => {
    //     setErrorMessageFromAxiosError(error);
    //   })
    //   .finally(() => {
    //     setIsQueryingAPI(false);
    //   });
  };

  return {
    getAllAerodromes,
    newFromUpload,
  };
};