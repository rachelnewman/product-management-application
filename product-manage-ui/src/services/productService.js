import axios from "axios";
import { SERVICE_ENDPOINT, SEARCH_MAPPING } from "../config/endpoints";

export const executeSearch = (search, setProductList, setError) => {
  axios
    .get(SERVICE_ENDPOINT + SEARCH_MAPPING + `/${search}`)
    .then((res) => {
      setError(null);
      setProductList(res.data.products);
    })
    .catch((err) => {
      setError(err.message);
      setProductList(null);
    });
};

export const sortSearch = (search, sortby, setProductList, setError) => {
  let sort = sortby;
  if (sortby.includes("size")) {
    sort = sortby.includes("ascending") ? "size-asc" : "size-desc";
  }
  axios
    .get(SERVICE_ENDPOINT + SEARCH_MAPPING + `/${search.trim()}?sortby=${sort}`)
    .then((res) => {
      setError(null);
      setProductList(res.data.products);
    })
    .catch((err) => {
      setError(err.message);
      setProductList(null);
    });
};
