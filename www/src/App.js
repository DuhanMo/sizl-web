import Header from './components/Header';
import { Route } from 'react-router';
import BoardListPage from './pages/BoardListPage';
import BoardDetailPage from './pages/BoardDetailPage';
import { useEffect, useState } from 'react';
import HelloPage from './pages/HelloPage';
import { Container } from 'react-bootstrap';
import Home from './pages/post/Home';
import SaveForm from './pages/post/SaveForm';
import Detail from './pages/post/Detail';
import loginForm from './pages/user/loginForm';
import joinForm from './pages/user/joinForm';
import UpdateForm from './pages/post/UpdateForm';

function App() {
  return (
    <div>
      <Header />
      <Container>
        <Route path="/" exact={true} component={Home} />
        <Route path="/saveForm" exact={true} component={SaveForm} />
        <Route path="/post/:id" exact={true} component={Detail} />
        <Route path="/loginForm" exact={true} component={loginForm} />
        <Route path="/joinForm" exact={true} component={joinForm} />
        <Route path="/updateForm/:id" exact={true} component={UpdateForm} />
      </Container>
    </div>
  );
}

export default App;
