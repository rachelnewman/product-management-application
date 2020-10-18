import styled from "styled-components";

export const ListWrapper = styled.div`
  display: flex;
  text-align: center;
  flex-wrap: wrap;
`;

export const ProductCard = styled.div`
  border: 5px solid ${(props) => props.theme.colors.categories[props.category]};
  background-color: ${(props) =>
    props.theme.colors.categories[props.category]}59;
  display: flex;
  padding: 10px;
  margin: 5px;
  min-width: calc(50% - 40px);
  justify-content: space-between;
  @media (min-width: 1040px) {
    max-width: calc(33% - 40px);
    min-width: calc(33% - 40px);
  }
  :hover {
    background-color: ${(props) =>
      props.theme.colors.categories[props.category]}80;
  }
`;
