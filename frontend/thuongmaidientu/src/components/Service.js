import React, { useEffect, useState, useRef } from "react";
import Header from "./Header";
import Footer from "./footer/Footer";
import { Link } from "react-router-dom";
import axios from "axios";

export default function Service() {
  const [products, setProducts] = useState([]);
  useEffect(() => {
    axios
      .get("http://localhost:8080/productapi/products")
      .then((res) => {
        setProducts(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);
  const divRef = useRef();
  const divvRef = useRef();
  const buttonRef = useRef();
  const handleClickOpen = () => {
    divRef.current.style.display = "block";
    divvRef.current.style.display = "block";
    buttonRef.current.style.display = "none";
  };
  const handleClickClose = () => {
    divRef.current.style.display = "none";
    divvRef.current.style.display = "none";
    buttonRef.current.style.display = "block";
  };

  return (
    <>
      <Header />
      <div className="w-full mt-16 relative">
        <h2 className="text-center font-medium text-xl">GÓI DỊCH VỤ</h2>
        <div className="w-3/4 m-auto flex justify-around">
          {products.map((product, index) => (
            <span
              key={index}
              className="block  mt-20 bg-gray-100 shadow-md shadow-gray-200 w-1/3 text-center rounded-sm"
            >
              <h2 className="text-red-600 font-medium ">
                {product.product_name}
              </h2>
              <h2 className="mt-3">CHỈ TỪ {product.price}/THÁNG</h2>
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
              <Link
                ref={buttonRef}
                className="hover:text-red-500 "
                onClick={handleClickOpen}
              >
                Xem chi tiết
              </Link>
            </span>
          ))}
          <div
            ref={divvRef}
            className="fixed top-0 left-0 right-0 bottom-0 hidden"
            style={{
              backgroundColor: "rgba(0,0,0,0.4)",
            }}
          ></div>
          <div
            ref={divRef}
            className="w-3/4 bg-gray-200 rounded-sm hidden"
            style={{
              zIndex: 1,
            }}
          >
            <span className="w-8/12 block mx-10">
              <h3 className="mt-8 text-black font-semibold text-xl">
                Gói STORAGE
              </h3>
              <p className="mt-6">
                Gói STORAGE là gói dịch vụ cho phép LƯU TRỮ VỚI DUNG LƯỢNG RẤT
                LỚN (1TB - 100TB) và download/upload TỐC ĐỘ CAO, phù hơp với mọi
                khách hàng là các công ty/tổ chức/cá nhân/dự án starup đang hoạt
                động trong nhiều lĩnh vực (game, thiết kế, phim ảnh...).
              </p>
              <span className="mt-6 bg-red-200 block w-full rounded-sm">
                <ul className="">
                  <h3 className="text-red-500 text-lg font-semibold ml-4 ">
                    Tại sao khách hàng nên chọn gói Storage Fshare?
                  </h3>
                  <li className=" mt-2 ml-4">
                    Dung lượng lưu trữ lớn: 1TB đến 100TB đảm bảo.
                  </li>
                  <li className=" mt-2 ml-4">
                    Quyền lợi dành riêng cho gói Storage: Thời gian lưu trữ file
                    không bị giới hạn xuyên suốt gói mua, không cần bận tâm bị
                    xoá mất file trong quá trình sử dụng.
                  </li>
                  <li className=" mt-2 ml-4">
                    Tốc độ DOWNLOAD/UPLOAD cao, không mất thời gian chờ
                  </li>
                  <li className=" mt-2 ml-4">
                    Xem video trực tuyến không giới hạn số lần xem.
                  </li>
                  <li className=" mt-2 ml-4 pb-4">
                    Ứng dụng Fshare Tool trên nhiều nền tảng thiết bị: Macbook,
                    PC và Mobile với nhiều tính năng tiện ích. Tham khảo thêm
                    tại đây.
                  </li>
                </ul>
              </span>
            </span>
            <div className="bg-gray-500 text-white font-medium h-12 flex  justify-end items-center mt-4">
              <h3 onClick={handleClickClose} className="mr-4">
                ĐÓNG
              </h3>
            </div>
          </div>
        </div>
      </div>
      <Footer />
    </>
  );
}
