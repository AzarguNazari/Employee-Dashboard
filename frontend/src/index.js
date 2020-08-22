import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import {Redirect, Route, Router, Switch} from "react-router-dom"
import {createBrowserHistory} from "history";
import * as serviceWorker from './serviceWorker';
import Signin from "./View/SignIn";
import Register from "./View/Register";
import NotFound from "./View/NotFound"
import Meeting from "./View/Meeting"
import Announcement from "./View/Announcement"
import Messages from "./View/Messages"
import Notification from "./View/Notification"
import Attendance from "./View/Attendance"
import Dashboard from "./View/Dashboard"

const hist = createBrowserHistory()

ReactDOM.render(
    <Router history={hist}>
        <Switch>
            <Route path="/login" component={Signin} />
            <Route path="/register" component={Register} />
            <Route path="/dashboard" component={Dashboard} />
            <Route path="/profile" component={Dashboard} />
            <Route path="/meeting" component={Meeting} />
            <Route path="/announcements" component={Announcement} />
            <Route path="/message" component={Messages} />
            <Route path="/notifications" component={Notification} />
            <Route path="/attendance" component={Attendance} />
            <Route component={NotFound} />
            <Redirect from="/" to="/dashboard" />
        </Switch>
    </Router>,
  document.getElementById('root')
);
serviceWorker.unregister();
