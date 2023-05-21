
import MedicalServicesIcon from '@mui/icons-material/MedicalServices';
import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import Button from '@mui/material/Button';
import Home from './User/Home';
import SignUp from './User/SignUp';

function ResponsiveAppBar() {
  return (
    <AppBar position="static">
      <Container maxWidth="xl">
        <Toolbar disableGutters>
          <MedicalServicesIcon sx={{ display: { xs: 'none', md: 'flex' }, mr: 1 }} />
          <Typography
            variant="h6"
            noWrap
            component="a"
            href="/"
            sx={{
              mr: 2,
              display: { xs: 'none', md: 'flex' },
              fontFamily: 'monospace',
              fontWeight: 700,
              letterSpacing: '.3rem',
              color: 'inherit',
              textDecoration: 'none',
            }}
          >
            MediCare
          </Typography>
          
          <Box sx={{ flexGrow: 1, display: { xs: 'none', md: 'flex' } }}>
            
              <Button
                key="Home"
                onClick={()=> { window.open("/home",'_self') ;}}
                sx={{ my: 2, color: 'white', display: 'block' }}
              >
                Home
              </Button>

              <Button
                key="Products"
                onClick={()=> { window.open("/signup",'_self') ;}}
                sx={{ my: 2, color: 'white', display: 'block' }}
              >
                Products
              </Button>

              <Button
                key="Login"
                onClick={()=> { window.open("/signin",'_self') ;}}
                sx={{ my: 2, color: 'white', display: 'block' }}
              >
                Login
              </Button>
            
          </Box>

          <Box sx={{ flexGrow: 0 }}>
            <Button
                key="Login"
                onClick={()=> { window.open("/signin",'_self') ;}}
                sx={{ my: 2, color: 'white', display: 'block' }}
              >
                Login
              </Button>

          </Box>
        </Toolbar>
      </Container>
    </AppBar>
  );
}
export default ResponsiveAppBar;
