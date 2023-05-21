import React from 'react'
import { useNavigate, useParams } from 'react-router-dom';
import { useState } from 'react';
import { useEffect } from 'react';
import axios from 'axios';
import { Container } from '@mui/material';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import Link from '@mui/material/Link';
import { NavLink } from 'react-router-dom';

export default function Edit() {

    let navigate = useNavigate()
    const {id} = useParams()
  
  const [productList, setProductList] = useState({
    name:"",
    description:'',
    category:'',
    price:'',
    quantity:'',
    isavailable:'',
  });

  
  useEffect(() => {
    handleChange();
  });

  const handleChange =()=>{

  }

  const handleChangeUpdate = async ()=>{
    const result = await axios.put(`http://localhost:8080/product/edit/${id}`);
    setProductList(result.data);
  }
  return (
    <Container>
        

    <Container component="main" maxWidth="xs">
            <CssBaseline />
            <Box
              sx={{
                marginTop: 8,
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'center',
              }}
            >
              <Box component="form" onSubmit={handleChange} noValidate sx={{ mt: 1 }}>
                <TextField
                  margin="normal"
                  required
                  fullWidth
                  id="user"
                  label="Name"
                  name="user"
                  autoComplete="user"
                  autoFocus
                />

<TextField
                  margin="normal"
                  required
                  fullWidth
                  id="user"
                  label="Category"
                  name="user"
                  autoComplete="user"
                  autoFocus
                />
                <TextField
                  margin="normal"
                  required
                  fullWidth
                  id="user"
                  label="Descritpion"
                  name="user"
                  autoComplete="user"
                  autoFocus
                />
                <TextField
                  margin="normal"
                  required
                  fullWidth
                  id="user"
                  label="Price"
                  name="user"
                  autoComplete="user"
                  autoFocus
                />
                <TextField
                  margin="normal"
                  required
                  fullWidth
                  id="user"
                  label="Available"
                  name="user"
                  autoComplete="user"
                  autoFocus
                />
                <TextField
                  margin="normal"
                  required
                  fullWidth
                  id="user"
                  label="Quantity"
                  name="user"
                  autoComplete="user"
                  autoFocus
                />
                
                <FormControlLabel
                  control={<Checkbox value="remember" color="primary" />}
                  label="Remember me"
                />
                <Button
                  type="submit"
                  fullWidth
                  variant="contained"
                  sx={{ mt: 3, mb: 2 }}
                >
                  Update
                </Button>
 </Box>
            </Box>
          </Container>
    </Container>
  )
}
