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
          <li className="nav-item dropdown border-2 bg-white mr-8 rounded-sm">
            <Link
              className="nav-link dropdown-toggle text-black "
              data-bs-toggle="dropdown"
              href="#"
              role="button"
              aria-expanded="false"
            >
              Chọn Fillter
            </Link>
            <ul className="dropdown-menu ">
              <li>
                <a className="dropdown-item" href="#scrollspyHeading3">
                  Tất cả file
                </a>
              </li>
              <li>
                <a className="dropdown-item" href="#scrollspyHeading4">
                  Fourth
                </a>
              </li>
              <li>
                <a className="dropdown-item" href="#scrollspyHeading5">
                  Fifth
                </a>
              </li>
            </ul>
          </li>
          <li className="nav-item border-2 p-x-6 flex items-center rounded-sm">
            <i className="fa fa-filter ml-4  text-red-500"></i>
            <Link className="nav-link text-red-500 " href="#scrollspyHeading1">
              Lọc Hình Ảnh
            </Link>
          </li>
          <li className="nav-item border-2 p-x-6 ml-8  bg-red-600 rounded-sm">
            <Link
              className="nav-link px-12  text-white"
              href="#scrollspyHeading2"
            >
              <i className="fa fa-plus mr-4"></i>
              Mới
            </Link>
          </li>
        </ul>
      </nav>
      <table class="table">
        <thead>
          <tr>
            <th scope="col">Tên</th>
            <th scope="col">Kích Thước</th>
            <th scope="col">Cập Nhật</th>
            <th scope="col">Lượt Tải</th>
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
            <td>_</td>
            <td>_</td>
          </tr>
          <tr>
            <th scope="row">
              <input type="checkbox" />
            </th>
            <td>Jacob</td>
            <td>Thornton</td>
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
