/*!

=========================================================
* Material Dashboard React - v1.9.0
=========================================================

* Product Page: https://www.creative-tim.com/product/material-dashboard-react
* Copyright 2020 Creative Tim (https://www.creative-tim.com)
* Licensed under MIT (https://github.com/creativetimofficial/material-dashboard-react/blob/master/LICENSE.md)

* Coded by Creative Tim

=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

*/
import React from "react";
import ReactDOM from "react-dom";
import { createBrowserHistory } from "history";
import { Router, Route, Switch, Redirect } from "react-router-dom";

// core components
import Admin from "layouts/Admin.js";
import Dashboard from "./views/Dashboard/Dashboard";

import "assets/css/material-dashboard-react.css?v=1.9.0";
import NotFound from '../../../frontend/src/components/notfound/NotFound'

import Signin from '../../../frontend/src/components/EntryPage/Signin'
import Register from '../../../frontend/src/components/EntryPage/Register'
const hist = createBrowserHistory();

ReactDOM.render(
  <Router history={hist}>
    <Switch>
      <Route path="/login" component={Signin} />
      <Route path="/dashboard" component={Admin} />
      <Route path="/register" component={Register} />
      <Route component={NotFound} />
      <Redirect from="/" to="/dashboard" />
    </Switch>
  </Router>,
  document.getElementById("root")
);
