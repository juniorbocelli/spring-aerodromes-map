import React from 'react';

import { IAerodrome } from 'src/@types/aerodrome';

/**
 * STATES
 */
export type AerodromesStates = IAerodrome[];

export interface IUseDashboardStates {
  aerodromes: AerodromesStates;
  setAerodromes: React.Dispatch<React.SetStateAction<IAerodrome[]>>;
};

/**
 * APIs
 */
export interface IUseDashboardAPIs {
  getAllAerodromes: () => void;
};


/**
 * EFFECTS
 */
export interface IUseDashboardEffects {
  useComponentDidMount: () => void;
};


/**
 * CONTEXT
 */
export interface IUseDashboardContext {
  states: IUseDashboardStates;
  apis: IUseDashboardAPIs;
  effects: IUseDashboardEffects;
};