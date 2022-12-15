import React, { useEffect } from "react";
import Header from "./Header";
import Footer from "./footer/Footer";
import { Link } from "react-router-dom";
import axios from "axios";

export default function Service() {
  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then((res) => res.json())
      .then((posts) => {
        console.log(posts);
      });
  }, []);

  return (
    <>
      <Header />
      <div className="w-full mt-9">
        <h2 className="text-center font-medium text-xl">GÓI DỊCH VỤ</h2>
        <div className="w-3/4 m-auto">
          <span className="block bg-gray-100 shadow-md shadow-gray-200 w-1/3 text-center rounded-sm">
            <h2 className="text-red-600 font-medium ">GÓI STORAGE</h2>
            <h2 className="mt-3">CHỈ TỪ 150.000Đ/THÁNG</h2>
            <h3>Dành cho khách hàng có nhu cầu TẢI FILE với tốc độ cao</h3>
            <button className="bg-white  outline outline-2 mt-3 rounded-md w-52 text-red-600 ">
              MUA NGAY
            </button>
            <ul className="mt-3">
              <li className="mt-3">Dung lượng lưu trữ: 100TB</li>
              <li className="mt-3">Không giới hạn thời gian sử dụng</li>
              <li className="mt-3">Tốc độ download/upload cao</li>
              <li className="mt-3">Dung lượng tải: 100-150GB/ngày</li>
            </ul>
            <Link>Xem chi tiết</Link>
          </span>
        </div>
      </div>
      <Footer />
    </>
  );
}
