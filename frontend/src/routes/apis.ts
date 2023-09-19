import { SERVER_HOST_API_ROOT } from 'src/config-global';

/**
 * AUTH
 */
const AUTH_ROOT = `${SERVER_HOST_API_ROOT}/auth`;
export const API_AUTH_URL = {
  login: `/${AUTH_ROOT}/login`,
  logout: `/${AUTH_ROOT}/logout`,
};


/**
 * USER
 */
const USER_ROOT = `${SERVER_HOST_API_ROOT}/user`;
export const API_USER_URL = {
  newUser: `/${USER_ROOT}`,
  getUser: `/${USER_ROOT}/:id`,
};


/**
 * AERODROME
 */
const AERODROME_ROOT = `${SERVER_HOST_API_ROOT}/aerodrome`;
export const API_AERODROME_URL = {
  newFromUpload: `/${AERODROME_ROOT}/upload`,
  getAllAerodromes: `/${AERODROME_ROOT}`,
};

/**
 * RUNWAY
 */
const RUNWAY_ROOT = `${SERVER_HOST_API_ROOT}/runway`;
export const API_RUNWAY_URL = {
  getAllRunways: `/${RUNWAY_ROOT}`,
};