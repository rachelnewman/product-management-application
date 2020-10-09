import React, { useState, useEffect } from "react";
import {
  Route,
  Switch,
  BrowserRouter as Router,
  useParams,
} from "react-router-dom";
import SearchBar from "./Components/SearchBar/SearchBar";
import List from "./Components/List";
import { executeSearch } from "./services/productService";
import logo from "./logo.svg";

import * as Styled from "./styles";
const App = () => {
  const [productList, setProductList] = useState([]);
  const [error, setError] = useState("");
  // const params = URLSearchParams();
  // useEffect(() => executeSearch(searchterm, setProductList, setError), []);
  const onSearch = (newSearchTerm) => {
    executeSearch(newSearchTerm, setProductList, setError);
  };
  return (
    <Router>
      <Styled.Container>
        <Styled.Header>
          <a href="/">
            <Styled.Logo src={logo} />
          </a>
          <SearchBar handleSearch={onSearch} />
        </Styled.Header>

        <div>
          {error && <div>Oops! Looks like something went wrong: {error}</div>}
          <Switch>
            <Route path="/search/:searchterm">
              <List productList={productList} />
            </Route>
          </Switch>
        </div>
      </Styled.Container>
    </Router>
  );
};

export default App;
