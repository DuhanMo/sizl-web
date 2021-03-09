import logo from "./logo.svg";
import "./App.css";
import Header from "./components/Header";
import { Route } from "react-router";
import BoardListPage from "./pages/BoardListPage";
import BoardDetailPage from "./pages/BoardDetailPage";

function App() {
  return (
    <div>
      <Header />
      <Route path="/" exact={true} component={BoardListPage} />
      <Route path="/detail" exact={true} component={BoardDetailPage} />
    </div>
  );
}

export default App;
