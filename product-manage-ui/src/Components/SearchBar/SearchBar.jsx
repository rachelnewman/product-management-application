import React, { useState } from "react";
import * as Styled from "./styles";
import { withRouter } from "react-router-dom";

const SearchBar = ({ handleSearch, history }) => {
  const [searchTerm, setSearchTerm] = useState("");
  const handleOnSearch = (e, searchTerm) => {
    e.preventDefault();
    history.push(`/search/${searchTerm}`);
    handleSearch(searchTerm);
  };
  return (
    <Styled.SearchBar>
      <Styled.Input
        type="text"
        name="search"
        onChange={(e) => setSearchTerm(e.target.value)}
      />
      <Styled.Button
        type="submit"
        onClick={(e) => handleOnSearch(e, searchTerm)}
      >
        Search
      </Styled.Button>
    </Styled.SearchBar>
  );
};

export default withRouter(SearchBar);
