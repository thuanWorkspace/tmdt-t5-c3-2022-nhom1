import { Link } from "react-router-dom";

function Navbar() {
  return (
    <div className="col-span-2 flex justify-between text-center  bg-slate-100 text-xl items-center p-1 border-red-700">
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
      <ul className="flex cursor-pointer">
        <li className="mr-12">GIỚI THIỆU</li>
        <li className="mr-12">HỖ TRỢ</li>
        <li className="mr-12">EVENT</li>
        <li className="mr-12">NÂNG CẤP</li>
      </ul>
      <span className="block">
        <Link
          to="/register"
          className="bg-red-600 p-3 text-white font-medium text-sm mr-3"
        >
          ĐĂNG KÝ
        </Link>

        <Link
          to="/login"
          className="bg-red-600 p-3 text-white font-medium text-sm"
        >
          ĐĂNG NHẬP
        </Link>
      </span>
    </div>
  );
}
export default Navbar;
