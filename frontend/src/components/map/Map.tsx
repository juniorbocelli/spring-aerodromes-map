import React from 'react';
// @mui
import { Box } from '@mui/material';
// map
import { MapContainer, TileLayer } from 'react-leaflet';
import { LatLngExpression } from 'leaflet';
// @types
import { IAerodrome } from 'src/@types/aerodrome';
// components
import MapCenterPosition from 'src/components/map/MapCenterPosition';
import AerodromeMapItem from 'src/components/map/AerodromeMapItem';
//
import uuidv4 from 'src/utils/uuidv4';


// ----------------------------------------------------------------------

interface IMapProps {
  mapCenter: LatLngExpression;
  mapCenterText: string;
  isBrowserPosition: boolean;
  aerodromes: IAerodrome[];
};

const Map: React.FC<IMapProps> = ({ mapCenter, mapCenterText, isBrowserPosition, aerodromes }) => {
  const [center, setCenter] = React.useState<LatLngExpression>(mapCenter);

  return (
    <Box sx={{ height: 800, width: '100%' }} component="div">
      <MapContainer id="map" center={mapCenter} zoom={13} scrollWheelZoom>

        <TileLayer
          attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
        />
        <MapCenterPosition
          mapCenter={mapCenter}
          mapCenterText={mapCenterText}
          isBrowserPosition={isBrowserPosition}
        />

        {
          aerodromes.map(a => <AerodromeMapItem key={uuidv4()} radius={5000} color="red" aerodrome={a} />)
        }
      </MapContainer>
    </Box>
  );
};

export default Map;