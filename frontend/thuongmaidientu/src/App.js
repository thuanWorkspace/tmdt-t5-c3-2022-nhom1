import "./App.css";
import Footer from "./components/footer/Footer";
import Header from "./components/Header";
import SideBar from "./components/SideBar";

function App() {
  return (
    <div className="App">
      <div className="grid grid-cols-2 gap-">
        <Header />
        <SideBar />
      </div>
      <Footer />
    </div>
  );
}

export default App;
