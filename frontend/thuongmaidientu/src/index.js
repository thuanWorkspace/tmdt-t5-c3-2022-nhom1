import React from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";
import Home from "./components/Home";
import Navbar from "./components/Navbar";
import Register from "./components/Register";
import Login from "./components/Login";
import Service from "./components/Service";
import Payment from "./components/Payment";
import InforUser from "./components/InforUser";
import { AppProvider } from "./components/Context/AppContext";
import Content from "./components/Content";
import ForgotPassword from "./components/ForgotPassword";
import ChangePassword from "./components/ChangePassword";
import HistoryBuy from "./components/HistoryBuy";
import ExpiredService from "./components/ExpiredService";
import FileShare from "./components/FileShare";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <AppProvider>
      <Router>
        <Routes>
          <Route path="/home" element={<Home />} />
          <Route path="/expiredservice" element={<ExpiredService />} />
          <Route path="/fileshare" element={<FileShare />} />
          <Route path="/changepassword" element={<ChangePassword />} />
          <Route path="/historybuy/:id" element={<HistoryBuy />} />
          <Route path="/forgotpassword" element={<ForgotPassword />} />
          <Route path="/file/manager" element={<App />} />
          <Route path="/" element={<Navbar />} />
          <Route path="/user/infor" element={<InforUser />} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="/service" element={<Service />} />
          <Route path="/payment" element={<Payment />} />
          <Route path="/content" element={<Content />} />
        </Routes>
      </Router>
    </AppProvider>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
