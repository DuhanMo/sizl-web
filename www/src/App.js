import logo from "./logo.svg";
import "./App.css";
import Header from "./components/Header";
import { Route } from "react-router";
import BoardListPage from "./pages/BoardListPage";
import BoardDetailPage from "./pages/BoardDetailPage";
import { useEffect, useState } from "react";
import HelloPage from "./pages/HelloPage";

function App() {
  return (
    <div>
      <Header />
      <Route path="/" exact={true} component={BoardListPage} />
      <Route path="/detail" exact={true} component={BoardDetailPage} />
      <Route path="/api/hello" exact={true} component={HelloPage} />
    </div>
  );
}

export default App;
