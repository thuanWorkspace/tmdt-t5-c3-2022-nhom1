

function SideBar() {
  return (
    <div className="w-64 text-center py-3 bg-slate-900">
      <i className="fa fa-bars text-white translate-x-[92px] text-xl"></i>
      <ul className="text-white flex flex-col py-16">
        <div className="flex mt-1 bg-red-600 items-center text-center p-2 mb-2">
          <i className="fa fa-folder mr-4 "></i>
          <li>Quản lí tập tin</li>
        </div>
        <div className="flex items-center text-center p-2 mb-2 ">
          <i className="fa fa-share mr-4"></i>
          <li>Tập Tin Chia Sẻ Đến Tôi</li>
        </div>
        <div className="flex items-center text-center p-2 mb-2 ">
          <i className="fa fa-share mr-4"></i>
          <li>Dịch Vụ Còn Hạng</li>
        </div>
        <div className="flex items-center text-center p-2 mb-2 ">
          <li>Lịch Sử Mua Hàng</li>
        </div>
        <div className="flex items-center text-center p-2 mb-2 ">
          <i className="fa fa-share mr-4"></i>
          <li>Services</li>
        </div>
      </ul>
    </div>
  );
}
export default SideBar;
