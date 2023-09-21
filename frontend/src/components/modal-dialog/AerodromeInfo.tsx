import React from 'react';
// @mui
import { Box, Grid, Typography } from '@mui/material';

// components
import AlertDialog from 'src/components/modal-dialog/AlertDialog';
import RunwaysTable from 'src/components/aerodomes/RunwaysTable';
// @types
import { IAerodrome } from 'src/@types/aerodrome';

// ----------------------------------------------------------------------

interface IAerodromeHeaderProps {
  name: string;
  city: string;
  description: string;
  createdAt: string;
  dms: string;
};

const AerodromeHeader: React.FC<IAerodromeHeaderProps> = (props) => {
  const {
    name,
    city,
    description,
    dms,
    createdAt,
  } = props;

  return (
    <Box>
      <Grid container>
        <Grid item md={6} xs={12} sx={{ mb: 1.5 }}>
          <Typography variant="h6" component="span" sx={{ fontWeight: 'bold', fontSize: '1.1rem', mr: 1 }}>
            Nome:
          </Typography>
          <Typography variant="h6" component="span" sx={{ fontWeight: 300, fontSize: '1.1rem' }}>
            {name}
          </Typography>
        </Grid>

        <Grid item md={6} xs={12} sx={{ mb: 1.5 }}>
          <Typography variant="h6" component="span" sx={{ fontWeight: 'bold', fontSize: '1.1rem', mr: 1 }}>
            Cidade:
          </Typography>
          <Typography variant="h6" component="span" sx={{ fontWeight: 300, fontSize: '1.1rem' }}>
            {city}
          </Typography>
        </Grid>

        <Grid item xs={12} sx={{ mb: 1.5 }}>
          <Typography variant="h6" component="span" sx={{ fontWeight: 'bold', fontSize: '1.1rem', mr: 1 }}>
            Descrição:
          </Typography>
          <Typography variant="h6" component="span" sx={{ fontWeight: 300, fontSize: '0.9rem' }}>
            {description}
          </Typography>
        </Grid>

        <Grid item md={6} xs={12} sx={{ mb: 1.5 }}>
          <Typography variant="h6" component="span" sx={{ fontWeight: 'bold', fontSize: '1.1rem', mr: 1 }}>
            DMS:
          </Typography>
          <Typography variant="h6" component="span" sx={{ fontWeight: 300, fontSize: '1.1rem' }}>
            {dms}
          </Typography>
        </Grid>

        <Grid item md={6} xs={12} sx={{ mb: 2 }}>
          <Typography variant="h6" component="span" sx={{ fontWeight: 'bold', fontSize: '1.1rem', mr: 1 }}>
            Criado em:
          </Typography>
          <Typography variant="h6" component="span" sx={{ fontWeight: 300, fontSize: '1.1rem' }}>
            {createdAt}
          </Typography>
        </Grid>
      </Grid>
    </Box>
  );
};

// ----------------------------------------------------------------------

interface IAerodromeInfoProps {
  aerodrome: IAerodrome;
  isOpen: boolean;
  onClose: () => void;
};

const AerodromeInfo: React.FC<IAerodromeInfoProps> = ({ aerodrome, isOpen, onClose }) => {
  const handleClose = () => {
    onClose();
  };

  return (
    <AlertDialog
      title="Sobre o Aerodrome"
      content={
        <>
          <AerodromeHeader
            name={aerodrome.name}
            city={aerodrome.city}
            description={aerodrome.description}
            dms={aerodrome.dms}
            createdAt={aerodrome.createdAt}
          />

          <Typography variant="h6" component="span" sx={{ fontWeight: 'bold', fontSize: '1.2rem' }}>
            Pistas ({aerodrome.runways.length})
          </Typography>

          <RunwaysTable runways={aerodrome.runways} sx={{ mt: 1.3 }} />
        </>
      }
      open={isOpen}
      onClose={handleClose}
    />
  );
};

export default AerodromeInfo;