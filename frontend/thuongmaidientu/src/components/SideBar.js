function SideBar() {
  return (
    <div className="row-span-3 bg-slate-800">
      <i className="fa fa-bars text-white translate-x-32 text-xl"></i>
      <ul className="text-white flex flex-col">
        <div className="flex bg-red-600">
          <i className="fa fa-folder mr-4 "></i>
          <li>Quản lí tập tin</li>
        </div>
        <div className="flex">
          <i className="fa fa-heart"></i>
          <li>Yêu Thích</li>
        </div>
      </ul>
    </div>
  );
}
export default SideBar;
