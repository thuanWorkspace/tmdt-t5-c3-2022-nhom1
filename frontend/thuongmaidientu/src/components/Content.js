import { useContext } from "react";
import { Link } from "react-router-dom";
import { AppContext } from "./Context/AppContext";

function Content() {
  const { files, state } = useContext(AppContext);
  return (
    <div className="">
      <nav
        id="navbar-example2"
        className="navbar bg-light px-3 mb-3"
        style={{ width: "1250px" }}
      >
        <i className="fa fa-home text-2xl"></i>
        <ul className="nav nav-pills ">
          <li className="nav-item border-2 p-x-6 ml-8  bg-red-600 rounded-sm">
            <Link
              className="nav-link px-12  text-white"
              href="#scrollspyHeading2"
            >
              <i className="fa fa-plus mr-4"></i>
              UPLOAD FILE
            </Link>
          </li>
        </ul>
      </nav>
      <table className="table">
        <thead>
          <tr>
            <th scope="col">Tên</th>
            <th scope="col">Kích Thước</th>
            <th scope="col">Trạng Thái</th>
            <th scope="col">Hoạt Động</th>
          </tr>
        </thead>
        {files.map((file, index) => (
          <tbody key={index}>
            <tr>
              <th
                scope="row"
                className="flex justify-center items-center space-x-3"
              >
                
                <input type="checkbox" />
                <h3>{file.file_name}</h3>
              </th>

              <td>{(file.size / 1024).toFixed(1) + "KB"}</td>
              <td>{state}</td>
              <td className=" flex w-8  m-auto items-center ">
                <i className="fa fa-download mr-6"></i>
                <i className="fa fa-share"></i>
              </td>
            </tr>
          </tbody>
        ))}
      </table>
    </div>
  );
}
export default Content;
