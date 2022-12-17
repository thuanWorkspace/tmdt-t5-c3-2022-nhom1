import { Link } from "react-router-dom";

function Content() {
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
        <tbody>
          <tr>
            <th
              scope="row"
              className="flex justify-center items-center space-x-3"
            >
              <input type="checkbox" />
              <i className="fa fa-folder"></i>
              <h3>Photos</h3>
            </th>

            <td>_</td>
            <td>Public</td>
            <td className=" flex w-8  m-auto items-center ">
              <i className="fa fa-download mr-6"></i>
              <i className="fa fa-share"></i>
            </td>
          </tr>
          <tr>
            <th scope="row">
              <input type="checkbox" />
            </th>
            <td></td>
            <td>Private</td>
            <td>@fat</td>
          </tr>
          <tr>
            <th scope="row">
              <input type="checkbox" />
            </th>
            <td colspan="2">Larry the Bird</td>
            <td>@twitter</td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}
export default Content;
