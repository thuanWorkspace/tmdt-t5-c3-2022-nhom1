import React from "react";

export default function ForgotPassword() {
  return (
    <div>
      <div className=" w-1/3 mx-auto mt-40 bg-slate-100 rounded-md shadow-inner pb-20">
        <h3 className="text-center p-4 text-xl font-medium">Nhập Email</h3>
        <span className="flex flex-col w-10/12 m-auto mt-2 border-b-4 ">
          <label htmlFor="" className="text-xs text-gray-600 font-medium">
            Email
          </label>
          <input type="text" className=" outline-none" />
        </span>
      </div>
    </div>
  );
}
