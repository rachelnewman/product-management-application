import React from "react";
import { render, screen } from "../../test-utils.js";
import List from "./List";

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

describe("List", () => {
  test("renders List component without props", () => {
    render(<List />);
    expect(screen.queryByText("You've searched for:")).toBeNull();
  });
  test("renders List component with products", () => {
    render(<List {...defaultProps} />);
    expect(screen.getByText("Sort by:")).toBeTruthy();
  });
});
