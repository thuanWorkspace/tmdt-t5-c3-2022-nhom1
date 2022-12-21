import React from "react";
import Footer from "./footer/Footer";
import Header from "./Header";
import SideBar from "./SideBar";

export default function FileShare() {
  return (
    <div>
     
      <Header />
      <div className="flex mt-1">
        <SideBar />
        <div className="mt-24 w-full text-center">
          <h3 className="w-full text-xl font-medium">File Share</h3>

          {/* {files.map((file, index) => ( */}
          <div className="w-2/5 m-auto text-start">
            <h3 className="mt-2">Tên:</h3>
            <h3 className="mt-2">Ngày mua:</h3>
            <h3 className="mt-2">Dung lượng:</h3>
            <h3 className="mt-2">Ngày hết hạn:</h3>
          </div>
          {/* ))} */}
        </div>
      </div>
      <Footer />
    </div>
  );
}
