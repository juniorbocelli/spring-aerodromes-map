import React from 'react';
// sections
import {
  Dashboard,
  useDashboardStates,
  DashboardProvider,
} from 'src/sections/dashboard';

//
import Strings from 'src/shared/strings';

// ----------------------------------------------------------------------

export default function DashboardPage() {
  const states = useDashboardStates();

  // Effects
  React.useEffect(() => {
    document.title = `${Strings.Page.PAGE_TITLE_COMPANY_NAME}${Strings.Page.PAGE_TITLE_SEPARATOR}Dashboard`;
  }, []);

  return (
    <DashboardProvider states={states}>
      <Dashboard />
    </DashboardProvider>
  );
};
