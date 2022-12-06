import "./App.css";
import Content from "./components/Content";
import Footer from "./components/footer/Footer";
import Header from "./components/Header";
import SideBar from "./components/SideBar";

function App() {
  return (
    <div className="App">
      <Header />
      <div className="flex mt-1">
        <SideBar />
        <Content />
      </div>

      <Footer />
    </div>
  );
}

export default App;
