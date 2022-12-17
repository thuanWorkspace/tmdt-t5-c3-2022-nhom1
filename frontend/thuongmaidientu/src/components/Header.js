import { Link } from "react-router-dom";

function Header() {
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
          className="btn dropdown-toggle border-none bg-blue-600 text-cyan-50"
          type="button"
          data-bs-toggle="dropdown"
          aria-expanded="false"
        >
          Triều Tiên Nguyễn
        </button>
        <ul className="dropdown-menu dropdown-menu-dark">
          <li>
            <a className="dropdown-item active" href="#">
              Trang chủ
            </a>
          </li>
          <li>
            <a className="dropdown-item" href="#">
              Thông tin tài khoản
            </a>
          </li>
          <li>
            <a className="dropdown-item" href="#">
              Quản lí file
            </a>
          </li>
          <li>
            <hr className="dropdown-divider" />
          </li>
          <li>
            <a className="dropdown-item" href="#">
              Đăng xuất
            </a>
          </li>
        </ul>
      </div>
    </div>
  );
}
export default Header;
