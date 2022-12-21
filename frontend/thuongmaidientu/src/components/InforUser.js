import { useContext } from "react";
import { Link } from "react-router-dom";
import { AppContext } from "./Context/AppContext";
import Header from "./Header";
import SideBar from "./SideBar";

export default function InforUser() {
  const { users } = useContext(AppContext);
  return (
    <div>
      <Header />
      <div className="flex mt-1">
        <SideBar />
        <div className="justify-center w-full">
          <h3 className="text-center mt-8 font-medium text-xl">
            Thông Tin Tài Khoản
          </h3>
          <table className="table w-2/5 m-auto mt-4">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Thông tin cá nhân</th>
              </tr>
            </thead>

            <tbody>
              <tr>
                <th scope="row">Tên</th>
                <td className="text-base font-normal">{users[0].username}</td>
              </tr>
              <tr>
                <th scope="row">Email</th>
                <td className="text-base font-normal">{users[0].email}</td>
              </tr>
              <tr>
                <th scope="row">Gender</th>
                <td className="text-base font-normal">{users[0].gender}</td>
              </tr>
            </tbody>
          </table>
          <hr />
        </div>
      </div>
    </div>
  );
}
