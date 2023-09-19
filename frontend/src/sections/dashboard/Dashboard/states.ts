import React from 'react';

import {
  IUseDashboardStates,

  AerodromesStates,
} from 'src/sections/dashboard/Dashboard/types'

export default function useDashboardStates(): IUseDashboardStates {
  const [aerodromes, setAerodromes] = React.useState<AerodromesStates>([]);

  return {
    aerodromes,
    setAerodromes,
  };
};