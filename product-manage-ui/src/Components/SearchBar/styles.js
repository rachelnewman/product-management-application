import styled from "styled-components";

const SearchBar = styled.form`
  border-radius: 3px;
  width: 75%;
  min-width: 300px;
  display: flex;
  position: relative;
  height: min-content;
  margin: 0 15px;
`;
const Input = styled.input`
  appearance: none;
  width: 100%;
  border-radius: 3px 0 0 3px;
  border-color: ${(props) => props.theme.colors.secondary};
  border-style: none;
  font-size: ${(props) => props.theme.typography.fontSize[50]};
`;

const Button = styled.button`
  background-color: ${(props) => props.theme.colors.secondary};
  border-color: ${(props) => props.theme.colors.secondary};
  border-radius: 0 3px 3px 0;
  border-style: none;
  color: ${(props) => props.theme.colors.primary};
  line-height: ${(props) => props.theme.typography.lineHeight[10]};
  font-size: ${(props) => props.theme.typography.fontSize[30]};
  margin-left: -2px;
`;

export { Input, SearchBar, Button };
