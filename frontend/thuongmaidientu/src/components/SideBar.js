function SideBar() {
  return (
    <div className="w-64 text-center">
      <i className="fa fa-bars text-white translate-x-32 text-xl"></i>
      <ul className="text-white flex flex-col">
        <div className="flex bg-red-600 items-center text-center p-2 mb-2">
          <i className="fa fa-folder mr-4 "></i>
          <li>Quản lí tập tin</li>
        </div>
        <div className="flex bg-red-600 items-center text-center p-2 ">
          <i className="fa fa-heart mr-4"></i>
          <li>Yêu Thích</li>
        </div>
      </ul>
    </div>
  );
}
export default SideBar;
