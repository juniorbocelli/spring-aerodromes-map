import axios from 'axios';
// config
import { SERVER_HOST_API, SERVER_HOST_PORT } from 'src/config-global';
//
import LocalStorage from 'src/utils/localStorage';

// ----------------------------------------------------------------------

const apiAxios = axios
  .create({
    baseURL: `${SERVER_HOST_API}:${SERVER_HOST_PORT}`,
    headers: {
      'Content-Type': 'application/json',
      'Authorization': LocalStorage.getToken(),
    },
    timeout: 30000,
  });

apiAxios.interceptors.request.use(
  (config) => {
    if (config.headers)
      config.headers.Authorization = LocalStorage.getToken();

    return config;
  });

// Response error handling
apiAxios.interceptors.response.use(
  (response) => {
    if (process.env.NODE_ENV === 'development')
      console.log(`Response:`, response);

    if (typeof response.data === "undefined")
      throw new Error("Erro em chamada API (TESTE)");

    if (typeof response.data.error !== "undefined")
      throw new Error(response.data.error as string);

    return response;
  },
);

export default apiAxios;