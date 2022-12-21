import { createContext } from "react";
import axios from "axios";
import React, { useEffect, useState } from "react";

export const AppContext = createContext({});

export const AppProvider = ({ children }) => {
  const [users, setUsers] = useState([0]);
  const [files, setFiles] = useState([]);
  const [state, setState] = useState();
  useEffect(() => {
    getFiles();
  }, []);
  const getFiles = async () => {
    let result = await fetch(
      "http://localhost:8080/fileapi/file/FileManager/6371bd880ac8ae8ad1af59ce"
    );
    result = await result.json();
    setFiles(result);
  };
  const handleSearch = async (e) => {
    let name = e.target.value;
    let result = await fetch(
      "http://localhost:8080/fileapi/file/searchpublic/tailieu"
    );
    result = await result.json();
    if (result) {
      setFiles(result);
    } else {
      getFiles();
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

  useEffect(() => {
    axios
      .get(
        "http://localhost:8080/userfileapi/access/status/6371bd880ac8ae8ad1af59ce/6371c1f10ac8ae8ad1af59da"
      )
      .then((res) => {
        console.log(res.data);
        setState(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);
  return (
    <AppContext.Provider value={{ users, handleSearch, files, state }}>
      {children}
    </AppContext.Provider>
  );
};
