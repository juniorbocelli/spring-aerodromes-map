import React from 'react';

// @types
import {
  IFeedbackContext,
  IUseFeedbackStates,
} from 'src/hooks/feedbacks/types';

// ----------------------------------------------------------------------

const FeedbackContext = React.createContext({} as IFeedbackContext);

interface ISetFeedbackProviderProps extends React.PropsWithChildren {
  states: IUseFeedbackStates;
};

export const FeedbackContextProvider: React.FC<ISetFeedbackProviderProps> = ({ children, states }) => {
  /**
   * STATES
   */
  const {
    isQueryingAPI,
    setIsQueryingAPI,

    isLoadingTable,
    setIsLoadingTable,

    dialogMessage,
    setDialogMessage,

    setErrorMessageFromAxiosError,
  } = states;

  const _states = React.useMemo(() => (
    {
      isQueryingAPI,
      setIsQueryingAPI,

      isLoadingTable,
      setIsLoadingTable,

      dialogMessage,
      setDialogMessage,

      setErrorMessageFromAxiosError,
    }
  ), [
    isQueryingAPI,
    setIsQueryingAPI,

    isLoadingTable,
    setIsLoadingTable,

    dialogMessage,
    setDialogMessage,

    setErrorMessageFromAxiosError,
  ]);

  const contexts = React.useMemo(() => ({ states: _states }), [_states]);

  return (
    <FeedbackContext.Provider value={contexts} >
      {children}
    </FeedbackContext.Provider>
  );
};

export function useFeedbackContext() {
  const context = React.useContext(FeedbackContext);
  return context;
};