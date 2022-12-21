import React from "react";
import { Link } from "react-router-dom";
import Footer from "./footer/Footer";
import Header from "./Header";
import SideBar from "./SideBar";

export default function ChangePassword() {
  return (
    <div>
      <Header />
      <div className="flex mt-1">
        <SideBar />
        <div className="w-96 m-auto bg-slate-200 border pt-10 pb-20">
          <h3 className="font-medium text-2xl text-center mb-10">
            Đổi mật khẩu
          </h3>
          <span className="flex flex-col w-10/12 m-auto mt-2 border-b-4 ">
            <label htmlFor="" className="text-xs text-gray-600">
              Password old
            </label>
            <input type="password" className=" outline-none" />
          </span>
          <span className="flex flex-col w-10/12 m-auto mt-2 border-b-4 ">
            <label htmlFor="" className="text-xs text-gray-600">
              Password new
            </label>
            <input type="password" className=" outline-none" />
          </span>
          <span className="flex flex-col w-10/12 m-auto mt-2 border-b-4 ">
            <label htmlFor="" className="text-xs text-gray-600">
              Password Confirm
            </label>
            <input type="password" className=" outline-none" />
          </span>
          <Link className="text-center">
            <h3 className="mt-4 mx-8 round-md  py-2 bg-red-500 text-white">
              Update
            </h3>
          </Link>
        </div>
      </div>
      <Footer />
    </div>
  );
}
