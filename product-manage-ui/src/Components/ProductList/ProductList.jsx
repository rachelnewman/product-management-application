import React from "react";
import * as Styled from "./styles";

export default ({ productList = [] }) => {
  if (!productList?.length) {
    return (
      <Styled.ListWrapper>
        There aren't any products that match your search term!
        <span role="img" aria-hidden={true}>
          😥
        </span>
      </Styled.ListWrapper>
    );
  }
  return (
    <Styled.ListWrapper>
      {productList.map((product) => (
        <Styled.ProductCard
          category={product.categoryName.replace(" ", "").toLowerCase()}
          key={product.id}
        >
          <div>{product.name}</div>
          <div>{product.categoryName}</div>
        </Styled.ProductCard>
      ))}
    </Styled.ListWrapper>
  );
};
