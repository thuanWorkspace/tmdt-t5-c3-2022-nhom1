import React from "react";

export default function InfoService(product) {
  return (
    <div className="w-1/2">
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
  );
}
