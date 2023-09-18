// mui
import {
  Typography,
} from '@mui/material';
import {
  useTheme,
} from '@mui/material/styles';

// layouts
import { AuthLayout } from 'src/layouts/auth';
// components
import LogoFull from 'src/components/logo-full';
//
import AuthLoginForm from 'src/sections/auth/login/AuthLoginForm';

// ----------------------------------------------------------------------

export default function Login() {
  const theme = useTheme();

  return (
    <AuthLayout>
      <Typography
        variant="h3"
        component="div"
        align="center"

        sx={{ color: theme.palette.grey[800], pt: 1, pb: 3 }}
      >
        Login
      </Typography>

      <LogoFull sx={{ px: theme.spacing(3), mb: theme.spacing(5) }} />

      <AuthLoginForm />

    </AuthLayout >
  );
};
