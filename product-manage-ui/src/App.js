import React, { useState } from "react";
import { Route, Switch, BrowserRouter as Router } from "react-router-dom";
import SearchBar from "./Components/SearchBar/SearchBar";
import List from "./Components/List/List";
import Home from "./Components/Home/Home";
import { executeSearch, sortSearch } from "./services/productService";
import logo from "./Components/Icons/catalog.svg";

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
      <Styled.GlobalStyle />

      <Styled.Container>
        <Styled.Header>
          <a href="/">
            <Styled.Logo src={logo} />
          </a>
          <SearchBar handleSearch={onSearch} currentSearchTerm={searchTerm} />
        </Styled.Header>

        {error && (
          <Styled.Error>
            Oops! Looks like something went wrong: {error}
          </Styled.Error>
        )}
        <Switch>
          <Route exact path="/">
            <Home />
          </Route>
          <Route path="/search/:searchterm?">
            <List handleSort={onSort} productList={productList} />
          </Route>
        </Switch>
      </Styled.Container>
    </Router>
  );
};

export default App;
