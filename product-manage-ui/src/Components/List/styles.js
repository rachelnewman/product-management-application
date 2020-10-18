import styled from "styled-components";

export const ListContainer = styled.div`
  margin: 0 30px;
  @media (min-width: 900px) {
    width: 75%;
    margin: 0 auto;
  }
`;
export const ListerHeader = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  flex-wrap: wrap;
  margin-bottom: 5px;
`;
export const ListTools = styled.div`
  padding: 5px 5px 5px 0;
`;
export const SortBy = styled.select`
  margin-left: 5px;
`;
export const SortOption = styled.option``;
