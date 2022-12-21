import React, { useEffect, useState, useRef } from "react";
import Header from "./Header";
import InfoService from "./InfoService";
import axios from "axios";

export default function Payment() {
  const [products, setProducts] = useState([]);
  const [product, setProduct] = useState([]);
  
  
  useEffect(() =>{
    const getData = async()=>{
        const reqData = await fetch("http://localhost:8080/productapi/products");
        const  resData =  await reqData.json();
        setProducts(resData);
      }
      
        getData();
        if(products.length >0){
          setSelectedOption(products[0].product_name)
          setProduct(products[0])
          console.log('product update data')
        }
        
    }, []);

  const [selectedOption, setSelectedOption] = useState();
  
    function ChangeSelected(e){
      setSelectedOption(e.target.value)
      console.log('product change')
      products.forEach(el =>{
        if(el.product_name === selectedOption){
          console.log('change product',selectedOption)
          setProduct(el);
          console.log(product)
        }
      })
    }

  // useEffect(() =>{
  //   products.forEach(el =>{
  //     if(el.product_name === selectedOption){
  //       console.log('change product',selectedOption)
  //       setProduct(el);
  //       console.log(product)
  //     }
  //   })
  // },[selectedOption])

  return (
    <div className="">
      <Header />
      <span className="mt-4 block m-auto">
        <h2 className="text-center font-medium text-xl">THANH TOÁN</h2>
      </span>
      <div className=" mx-20 mt-4 w-full flex">
        <div className="w-1/2">
          <span className="flex items-center">
            <h3 className="mr-4 text-black font-medium">Gói dịch vụ</h3>
            <select
              id=""
              className="text-start rounded-md"
              style={{ border: "2px solid" }}
              value={selectedOption}
              onChange={ChangeSelected}>
                {products.map(o => (
                  <option key={o.product_name} value={o.product_name}>{o.product_name}</option>
                ))}
            
              
              
            </select>
          </span>
          <div className="mt-4 flex w-3/4 text-center hover: cursor-pointer">
            <span className="block outline outline-red-500 w-1/3 mr-4 p-3 rounded-md">
              <h3>Directlink 200 GB</h3>
              <h3>150.000đ</h3>
            </span>
            
          </div>
          <div className="mt-4">
            <h3 className="mr-4 text-black font-medium">
              Phương thức thanh toán
              <span>
                <div className="mt-4 flex w-3/4 text-center hover: cursor-pointer">
                  <span className=" flex items-center justify-center outline outline-red-500 w-1/3 mr-4 rounded-md">
                    <i className="fa fa-credit-card mr-3"></i>
                    <h3>Tài Khoản Paypal</h3>
                  </span>
                  
                </div>
              </span>
            </h3>
          </div>
          <div className="mt-8 text-center w-3/4">
            {/* <h3 className="font-medium">Lựa chọn thẻ thanh toán</h3> */}
            <div className="flex justify-evenly mt-4">
              <img
                src="https://icons.iconarchive.com/icons/designbolts/credit-card-payment/256/Paypal-icon.png"
                alt=""
                className="w-20"
              />
              
            </div>
          </div>
        </div>
        <InfoService />
      </div>
    </div>
  );
}
