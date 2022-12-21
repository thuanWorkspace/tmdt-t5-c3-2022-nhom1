import { Link } from "react-router-dom";
import Header from "./Header";
import Service from "./Service";
function Home() {
  return (
    <div className="">
      <Header />
      <span className="mt-2 block">
        <div
          style={{
            width: "100%",
            height: "800px",
            objectFit: "fill",
            backgroundRepeat: "no-repeat",
            backgroundSize: "100% auto",
            position: "relative",
            backgroundImage: `url("https://cafefcdn.com/2019/8/22/edf-tempo-couleur-de-demain-la-edf-tempo-historique-couleur-jour-et-demain-15664469984471689659056.jpg")`,
          }}
        ></div>

        <span>
          <div
            style={{
              position: "absolute",
              width: "100%",
              height: "800px",
              top: "80px",
              left: "0px",
              backgroundColor: "rgba(0,0,0,0.5)",
            }}
          ></div>
          <Link
            to="/file/manager"
            className="text-center m-auto px-16 py-2 bg-red-600 text-white text-xl flex-1 rounded-sm"
            style={{
              position: "absolute",
              flex: "100",
              top: "430px",
              left: "600px",
              letterSpacing: "2px",
            }}
          >
            {" "}
            QUẢN LÝ TẬP TIN
          </Link>
        </span>
      </span>
    </div>
  );
}
export default Home;
