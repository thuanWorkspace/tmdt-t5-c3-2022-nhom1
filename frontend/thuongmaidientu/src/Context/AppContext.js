import axios from "axios";
import { createContext, useEffect, useState } from "react";

export const AppContext = createContext({});

export const Provider = ({ children }) => {
  const [products, setProducts] = useState([]);
  useEffect(() => {
    axios
      .get("http://localhost:8080/productapi/products")
      .then((res) => {
        setProducts(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);
  return <AppContext.Provider>{children}</AppContext.Provider>;
};
