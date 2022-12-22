import { useContext } from "react";
import { Link } from "react-router-dom";
import { AppContext } from "./Context/AppContext";

function Header() {
  const { users } = useContext(AppContext);
  return (
    <div className="col-span-2 flex justify-between text-center  bg-slate-100 text-xl items-center p-1 shadow-xl">
      <Link
        to="/home"
        style={{
          display: "flex",
          alignItems: "center",
          textAlign: "center",
        }}
      >
        <img
          className="logo-fshare w-12  bg-slate-100"
          src="https://www.onlinelogomaker.com/blog/wp-content/uploads/2017/08/Fotolia_128673803_Subscription_Monthly_M.jpg"
          alt="Cloud"
        />
        <h2 className="text-blue-600 font-medium">T_Cloud</h2>
      </Link>

      <span className="flex space-x-4">
        <input
          type="text"
          placeholder="Tìm kiếm"
          className="outline-none border-solid"
          style={{ width: "800px" }}
        />
        <i className="fa fa-search translate-x-[-3rem] translate-y-[0.3rem] items-center "></i>
      </span>
      <div className="dropdown">
        <button
          className="btn dropdown-toggle border-none bg-blue-600 hover:bg-blue-600 text-cyan-50 hover:text-cyan-50"
          type="button"
          data-bs-toggle="dropdown"
          aria-expanded="false"
        >
          {users[0].username}
        </button>
        <ul className="dropdown-menu dropdown-menu-dark">
          <li>
            <Link className="dropdown-item active" to="/home">
              Trang chủ
            </Link>
          </li>
          <li>
            <Link className="dropdown-item" to="/user/infor">
              Thông tin tài khoản
            </Link>
          </li>
          <li>
            <Link className="dropdown-item" to="/file/manager">
              Quản lí file
            </Link>
          </li>

          <li>
            <Link to="/changepassword" className=" dropdown-item">
              Đổi mật khẩu
            </Link>
          </li>
          <li>
            <hr className="dropdown-divider" />
          </li>
          <li>
            <Link className="dropdown-item" to="/login">
              Đăng xuất
            </Link>
          </li>
        </ul>
      </div>
    </div>
  );
}
export default Header;
