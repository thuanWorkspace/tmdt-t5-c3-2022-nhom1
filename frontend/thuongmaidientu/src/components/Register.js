import { Link } from "react-router-dom";
import Footer from "./footer/Footer";
import Navbar from "./Navbar";

function Register() {
  return (
    <div>
      <Navbar />
      <div className=" w-1/3 mx-auto mt-10 bg-slate-100 rounded-md shadow-inner ">
        <span className="text-center block translate-y-6">
          <h2 className="text-2xl ">Đăng Ký</h2>
          <h4 className="mt-2 text-lg">Với mạng xã hội của bạn</h4>
        </span>
        <span className="flex justify-around items-center mt-5  m-auto shrink-0 w-5/6">
          <Link className="flex items-center p-2 bg-blue-500 text-white rounded-md">
            <i className="fa fa-google mr-2"></i>
            <h3 className="">ĐĂNG NHẬP VỚI GOOGLE</h3>
          </Link>
          <Link className="flex items-center bg-blue-700 px-12 py-2 w-2/5 text-white shrink-0 rounded-md ">
            <i className="fa fa-facebook "></i>
            <h3 className="ml-2">FACEBOOK</h3>
          </Link>
        </span>
        <h3 className="text-center mt-3">Hoặc</h3>
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
        <span className="flex flex-col w-10/12 m-auto mt-2 border-b-4 ">
          <label htmlFor="" className="text-xs text-gray-600">
            Password Confirm
          </label>
          <input type="password" className=" outline-none" />
        </span>
        <span className="flex justify-between w-10/12 m-auto mt-3">
          <span className="flex items-center justify-center">
            <input type="checkbox" className="mr-4 " />
            <h3>Đồng ý với điều khoản</h3>
          </span>
          <Link className="text-blue-500">Điều khoản của dịch vụ</Link>
        </span>
        <Link
          to="/home"
          className=" p-2 mx-11 mt-4 bg-red-600 text-white flex justify-center rounded-md"
        >
          ĐĂNG KÝ
        </Link>
        <span className="flex items-center justify-center mt-3 pb-8">
          <h3>Bạn đã có tài khoản?</h3>
          <Link className="text-blue-500">Đăng nhập ngay</Link>
        </span>
      </div>
      <Footer />
    </div>
  );
}
export default Register;
