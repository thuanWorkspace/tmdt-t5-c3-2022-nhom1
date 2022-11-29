import { Link } from "react-router-dom";
import Header from "./Header";
function Home() {
  return (
    <div className="">
      <Header />
      <Link to="/filemanager"> Quản lí file</Link>
    </div>
  );
}
export default Home;
