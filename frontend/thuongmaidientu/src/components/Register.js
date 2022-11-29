import { Link } from "react-router-dom";
import Footer from "./footer/Footer";

function Register() {
  return (
    <div>
      <span className="col-span-2 flex justify-between text-center  bg-slate-100 text-xl items-center p-1">
        <Link to="/home">
          <img
            className="logo-fshare w-32"
            src="https://storage.fshare.vn/images/logo-2.png"
            alt="Fshare"
          />
        </Link>
        <ul className="flex cursor-pointer ">
          <li className="mr-12">GIỚI THIỆU</li>
          <li className="mr-12">HỖ TRỢ</li>
          <li className="mr-12">EVENT</li>
          <li className="mr-12">NÂNG CẤP</li>
        </ul>

        <Link
          to="/home"
          className="bg-red-600 p-3 text-white font-medium text-sm"
        >
          ĐĂNG NHẬP
        </Link>
      </span>
      <Footer />
    </div>
  );
}
export default Register;
