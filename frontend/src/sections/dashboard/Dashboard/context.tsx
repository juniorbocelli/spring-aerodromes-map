import React from 'react';
// @types
import {
  IUseDashboardContext,
  IUseDashboardStates,
} from 'src/sections/dashboard/Dashboard/types';
// APIs
import useDashboardAPIs from 'src/sections/dashboard/Dashboard/apis';
// Effects
import useDashboardEffects from 'src/sections/dashboard/Dashboard/effects';

// ----------------------------------------------------------------------

const DashboardContext = React.createContext({} as IUseDashboardContext);

interface IDashboardContextProviderProps extends React.PropsWithChildren {
  states: IUseDashboardStates;
};

export const DashboardContextProvider: React.FC<IDashboardContextProviderProps> = ({ children, states }) => {
  /**
   * STATES
   */
  const {
    aerodromes,
    setAerodromes,

    mapCenter,
    setMapCenter,
  } = states;

  const _states = React.useMemo(() => (
    {
      aerodromes,
      setAerodromes,

      mapCenter,
      setMapCenter,
    }
  ), [
    aerodromes,
    setAerodromes,

    mapCenter,
    setMapCenter,
  ]);

  /**
   * APIs
   */
  const _apis = useDashboardAPIs(states);

  /**
   * EFFECTS
   */
  const _effects = useDashboardEffects(_apis);

  const contexts = React.useMemo(() => ({ states: _states, apis: _apis, effects: _effects }), [_states, _apis, _effects]);

  return (
    <DashboardContext.Provider value={contexts}>
      {children}
    </DashboardContext.Provider>
  );
};

export function useDashboardContext() {
  const context = React.useContext(DashboardContext);
  return context;
};