import React from "react";

export default ({ productList }) => {
  return productList.map((product) => <div>{product.name}</div>);
};
