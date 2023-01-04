import { Link } from "react-router-dom";
import React, { useEffect, useState } from 'react'
import Header from "./Header";
import DonutChart from "./chartComponent/DonutChart";
import Footer from "./footer/Footer";
import { Grid, Segment } from "semantic-ui-react";

export default function Admin() {

    const [Product,setProduct] = useState([]);
    const [countProduct,setcountProduct] = useState([]);
    const [income,setIncome] = useState([]);

    useEffect(() =>{
        const getData = async()=>{
            const productName=[];
            const countProduct = [];
            const getIncome = [];

           const reqData = await fetch("http://localhost:8080/adminapi/statistical/products");
           const  resData =  await reqData.json();

            for (let i = 0; i < resData.length; i++) {
                productName.push(resData[i].product_name)
                countProduct.push(resData[i].saled_count)
                getIncome.push(resData[i].income)
            }
            setProduct(productName);
            setcountProduct(countProduct);
            setIncome(getIncome)
           console.log(productName);
        } 
        getData();
    },[]);

  return (
    <div className="">
        <Header/>

        {/* <div className="row">
            <div className="column">
                <DonutChart Product={Product} title={"Tổng sản phẩm đã bán"} value={countProduct}/>
            </div>
            <div className="column">
                <DonutChart Product={Product} title={"Tổng doanh thu dựa trên sản phẩm"} value={income}/>
            </div>
        </div> */}

        <div className="row">
            <div className="w-1/2">
                <DonutChart Product={Product} title={"Tổng sản phẩm đã bán"} value={countProduct}/>
            </div>
            <div className="w-1/2">
                <DonutChart Product={Product} title={"Tổng doanh thu dựa trên sản phẩm"} value={income}/>
            </div>
        </div>        
        
        <Footer/>
    </div>
    
  )
}
