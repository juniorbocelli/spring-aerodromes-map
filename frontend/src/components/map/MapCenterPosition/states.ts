import React from 'react';
import { LatLngExpression } from 'leaflet';
//
import { IUseMapCenterPositionStates } from './types';

export default function useMapCenterPositionStates(initialPosition: LatLngExpression, mapCenterInitialText: string): IUseMapCenterPositionStates {
  const [mapCenter, setMapCenter] = React.useState<LatLngExpression>(initialPosition);
  const [mapCenterText, setMapCenterText] = React.useState<string>(mapCenterInitialText);

  return {
    mapCenter,
    setMapCenter,

    mapCenterText,
    setMapCenterText,
  };
};