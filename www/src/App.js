import Header from './components/Header';
import { Route } from 'react-router';

import { Container } from 'react-bootstrap';
import Home from './pages/post/Home';
import SaveForm from './pages/post/SaveForm';
import Detail from './pages/post/Detail';
import Login from './pages/user/Login';
import Register from './pages/user/Register';
import UpdateForm from './pages/post/UpdateForm';

function App() {
  return (
    <div>
      <Header />
      <Container>
        <Route path="/" exact={true} component={Home} />
        <Route path="/saveForm" exact={true} component={SaveForm} />
        <Route path="/posts/:id" exact={true} component={Detail} />
        <Route path="/login" exact={true} component={Login} />
        <Route path="/register" exact={true} component={Register} />
        <Route path="/updateForm/:id" exact={true} component={UpdateForm} />
      </Container>
    </div>
  );
}

export default App;
