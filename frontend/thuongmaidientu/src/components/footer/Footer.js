import FooterItem from "./component/FooterItem";

const listItem = [
  {
    name: "FSHARE",
    listItem: ["Tính năng", "Gói Dịch Vụ", "Đối tác", "Liên Hệ"],
  },
  {
    name: "CHÍNH SÁCH",
    listItem: [
      "Chính sách điểm thưởng",
      "Chính sách hội viên",
      "Điều khoản của dịch vụ",
      "Chính sách và quy định chung",
    ],
  },
  {
    name: "HỖ TRỢ - HƯỚNG DẪN",
    listItem: [
      "THÔNG TIN LIÊN HỆ",
      "Hotline: 1900 6600",
      "Email hỗ trợ: hotro@fshare.vn",
    ],
  },
  {
    name: "LIÊN HỆ QUẢNG CÁO",
    listItem: ["Hotline: 079 2200 747", "Email: sinhptn3@fpt.com.vn"],
  },
  {
    name: "KẾT NỐI VỚI CHÚNG TÔI",
    listItem: [
      "Facebook: Nguyễn Triều Tiên",
      "Email: nguyentrieutien2001vn.com",
    ],
  },
];
export default function Footer() {
  return (
    <div className="  bg-gray-600 mt-32 h-full">
      <span className=" flex justify-evenly w-full mx-auto text-white">
        {listItem.map((item, index) => (
          <FooterItem key={index} name={item.name} listItem={item.listItem} />
        ))}
      </span>
      <hr className="mt-4 text-gray-400  " />
      <span className="m-20 text-center text-white">
        <h3 className="mb-4 font-medium text-base">
          Tên: CHI NHÁNH CÔNG TY CỔ PHẦN THUẬN PHẠM
        </h3>
        <h3 className="mb-4">
          Giấy chứng nhận đăng ký kinh doanh số 0101778163 - 001 do Sở Kế Hoạch
          Đầu Tư Thành Phố Hồ Chí Minh cấp lần đầu vào ngày 13/09/2005.
        </h3>
        <h3 className="mb-4">Người chịu trách nhiệm: Nguyễn Triều Tiên</h3>
        <h3 className="mb-4">
          Địa chỉ: Lô 37-39A, Đường số 19, Khu Chế Xuất Tân Thuận, Phường Tân
          Thuận Đông, Quận 7, TP. Hồ Chí Minh.
        </h3>

        <h3 className="mb-4">Số điện thoại: 1900 6600.</h3>
        <h3 className="mb-4">19130230@st.hcmuaf.edu.vn</h3>
        <h3 className="mb-4">Giấy phép MXH số 364/GP-BTTTT do Bộ TTTT cấp.</h3>
      </span>
    </div>
  );
}
