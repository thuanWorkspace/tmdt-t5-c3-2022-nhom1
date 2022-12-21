import React, { useContext, useEffect } from "react";
import { useState } from "react";
import { useLocation, useParams } from "react-router-dom";
import { AppContext } from "./Context/AppContext";
import Footer from "./footer/Footer";
import Header from "./Header";
import SideBar from "./SideBar";

export default function HistoryBuy() {
  const { files } = useContext(AppContext);
  const [data, setData] = useState();
  const { id } = useParams();

  useEffect(() => {
    setData(files?.filter((item) => item.id === id)[0]);
  }, [id, files]);
  console.log("files", files);
  return (
    <div>
      <Header />
      <div className="flex mt-1">
        <SideBar />
        <div className="mt-24 w-full text-center">
          <h3 className="w-full text-xl font-medium">Lịch sử mua hàng</h3>

          {/* {files.map((file, index) => ( */}
          <div className="w-2/5 m-auto text-start">
            <h3 className="mt-2">Tên: {files[0].file_name}</h3>
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
