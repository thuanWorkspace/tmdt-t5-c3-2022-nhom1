import { useState } from "react";
import { Link, NavLink } from "react-router-dom";

function SideBar() {
  return (
    <div className="w-64 text-center py-3 bg-slate-900">
      <i className="fa fa-bars text-white translate-x-[92px] text-xl"></i>
      <ul className="text-white flex flex-col py-16">
        <NavLink
          to="/file/manager"
          className={({ isActive }) =>
            isActive
              ? "bg-red-500 flex mt-1 text-base items-center text-center p-2 mb-2"
              : "bg-none flex mt-1  items-center text-center p-2 mb-2"
          }
        >
          <li>Quản lí tập tin</li>
        </NavLink>
        <NavLink
          to="/fileshare"
          className={({ isActive }) =>
            isActive
              ? "bg-red-500 flex mt-1 text-base items-center text-center p-2 mb-2"
              : "bg-none flex mt-1  items-center text-center p-2 mb-2"
          }
        >
          <li>Tập Tin Chia Sẻ Đến Tôi</li>
        </NavLink>
        <NavLink
          to="/expiredservice"
          className={({ isActive }) =>
            isActive
              ? "bg-red-500 flex mt-1 text-base items-center text-center p-2 mb-2"
              : "bg-none flex mt-1  items-center text-center p-2 mb-2"
          }
        >
          <li>Dịch Vụ Còn Hạng</li>
        </NavLink>
        <NavLink
          to="/historybuy"
          className={({ isActive }) =>
            isActive
              ? "bg-red-500 flex mt-1 text-base items-center text-center p-2 mb-2"
              : "bg-none flex mt-1  items-center text-center p-2 mb-2"
          }
        >
          <li>Lịch Sử Mua Hàng</li>
        </NavLink>
        <NavLink
          to="/service"
          className={({ isActive }) =>
            isActive
              ? "bg-red-500 flex mt-1 text-base items-center text-center p-2 mb-2"
              : "bg-none flex mt-1  items-center text-center p-2 mb-2"
          }
        >
          <li>Service</li>
        </NavLink>
      </ul>
    </div>
  );
}
export default SideBar;
