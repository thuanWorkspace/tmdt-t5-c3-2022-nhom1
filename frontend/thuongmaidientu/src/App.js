import "./App.css";
import Header from "./components/Header";
import SideBar from "./components/SideBar";
import Footer from "./components/Footer";

function App() {
  return (
    <div className="App">
      <div className="grid grid-rows-3 grid-flow-col gap-4 ">
        <SideBar />
        <Header />
      </div>
      <Footer/>
    </div>
  );
}

export default App;
