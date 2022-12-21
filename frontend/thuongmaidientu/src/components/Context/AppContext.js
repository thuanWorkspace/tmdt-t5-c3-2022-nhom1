import { createContext } from "react";
import axios from "axios";
import React, { useEffect, useState } from "react";

export const AppContext = createContext({});

export const AppProvider = ({ children }) => {
  const [users, setUsers] = useState([0]);
  const [products, setProducts] = useState([]);
  useEffect(() => {
    getProducts();
  }, []);
  const getProducts = async () => {
    let result = await fetch("http://localhost:8080/productapi/products");
    result = await result.json();
    setProducts(result);
  };
  const handleSearch = async (e) => {
    let name = e.target.value;
    let result = await fetch(
      "http://localhost:8080/fileapi/file/searchpublic/{name}"
    );
    result = await result.json();
    if (result) {
      setProducts(result);
    } else {
      getProducts();
    }
  };
  useEffect(() => {
    axios
      .get("http://localhost:8080/userapi/users")
      .then((res) => {
        setUsers(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);
  return (
    <AppContext.Provider value={{ users, handleSearch, products }}>
      {children}
    </AppContext.Provider>
  );
};
