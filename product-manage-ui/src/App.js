import React, { useState, useEffect } from "react";
import { Route, Switch, BrowserRouter as Router } from "react-router-dom";
import SearchBar from "./Components/SearchBar/SearchBar";
import List from "./Components/List/List";
import { executeSearch, sortSearch } from "./services/productService";
import logo from "./logo.svg";

import * as Styled from "./styles";
const App = () => {
  const [productList, setProductList] = useState([]);
  const [error, setError] = useState("");
  const [searchTerm, setSearchTerm] = useState("");

  const onSearch = (newSearchTerm) => {
    executeSearch(newSearchTerm, setProductList, setError);
    setSearchTerm(newSearchTerm);
  };
  const onSort = (sortby) => {
    sortSearch(searchTerm, sortby, setProductList, setError);
  };
  return (
    <Router>
      <Styled.Container>
        <Styled.Header>
          <a href="/">
            <Styled.Logo src={logo} />
          </a>
          <SearchBar handleSearch={onSearch} currentSearchTerm={searchTerm} />
        </Styled.Header>

        {error && <div>Oops! Looks like something went wrong: {error}</div>}
        <Switch>
          <Route path="/search/:searchterm?">
            <List handleSort={onSort} productList={productList} />
          </Route>
        </Switch>
      </Styled.Container>
    </Router>
  );
};

export default App;
