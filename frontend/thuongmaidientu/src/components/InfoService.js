import axios from "axios";
import React, { useEffect, useState ,useRef} from "react";
import {Routes, Route, useNavigate} from 'react-router-dom';
import Paypal from "./Paypal";

export default function InfoService(product) {
  const [score,setScore] = useState(0);
  const navigate = useNavigate();
  const [checkout, setCheckOut] = useState(false);

  const submitHandler = e => {
    e.preventDefault();
    checkscore(e);

    setCheckOut(true);
    navigate('/pay/'+score);

    // navigate('/detail-post', { state: { UserId } });
    
    // const requestOptions = {
    //   method: 'POST',
    //   headers: { 'Content-Type': 'application/json' },
    //   body: JSON.stringify({ price: score })
    // };
    // fetch('http://localhost:8080/pay', requestOptions)
    //     .then(response => response.json())
    //     .then(data => this.setState({ postId: data.id }));

    // axios.post(`http://localhost:8080/pay`, { score })
    // .then(res => {
    //   console.log(res);
    //   console.log(res.data);
    // })
  }

  const applyScoreHandle = e => {
    e.preventDefault();
    setScore(e.target.value);
  }
  const checkscore = e =>{
    e.preventDefault();
    var apiString = "http://localhost:8080/userproductapi/checkscore/6371bd880ac8ae8ad1af59ce/6371bfe40ac8ae8ad1af59d4/";
    var scoreapi = score;
    apiString = apiString.concat(scoreapi)
    console.log(apiString)

    const getData = async()=>{
      // const reqData = await fetch(apiString);
      var  resData = "" ;//  =  await reqData.type;

      await fetch(apiString)
        .then(function(response) {
          return response.text();
        }).then(function(text) { 
          // <!DOCTYPE ....
          resData = text;
      });

        console.log(resData)
      if(resData !== "OK"){
        alert(resData)
      }
    }

    getData();
    
    console.log('checkscore',score)
  }

  // useEffect(() =>{
  //     console.log(score)
  // },score)
  return (
    <div className="w-1/2">
      {/* {checkout ? (
        <Paypal />
      ) : (
        <div/>
      )} */}

      <h3 className="font-medium mt-2">Thông tin dịch vụ</h3>
      <span className="block w-3/5 font-medium mt-4 shadow shadow-gray-400 bg-white px-4 py-4">
        <span className="flex justify-between w-full  mt-2">
          <h3>Tên dịch vụ</h3>
          <h3>{product.product_name}</h3>
        </span>
        <span className="flex justify-between w-full  mt-2">
          <h3>Gói sản phẩm</h3>
          <h3>Storage 1 TB/3 tháng</h3>
        </span>
        <span className="flex justify-between w-full  mt-2">
          <h3>Mã tài khoản</h3>
          <h3>Storage 1 TB/3 tháng</h3>
        </span>
        <span className="flex justify-between w-full  mt-2">
          <h3>Thời hạn sử dụng</h3>
          <h3>Storage 1 TB/3 tháng</h3>
        </span>
        <span className="flex justify-between w-full  mt-2">
          <h3>Dung lượng tải</h3>
          <h3 className="text-end">Storage 1 TB/3 tháng</h3>
        </span>
        <span className="flex justify-between w-full  mt-2">
          <div className="flex font-light">
            <input
              type="number"
              placeholder="Nhập điểm giảm giá"
              className=" outline outline-1 rounded-sm  pr-20 pl-2"
              onChange={applyScoreHandle}
            />
            <div className="translate-x-[-20px] translate-y-[2px] cursor-pointer font-medium">
              X
            </div>
          </div>
          <button className="px-4 py-1 bg-red-600 outline outline-red-600 text-white rounded-sm" onClick={checkscore}>
            ÁP DỤNG
          </button>
        </span>
        <hr className="mt-3" />
        <span className="flex justify-between w-full  mt-2">
          <h3>Giá</h3>
          <h3 className="text-end">Storage 1 TB/3 tháng</h3>
        </span>
        <span className="flex justify-between w-full  mt-2">
          <h3>Khuyến mãi</h3>
          <h3 className="text-end">Storage 1 TB/3 tháng</h3>
        </span>
        <span className="flex justify-between w-full  mt-2">
          <h3>Số tiền phải thanh toán</h3>
          <h3 className="text-end">Storage 1 TB/3 tháng</h3>
        </span>
        <button onClick={submitHandler} className="mt-3 p-2 bg-red-600 text-white rounded-sm  w-full ">
          THANH TOÁN
        </button>
      </span>
    </div>
  );
}
