import React from "react";

export default function DetailService({ divRef, handleClickClose, product }) {
  return (
    <div
      ref={divRef}
      className="w-2/3 bg-gray-200 rounded-sm absolute top-8 left-[240px] hidden"
      style={{
        zIndex: 1,
      }}
    >
      <span className="w-3/4 block mx-10 text-left text-black hover:text-black">
        <h3 className="mt-6 text-black font-semibold text-xl">
          {product?.product_name}
        </h3>
        <p className="mt-3">{product?.description}</p>
        <span className="mt-6 bg-red-200 block w-full rounded-sm">
          <ul className="">
            <h3 className="text-red-500 text-lg font-semibold ml-4 ">
              Tại sao khách hàng nên chọn gói {product?.product_name} T_Cloud?
            </h3>
            <li className=" mt-2 ml-4">
              Dung lượng lưu trữ lớn:{" "}
              {(product?.storage / 1073741824).toFixed(0) + "GB"} đảm bảo.
            </li>
            <li className=" mt-2 ml-4">
              Quyền lợi dành riêng cho gói {product?.product_name}: Thời gian
              lưu trữ file không bị giới hạn xuyên suốt gói mua, không cần bận
              tâm bị xoá mất file trong quá trình sử dụng.
            </li>
            <li className=" mt-2 ml-4">
              Tốc độ DOWNLOAD/UPLOAD cao, không mất thời gian chờ
            </li>
            <li className=" mt-2 ml-4">
              Xem video trực tuyến không giới hạn số lần xem.
            </li>
            <li className=" mt-2 ml-4 pb-4">
              Ứng dụng T_Cloud Tool trên nhiều nền tảng thiết bị: Macbook, PC và
              Mobile với nhiều tính năng tiện ích. Tham khảo thêm tại đây.
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
  );
}
