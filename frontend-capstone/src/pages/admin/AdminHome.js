import React from 'react'
import { Navigate } from 'react-router-dom';
import { useState } from 'react';
import axios from 'axios';
import { useEffect } from 'react';
import { Card , CardContent} from '@mui/material';
import { Link } from 'react-router-dom';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import Edit from './Edit';
export default function AdminHome() {
    const [productList, setProductList] = useState({
        name:'',
    });

    useEffect(() => {
      handleChange();
    }, []);
  
    const handleChange= async ()=>{
      Navigate(<Edit/>)
    }
  
    const handleChangecart = async(e,id)=>{
        await axios.delete(`http://localhost:8080/cart/remove/${id}`)
        alert("Producct Removed");
        Navigate(<AdminHome/>)
    }
    return (
      <>
      <div className='container '>
        <div className='row md-3'>
      {productList.map((p) => (
      <Card sx={{ maxWidth: 345 }}>
  
          <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            {p.name}
          </Typography>
          <Typography variant="body2" color="text.secondary">
            {p.price}
          </Typography>
          <Typography variant="body2" color="text.secondary">
            {p.category}
          </Typography>
          <Typography variant="body2" color="text.secondary">
            {p.description}
          </Typography>
          </CardContent> 
          <div className='row'>
            <div className='col'>
                
        <Link to={`/`} variant="contained" onClick={(e)=> handleChange(e,p.prod_id)}>Update</Link>
            </div>
            <div className='col'>
        <Button variant="contained" onClick={(e)=> handleChangecart(e,p.prod_id)}>delete</Button>
            </div>
          </div>
      </Card>

      ))}
      <div> <Link to={"/amin/add"} variant="contained" onClick={(e)=> handleChange(e)}>Add</Link></div>
      </div>
  </div>
  </>
    );
}
