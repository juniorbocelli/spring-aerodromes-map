import React from 'react';

//
import {
  IUseMapCenterPositionEffects,
  IUseMapCenterPositionStates,
} from './types';

// ----------------------------------------------------------------------

export default function useMapCenterPositionEffects(states: IUseMapCenterPositionStates): IUseMapCenterPositionEffects {
  const {
    setMapCenter,

    setMapCenterText,
  } = states;

  const useComponentDidMount = (isBrowserPosition: boolean) => {
    React.useEffect(() => {
      if (isBrowserPosition)
        getLocation();
    }, [isBrowserPosition]);
  };


  function getLocation() {
    if (navigator.geolocation)
      navigator.geolocation.getCurrentPosition(showPosition);

  };

  function showPosition(position: GeolocationPosition) {
    setMapCenter({ lat: position.coords.latitude, lng: position.coords.longitude });
    setMapCenterText("Você está aqui!");
  };



  return {
    useComponentDidMount,
  };
};