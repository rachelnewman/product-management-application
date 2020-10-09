import axios from "axios";
import { SERVICE_ENDPOINT, SEARCH_MAPPING } from "../config/endpoints";

export const executeSearch = (search, setProductList, setError) => {
  axios
    .get(SERVICE_ENDPOINT + SEARCH_MAPPING + `/${search}`)
    .then((res) => {
      setProductList(res.data.products);
    })
    .catch((err) => setError(err.message));
};
