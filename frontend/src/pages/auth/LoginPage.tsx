import React from 'react';
import { useNavigate } from 'react-router-dom';
// sections
import Login from 'src/sections/auth/login/Login';
// contexts
import { useAuthContext } from 'src/auth';
//
import Strings from 'src/shared/strings';
import { PATH_AFTER_LOGIN } from 'src/config-global';

// ----------------------------------------------------------------------

export default function LoginPage() {
  const navigate = useNavigate();
  const { loggedUser } = useAuthContext();

  // Effects
  React.useEffect(() => {
    document.title = `${Strings.Page.PAGE_TITLE_COMPANY_NAME}${Strings.Page.PAGE_TITLE_SEPARATOR}Login`;
  }, []);

  React.useEffect(() => {
    if (loggedUser !== null)
      navigate(PATH_AFTER_LOGIN);
  }, [loggedUser, navigate]);

  return (
    <Login />
  );
}
