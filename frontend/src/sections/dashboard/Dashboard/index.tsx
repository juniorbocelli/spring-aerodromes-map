import React from 'react';
// @mui
import {
  Button,
  SxProps
} from '@mui/material';
import { Theme } from '@mui/material/styles';
// components
import { Container } from 'src/components/container';
import { Map } from 'src/components/map';
import { UploadAerodromes } from 'src/components/modal-dialog';
// contexts
import { useDashboardContext } from 'src/sections/dashboard/Dashboard/context';
//

// ----------------------------------------------------------------------

interface IDashboardProps {
  sx?: SxProps<Theme>;
};

const Dashboard: React.FC<IDashboardProps> = ({ sx }) => {
  const context = useDashboardContext();
  const { useComponentDidMount } = context.effects;
  const { getAllAerodromes, newFromUpload } = context.apis;
  const {
    aerodromes,
    mapCenter,
  } = context.states;

  // Local states
  const [open, setOpen] = React.useState<boolean>(false);
  const handleButtonClick = () => {
    setOpen(true);
  }

  // Efects
  useComponentDidMount();

  return (
    <Container sx={{ minHeight: '100%', p: { xs: 1, md: 5 } }}>
      <UploadAerodromes
        isOpen={open}
        onClose={() => {
          setOpen(false);
          getAllAerodromes();
        }}
        onSubmitForm={newFromUpload}
      />

      <Button onClick={handleButtonClick} size="small">
        Adicionar aerodromes
      </Button>

      {/**
       * Map here
       */}
      <Map
        mapCenter={mapCenter}
        aerodromes={aerodromes}
        mapCenterText="São Carlos - SP"
        isBrowserPosition
      />
    </Container >
  );
};

export default Dashboard;