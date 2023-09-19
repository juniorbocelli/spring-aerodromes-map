import React from 'react';

// interffaces
import {
  IUseDashboardEffects,

  IUseDashboardAPIs
} from 'src/sections/dashboard/Dashboard/types';

export default function useDashboardEffects(apis: IUseDashboardAPIs): IUseDashboardEffects {
  const useComponentDidMount = () => {
    React.useEffect(() => {
      apis.getAllAerodromes();
    }, []);
  };

  return {
    useComponentDidMount,
  };
};