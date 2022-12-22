import React, { useEffect, useState, useRef } from "react";
import Header from "./Header";
import Footer from "./footer/Footer";
import { Link } from "react-router-dom";
import DetailService from "./DetailService";
import axios from "axios";
import SideBar from "./SideBar";

export default function Service() {
  const [productDetail, setProductDetail] = useState();
  const divRef = useRef();
  const divvRef = useRef();
  const buttonRef = useRef();

  const handleClickClose = (e) => {
    divRef.current.style.display = "none";
    divvRef.current.style.display = "none";
    buttonRef.current.style.display = "block";
  };
  const handleClickOpen = (e) => {
    divRef.current.style.display = "block";
    divvRef.current.style.display = "block";
    buttonRef.current.style.display = "none";
  };
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

  return (
    <>
      <div className="w-full  mb-16 relative ">
        <Header />
        <div className="flex mt-1">
          <SideBar />
          <div className="w-3/4 m-auto flex justify-around">
            {products.map((product, index) => (
              <span
                key={index}
                className="block hover:bg-red-300 hover:text-white cursor-pointer mt-20 bg-gray-100 shadow-md shadow-gray-200 w-1/3 h-96 text-center rounded-sm"
              >
                <div className="w-3/4 text-center m-auto mt-4">
                  <h2 className="text-red-600 font-medium ">
                    {product.product_name}
                  </h2>
                  <h2 className="mt-3">CHỈ TỪ {product.price}$/THÁNG</h2>
                  <h3 className="mb-4">
                    Dành cho khách hàng có nhu cầu TẢI FILE với tốc độ cao
                  </h3>
                  <Link
                    to="/payment"
                    onClick={(e) => {
                      setProductDetail(product);
                    }}
                    className="outline outline-2  rounded-md px-14 py-2 text-red-600  hover:bg-red-600 hover:text-white"
                  >
                    MUA NGAY
                  </Link>
                  <ul className="mt-3">
                    <li className="mt-3">
                      Dung lượng lưu trữ:{" "}
                      {(product.storage / 1073741824).toFixed(0) + "GB"}
                    </li>

                    <li className="mt-3">Tốc độ download/upload cao</li>
                    <li className="mt-3 mb-6">
                      Dung lượng tải:{" "}
                      {(product.transfer / 1073741824).toFixed(0) + "GB"}/ngày
                    </li>
                  </ul>
                  <Link
                    ref={buttonRef}
                    className="hover:text-red-500  "
                    onClick={(e) => {
                      handleClickOpen(e);
                      setProductDetail(product);
                    }}
                  >
                    Xem chi tiết
                  </Link>
                  <DetailService
                    handleClickClose={handleClickClose}
                    divRef={divRef}
                    product={productDetail}
                  />
                </div>
                <div
                  ref={divvRef}
                  className="fixed top-0 left-0 right-0 bottom-0 hidden"
                  style={{
                    backgroundColor: "rgba(0,0,0,0.4)",
                  }}
                ></div>
              </span>
            ))}
          </div>
        </div>

        <Footer />
      </div>
    </>
  );
}
