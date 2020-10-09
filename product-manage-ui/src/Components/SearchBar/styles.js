import styled from "styled-components";

const SearchBar = styled.form`
  border-radius: 3px;
  width: 75%;
  min-width: 300px;
  display: flex;
  position: relative;
  height: min-content;
`;
const Input = styled.input`
  appearance: none;
  width: 100%;
`;

const Button = styled.button`
  background-color: ${(props) => props.theme.colors.secondary};
  color: ${(props) => props.theme.colors.white};
  line-height: ${(props) => props.theme.typography.lineHeight};
  margin-left: -2px;
`;

export { Input, SearchBar, Button };
