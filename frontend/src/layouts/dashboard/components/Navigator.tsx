import * as React from 'react';
import { useNavigate } from 'react-router-dom';
// @mui
import {
  Box,
  Divider,
  Drawer,
  DrawerProps,
  List,
  ListItem,
  ListItemButton,
  ListItemIcon,
  ListItemText,
} from '@mui/material';
// icons
import HomeIcon from '@mui/icons-material/Home';

//
import * as Paths from 'src/routes/paths';

// ----------------------------------------------------------------------

type Category = {
  id: string;
  // user permissions
  exclude: number[];
  // sub-menus
  children: {
    id: string;
    icon: React.ReactNode;
    // to hightlight menu
    menuName: string;
    url: string;
  }[];
};

const categories: Category[] = [
  // Example
  // {
  //   id: 'Usuários',
  //   exclude: [2, 3],
  //   children: [
  //     {
  //       id: 'Lista de Usuários',
  //       icon: <PeopleIcon />,
  //       menuName: 'userList',
  //       url: Paths.SCREEN_USER_SELECT_ALL,
  //     },
  //     {
  //       id: 'Gerenciar Usuários',
  //       icon: <EditIcon />,
  //       menuName: 'userManager',
  //       url: Paths.SCREEN_USER_CREATE,
  //     },
  //   ],
  // },
  // {
];

const item = {
  py: '2px',
  px: 3,
  color: 'rgba(255, 255, 255, 0.7)',
  '&:hover, &:focus': {
    bgcolor: 'rgba(255, 255, 255, 0.08)',
  },
};

const itemCategory = {
  boxShadow: '0 -1px 0 rgb(255,255,255,0.1) inset',
  py: 1.5,
  px: 3,
};

interface INavigatorProps extends DrawerProps {
  activeMenu: string;
};

// ----------------------------------------------------------------------

export default function Navigator(props: INavigatorProps) {
  const { activeMenu, ...other } = props;
  const navigate = useNavigate();

  const Submenus = React.useMemo(() => (
    <>
      {
        categories.map(({ id, exclude, children }) => (
          <Box key={id} sx={{ bgcolor: '#101F33' }}>
            <ListItem sx={{ py: 2, px: 3 }}>
              <ListItemText sx={{ color: '#fff' }}>{id}</ListItemText>
            </ListItem>
            {children.map(({ id: childId, icon, menuName, url }) => (
              <ListItem disablePadding key={`${id}-${childId}`}>
                <ListItemButton
                  selected={menuName === activeMenu}
                  onClick={() => navigate(url || '#')}
                  disabled={url === '#' && menuName !== activeMenu}

                  sx={item}
                >
                  <ListItemIcon>{icon}</ListItemIcon>
                  <ListItemText>{childId}</ListItemText>
                </ListItemButton>
              </ListItem>
            ))}
            <Divider sx={{ mt: 2 }} />
          </Box>

        ))
      }
    </>
  ), [activeMenu, navigate]);

  return (
    <Drawer variant="permanent" {...other}>
      <List disablePadding>
        <ListItem sx={{ ...item, ...itemCategory, fontSize: 20, color: '#fff' }}>
          Aerodromes Map
        </ListItem>
        <ListItem sx={{ ...item, ...itemCategory, cursor: 'pointer' }} selected={activeMenu === 'dashboard'} onClick={() => navigate(Paths.PATH_DASHBOARD.home)}>
          <ListItemIcon>
            <HomeIcon />
          </ListItemIcon>
          <ListItemText>Dashboard</ListItemText>
        </ListItem>
        {Submenus}
      </List>
    </Drawer>
  );
};