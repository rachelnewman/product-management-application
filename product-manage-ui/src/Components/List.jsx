import React from "react";
import { withRouter } from "react-router-dom";
import ProductList from "./ProductList/ProductList";

const List = ({ match, productList }) => {
  return (
    <>
      <h2>You searched for: {match.params.searchterm}</h2>
      <div>Sort By</div>
      <ProductList productList={productList} />
    </>
  );
};

export default withRouter(List);
