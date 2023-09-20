import React from 'react';
import { LatLngExpression } from 'leaflet';

import { IAerodrome } from 'src/@types/aerodrome';

/**
 * STATES
 */
export type AerodromesStates = IAerodrome[];
export type BrowserPositionStates = null | LatLngExpression;

export interface IUseDashboardStates {
  aerodromes: AerodromesStates;
  setAerodromes: React.Dispatch<React.SetStateAction<IAerodrome[]>>;

  mapCenter: LatLngExpression;
  setMapCenter: React.Dispatch<React.SetStateAction<LatLngExpression>>;
};

/**
 * APIs
 */
export interface IUseDashboardAPIs {
  getAllAerodromes: () => void;
  newFromUpload: (file: FormData) => void;
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