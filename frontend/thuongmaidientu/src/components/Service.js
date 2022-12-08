import React from "react";
import Header from "./Header";

export default function Service() {
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
            >
              <option value="volvo">Gói Directlink</option>
              <option value="saab">Gói Vip</option>
              <option value="opel">Gói Storage</option>
              <option value="audi">Mua thêm dung lượng tải</option>
            </select>
          </span>
          <div className="mt-4 flex w-3/4 text-center hover: cursor-pointer">
            <span className="block outline outline-red-500 w-1/3 mr-4 p-3 rounded-md">
              <h3>Directlink 200 GB</h3>
              <h3>150.000đ</h3>
            </span>
            <span className="block outline outline-gray-100 w-1/3 mr-4 p-3 rounded-md text-gray-400 ">
              <h3>Directlink 200 GB</h3>
              <h3>150.000đ</h3>
            </span>
            <span className="block outline w-1/3 outline-gray-100 p-3 rounded-md  text-gray-400">
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
                    <h3>Thẻ nội địa</h3>
                  </span>
                  <span className="flex items-cente outline outline-gray-100 w-1/3 mr-4  rounded-md text-gray-400 ">
                    <h3>Directlink 200 GB</h3>
                    <h3>150.000đ</h3>
                  </span>
                  <span className="flex items-center outline w-1/3 outline-gray-100 rounded-md  text-gray-400">
                    <h3>Directlink 200 GB</h3>
                    <h3>150.000đ</h3>
                  </span>
                </div>
              </span>
            </h3>
          </div>
          <div className="mt-8 text-center w-3/4">
            <h3 className="font-medium">Lựa chọn thẻ thanh toán</h3>
            <div className="flex justify-evenly mt-4">
              <img
                src="https://icons.iconarchive.com/icons/graphicloads/flat-finance/256/atm-icon.png"
                alt=""
                className="w-20"
              />
              <img
                src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Mastercard-logo.svg/2560px-Mastercard-logo.svg.png"
                alt=""
                className="w-20"
              />
              <img
                src="https://cdn-icons-png.flaticon.com/512/217/217425.png"
                alt=""
                className="w-20"
              />
            </div>
          </div>
        </div>
        <div className="w-1/2">
          <h3 className="font-medium mt-2">Thông tin dịch vụ</h3>
          <span className="block w-3/5 font-medium mt-4 shadow shadow-gray-400 bg-white px-4 py-4">
            <span className="flex justify-between w-full  mt-2">
              <h3>Tên dịch vụ</h3>
              <h3>Gói Storage</h3>
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
                  type="text"
                  placeholder="Nhập mã khuyến mãi"
                  className=" outline outline-1 rounded-sm  pr-20 pl-2"
                />
                <div className="translate-x-[-20px] translate-y-[2px] cursor-pointer font-medium">
                  X
                </div>
              </div>
              <button className="px-4 py-1 bg-red-600 outline outline-red-600 text-white rounded-sm">
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
            <button className="mt-3 p-2 bg-red-600 text-white rounded-sm  w-full ">
              THANH TOÁN
            </button>
          </span>
        </div>
      </div>
    </div>
  );
}
