import React from 'react';
import * as Yup from 'yup';
// @mui
import {
  Box,
  Typography,

  SxProps,
  Button,
} from '@mui/material';
import Grid from '@mui/material/Unstable_Grid2';
import { Theme } from '@mui/material/styles';
// form
import { useForm } from 'react-hook-form';
import { yupResolver } from '@hookform/resolvers/yup';

// components
import { Container } from 'src/components/container';
import { Title } from 'src/components/title';
import FormProvider from 'src/components/hook-form';
import { UploadAerodromes } from 'src/components/modal-dialog';
// contexts
import { useDashboardContext } from 'src/sections/dashboard/Dashboard/context';
import { useFeedbackContext } from 'src/hooks/feedbacks';
//
import Strings from 'src/shared/strings';
import uuidv4 from 'src/utils/uuidv4';

// ----------------------------------------------------------------------

interface IDashboardProps {
  sx?: SxProps<Theme>;
};

type FormValuesProps = {
  name: string;
};

const Dashboard: React.FC<IDashboardProps> = ({ sx }) => {
  const context = useDashboardContext();
  const { useComponentDidMount } = context.effects;
  const { getAllAerodromes } = context.apis;
  const { aerodromes } = context.states;

  const { states: feebackStates } = useFeedbackContext();

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
      />

      <Button onClick={handleButtonClick}>
        Adicionar aerodromes
      </Button>

      {/**
       * Map here
       */}
    </Container >
  );
};

export default Dashboard;