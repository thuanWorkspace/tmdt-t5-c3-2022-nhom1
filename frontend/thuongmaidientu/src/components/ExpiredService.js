import React from "react";
import { Link } from "react-router-dom";
import Footer from "./footer/Footer";
import Header from "./Header";
import SideBar from "./SideBar";

export default function ExpiredService() {
  return (
    <div>
      <Header />
      <div className="flex mt-1">
        <SideBar />
        <div className="mt-24 w-full text-center">
          <h3 className="w-full text-xl font-medium">Dịch Vụ Còn Hạn</h3>

          {/* {files.map((file, index) => ( */}
          <div className="w-2/5 m-auto text-start border p-2  bg-slate-200 ">
            <h3 className="mt-2">Tên:</h3>
            <h3 className="mt-2">Ngày mua:</h3>
            <h3 className="mt-2">Dung lượng còn lại:</h3>
            <h3 className="mt-2">Trạng thái:</h3>
            <Link className=" flex justify-end w-full">
              <h3 className="py-2 rounded-sm bg-red-500 text-white text-center w-32">
                Mua Ngay
              </h3>
            </Link>
          </div>
          {/* ))} */}
        </div>
      </div>

      <Footer />
    </div>
  );
}
