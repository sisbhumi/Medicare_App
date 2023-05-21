import React from 'react'
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import { useEffect } from 'react';
import { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import Search from './Search';
export default function Home() {

  let navigate = useNavigate()
  
  const [productList, setProductList] = useState([]);

  
  useEffect(() => {
    init();
  });

  

  const init= async ()=>{
    const result = await axios.get("http://localhost:8080/products");
    setProductList(result.data);
  }

  const handleChange =async (e,id)=>{
    await axios.post(`http://localhost/cart/${id}`);
    navigate('/user/Buy')
  }

  const handleChangecart = async(e,id)=> {
    await axios.post(`http://localhost/cart/${id}`);
    alert("Added to Cart")
  }

  return (
    <>
    <div className='container '>
    <div></div>
      <div className='row md-3 align-content-center  '>
        <br></br>
        <div class="col" ></div>
        <div class='col justiy-text-center'>
        <Search/>

        </div>
      <div class="col"></div>
      </div>
        <div class="container">
          <br></br>
        <div className='d-flex col md-3'>
            {productList.map((p) => (
                
              <div class="fex row w-10">

              <Card sx={{ maxWidth: 345 }}>

                <CardContent>
                <Typography  variant="h5" >
                  {p.name}
                </Typography>
                <Typography variant="body2" color="text.secondary">
                  Price:{p.price}
                </Typography>
                <Typography variant="body2" color="text.secondary">
                  {p.category}
                </Typography>
                <Typography variant="body2" color="text.secondary">
                  {p.description}
                </Typography>
                </CardContent> 

                <Button variant="contained" onClick={(e)=> handleChange(e,p.prod_id)}>Buy</Button>
                <Button variant="contained" onClick={(e)=> handleChangecart(e,p.prod_id)}>Add to Cart</Button>
            </Card>
           
            </div>
            ))}
           </div> 
           </div>
    </div>
</div>
</>
  );
}
    

