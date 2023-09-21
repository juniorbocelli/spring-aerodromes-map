import React from 'react';

// @types
import {
  IUseRegisterStates,

  IsSuccessState,
} from 'src/sections/user/register/types';

// ----------------------------------------------------------------------

export function useRegisterStates(): IUseRegisterStates {
  const [isSuccess, setIsSuccess] = React.useState<IsSuccessState>(false);

  return {
    isSuccess,
    setIsSuccess,
  };
};