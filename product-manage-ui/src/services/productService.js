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
  axios
    .get(SERVICE_ENDPOINT + SEARCH_MAPPING + `/${search}?sortby=${sortby}`)
    .then((res) => {
      setError(null);
      setProductList(res.data.products);
    })
    .catch((err) => {
      setError(err.message);
      setProductList(null);
    });
};
