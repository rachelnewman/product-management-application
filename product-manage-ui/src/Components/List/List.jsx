import React, { useState, useEffect } from "react";
import { withRouter } from "react-router-dom";
import ProductList from "../ProductList/ProductList";
import * as Styled from "./styles";

const List = ({ match, history, location, productList, handleSort }) => {
  const [sortBy, setSortBy] = useState(
    location.search.split("sortby=")[1] || "Select"
  );
  useEffect(() => {
    setSortBy(location.search.split("sortby=")[1] || "Select");
  }, [location.search]);
  const handleSortChange = (e) => {
    if (e.target.value === "Select") {
      history.push({ search: "" });
    } else {
      history.push(`?sortby=${e.target.value}`);
    }
    setSortBy(e.target.value);
    handleSort(e.target.value.toLowerCase());
  };
  return (
    <Styled.ListContainer>
      <Styled.ListerHeader>
        <h2>You searched for: {match.params.searchterm}</h2>
        <div>
          <label>Sort by:</label>
          <Styled.SortBy onChange={(e) => handleSortChange(e)} value={sortBy}>
            <Styled.SortOption>Select</Styled.SortOption>
            <Styled.SortOption>Alphabetical</Styled.SortOption>
            <Styled.SortOption>Category</Styled.SortOption>
            <Styled.SortOption>Size</Styled.SortOption>
          </Styled.SortBy>
        </div>
      </Styled.ListerHeader>
      <ProductList productList={productList} />
    </Styled.ListContainer>
  );
};

export default withRouter(List);
