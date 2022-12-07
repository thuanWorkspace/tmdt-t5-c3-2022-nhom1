import { Link } from "react-router-dom";
import Footer from "./footer/Footer";
import Navbar from "./Navbar";

function Login() {
  return (
    <div>
      <Navbar />
      <div className=" w-1/3 mx-auto mt-10 bg-slate-100 rounded-md shadow-inner ">
        <span className="text-center block translate-y-6">
          <h2 className="text-2xl ">Đăng nhập</h2>
          <h4 className="mt-2 text-lg">Đăng nhập bằng Google/Facebook</h4>
        </span>
        <span className="flex justify-around items-center mt-5  m-auto shrink-0 w-5/6">
          <Link className="flex items-center p-2 bg-blue-500 text-white rounded-md">
            <i className="fa fa-google mr-2"></i>
            <h3 className="">ĐĂNG NHẬP VỚI GOOGLE</h3>
          </Link>
          <Link className="flex items-center py-2 bg-blue-700 px-12 text-white shrink-0 rounded-md ">
            <i className="fa fa-facebook "></i>
            <h3 className="">FACEBOOK</h3>
          </Link>
        </span>
        <h3 className="text-center mt-3">
          Hoặc đăng nhập vào tài khoản hiện có để tải nhiều hơn
        </h3>
        <span className="flex flex-col w-10/12 m-auto mt-2 border-b-4 ">
          <label htmlFor="" className="text-xs text-gray-600">
            Email
          </label>
          <input type="text" className=" outline-none" />
        </span>
        <span className="flex flex-col w-10/12 m-auto mt-2 border-b-4 ">
          <label htmlFor="" className="text-xs text-gray-600">
            Password
          </label>
          <input type="password" className=" outline-none" />
        </span>
        <span className="flex justify-between w-10/12 m-auto mt-3">
          <span className="flex items-center justify-center">
            <input type="checkbox" className="mr-4 " />
            <h3>Ghi nhớ đăng nhập</h3>
          </span>
          <Link className="text-blue-500">Quên mật khẩu?</Link>
        </span>
        <Link className=" p-2 mx-11 mt-4 bg-red-600 text-white flex justify-center rounded-md">
          ĐĂNG NHẬP
        </Link>
        <span className="flex items-center justify-center mt-3 pb-8">
          <h3>Bạn không có tài khoản?</h3>
          <Link className="text-blue-500">Đăng ký ngay</Link>
        </span>
      </div>
      <Footer />
    </div>
  );
}
export default Login;
