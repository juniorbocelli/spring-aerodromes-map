import { LatLngExpression } from "leaflet";

// ----------------------------------------------------------------------

/**
 * STATES
 */
export interface IUseMapCenterPositionStates {
  mapCenter: LatLngExpression;
  setMapCenter: React.Dispatch<React.SetStateAction<LatLngExpression>>;

  mapCenterText: string;
  setMapCenterText: React.Dispatch<React.SetStateAction<string>>;
};

/**
 * EFFECTS
 */
export interface IUseMapCenterPositionEffects {
  useComponentDidMount: (isBrowserPosition: boolean) => void;
};

/**
 * COMPONENT
 */
export interface IMapCenterPositionProps {
  mapCenter: LatLngExpression;
  mapCenterText: string;
  isBrowserPosition: boolean;
};