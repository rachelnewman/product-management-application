import React from "react";
import { render, screen } from "../../test-utils.js";
import ProductList from "./ProductList";

const defaultProps = {
  productList: [
    {
      id: "1",
      name: "Knife Set",
      categoryId: "1",
      categoryName: "Kitchen",
    },
    {
      id: "2",
      name: "Plate Rack",
      categoryId: "1",
      categoryName: "Kitchen",
    },
  ],
};

describe("ProductList", () => {
  test("renders ProductList component without props", () => {
    render(<ProductList />);
    expect(
      screen.getByText("There aren't any products that match your search term!")
    ).toBeTruthy();
  });
  test("renders ProductList component with products", () => {
    render(<ProductList {...defaultProps} />);
    expect(screen.getByText(defaultProps.productList[0].name)).toBeTruthy();
  });
  test("shows categoryName", () => {
    render(<ProductList {...defaultProps} />);
    expect(
      screen.queryAllByText(defaultProps.productList[1].categoryName)
    ).toBeTruthy();
  });
});
