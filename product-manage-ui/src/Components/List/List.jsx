import React, { useState, useEffect } from "react";
import { withRouter } from "react-router-dom";
import ProductList from "../ProductList/ProductList";
import * as Styled from "./styles";

const List = ({
  match = {},
  history = [],
  location = {},
  productList = [],
  handleSort = () => {},
}) => {
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
      history.push(`?sortby=${e.target.value.replace(" ", "")}`);
    }
    setSortBy(e.target.value);
    handleSort(e.target.value.toLowerCase());
  };
  return (
    <Styled.ListContainer>
      <Styled.ListerHeader>
        {match.params.searchterm ? (
          <h2>You've searched for: {match.params.searchterm}</h2>
        ) : (
          <h2>Showing all products</h2>
        )}
        {productList && (
          <Styled.ListTools>
            <label>Sort by:</label>
            <Styled.SortBy onChange={(e) => handleSortChange(e)} value={sortBy}>
              <Styled.SortOption>Select</Styled.SortOption>
              <Styled.SortOption>Alphabetical</Styled.SortOption>
              <Styled.SortOption>Category</Styled.SortOption>
              <Styled.SortOption>Size-Descending</Styled.SortOption>
              <Styled.SortOption>Size-Ascending</Styled.SortOption>
            </Styled.SortBy>
          </Styled.ListTools>
        )}
      </Styled.ListerHeader>
      <ProductList productList={productList} />
    </Styled.ListContainer>
  );
};

export default withRouter(List);
