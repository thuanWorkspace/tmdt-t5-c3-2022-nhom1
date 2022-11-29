import { Link } from "react-router-dom";

function Header() {
  return (
    <div className="col-span-2 flex justify-between text-center  bg-slate-100 text-xl items-center p-1">
      <Link to="/home">
        <img
          className="logo-fshare w-32"
          src="https://storage.fshare.vn/images/logo-2.png"
          alt="Fshare"
        />
      </Link>

      <span className="flex space-x-4">
        <span>
          <input
            type="text"
            placeholder="Tìm kiếm"
            className="outline-none border-solid"
          />
          <i className="fa fa-search translate-x-[-2rem]"></i>
        </span>
        <i className="flex fa fa-bell translate-x-[-1rem] items-center "></i>
        <img
          className="rounded-full w-8"
          src="https://scontent.fsgn2-7.fna.fbcdn.net/v/t39.30808-6/313413599_857123762314098_2590904766447935011_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=PFgIhXF5iZMAX9a56BK&_nc_oc=AQnTeKTuxDFbx-6a4p8niRyGiQ7vPryG1aUdyE6R7DsgyY92xmZrB28j6HbbZnwfi_dxPSRtNJUU_ulflRxxhZ9f&_nc_ht=scontent.fsgn2-7.fna&oh=00_AfDTkmwW7OMM6eT-nXo0O-Qo2lHbW7vF46PNqtJdaf7LnA&oe=638644D0"
          alt=""
        />
        <h3>Nguyễn Triều Tiên</h3>
        <i className="fa fa-chevron-down"></i>
      </span>
    </div>
  );
}
export default Header;
