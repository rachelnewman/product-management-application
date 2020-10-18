import React from "react";
import * as Styled from "./styles";
export default () => {
  return (
    <Styled.Wrapper>
      Hello! Welcome to Rachel's product management application. Try searching
      for a product by it's name or part of it's name, or
      <a href="/search"> see all products</a>
    </Styled.Wrapper>
  );
};
