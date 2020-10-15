import React from "react";
import * as Styled from "./styles";
export default ({ productList }) => {
  if (!productList) return null;
  if (!productList.length) {
    return (
      <Styled.ListWrapper>
        There aren't any product that match your search term! 😥
      </Styled.ListWrapper>
    );
  }
  return productList.map((product) => (
    <div key={product.id}>{product.name}</div>
  ));
};
