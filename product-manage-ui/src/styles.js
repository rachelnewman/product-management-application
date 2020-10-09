import styled from "styled-components";

const Header = styled.header`
  padding: 30px;
  display: flex;
  align-items: center;
`;

const Container = styled.div`
  font-family: ${(props) => props.theme.typography.font};
`;

const Logo = styled.img`
  height: 50px;
  margin-right: 10px;
`;

export { Header, Container, Logo };
