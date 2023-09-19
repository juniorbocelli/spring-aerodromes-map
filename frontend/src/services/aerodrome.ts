import axios from 'src/utils/axios';
import * as Routes from 'src/routes/apis';
import { IAerodrome } from 'src/@types/aerodrome';

// ----------------------------------------------------------------------

export function getAllAerodromesAPI() {
  return axios.get<IAerodrome[]>(Routes.API_AERODROME_URL.getAllAerodromes);
};