import styled, { createGlobalStyle } from "styled-components";

const Header = styled.header`
  padding: 30px;
  display: flex;
  align-items: center;
  background-color: ${(props) => props.theme.colors.primary};
`;

const Container = styled.div`
  font-family: ${(props) => props.theme.typography.font};
`;

const Logo = styled.img`
  height: 50px;
  margin-right: 10px;
`;

const Error = styled.div`
  border: 3px solid ${(props) => props.theme.colors.error};
  margin: 15px;
  padding: 10px;
  border-radius: 3px;
  background-color: ${(props) => props.theme.colors.error}7F;
`;

export const GlobalStyle = createGlobalStyle`
	body {
    margin: 0;
  }
`;

export { Header, Container, Logo, Error };
