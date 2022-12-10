import FooterItem from "./component/FooterItem";

const listItem = [
  {
    name: "Fshare",
    listItem: ["test1", "test2", "test3"],
  },
  {
    name: "Fshare2",
    listItem: ["test1", "test2", "test3"],
  },
  {
    name: "Fshare3",
    listItem: ["test1", "test2", "test3"],
  },
];
export default function Footer() {
  return (
    <div className="  bg-gray-600 mt-96 h-56">
      <span className=" flex justify-around w-2/3 mx-auto text-white">
        {listItem.map((item) => (
          <FooterItem name={item.name} listItem={item.listItem} />
        ))}
      </span>
    </div>
  );
}
