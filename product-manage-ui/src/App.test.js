import React from "react";
import { render } from "./test-utils.js";
import App from "./App";

describe("App", () => {
  test("renders App component", () => {
    render(<App />);
  });
});
