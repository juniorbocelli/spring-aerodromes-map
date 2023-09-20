import React from 'react';
import { LatLngExpression } from 'leaflet';

import {
  IUseDashboardStates,

  AerodromesStates,
} from 'src/sections/dashboard/Dashboard/types'

export default function useDashboardStates(): IUseDashboardStates {
  const [aerodromes, setAerodromes] = React.useState<AerodromesStates>([]);
  const [mapCenter, setMapCenter] = React.useState<LatLngExpression>({ lat: -22.0184339, lng: -47.893888 });

  return {
    aerodromes,
    setAerodromes,

    mapCenter,
    setMapCenter,
  };
};