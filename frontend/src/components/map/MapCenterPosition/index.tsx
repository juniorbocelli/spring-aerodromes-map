import React from 'react';
// map
import { Popup, Marker, useMap } from 'react-leaflet';
import { LatLngExpression } from 'leaflet';

// hooks
import useMapCenterPositionStates from './states';
import useMapCenterPositionEffects from './effects';
// @types
import { IMapCenterPositionProps } from './types';

// ----------------------------------------------------------------------

function ChangeView(center: LatLngExpression, zoom?: number) {
  const map = useMap();
  map.setView(center, zoom);
  return null;
};

// ----------------------------------------------------------------------

const MapCenterPosition: React.FC<IMapCenterPositionProps> = (props) => {
  const {
    mapCenter,
    mapCenterText,
    isBrowserPosition,
  } = props;

  // states
  const states = useMapCenterPositionStates(mapCenter, mapCenterText);
  const {
    mapCenter: mapCenterState,
    mapCenterText: mapCenterTextState,
  } = states;

  // effects
  const {
    useComponentDidMount,
  } = useMapCenterPositionEffects(states);
  useComponentDidMount(isBrowserPosition);

  return (
    <Marker position={mapCenterState}>
      {ChangeView(mapCenterState)}
      <Popup>
        {mapCenterTextState}
      </Popup>
    </Marker>
  );
};

export default MapCenterPosition;