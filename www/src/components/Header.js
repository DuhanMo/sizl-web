import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Button, Form, FormControl, Nav, Navbar } from 'react-bootstrap';
import { Link } from 'react-router-dom';

const Header = () => {
  return (
    <>
      <Navbar bg="primary" variant="dark">
        <Link to="/" className="navbar-brand">
          홈
        </Link>
        <Nav className="mr-auto">
          <Link to="/joinForm" className="nav-link">
            회원가입
          </Link>
          <Link to="/loginForm" className="nav-link">
            로그인
          </Link>
          <Link to="/" className="nav-link">
            글쓰기
          </Link>
        </Nav>
        <Form inline>
          <FormControl type="text" placeholder="Search" className="mr-sm-2" />
          <Button variant="outline-light">Search</Button>
        </Form>
      </Navbar>
    </>
  );
};

export default Header;
