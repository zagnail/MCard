import React from 'react';
import { Route, Redirect, IndexRoute } from 'react-router';

import App from 'container/App';
import SimplePageComponent from 'container/SimplePageComponent';
import LoginPage from 'container/LoginPage';

export default (onLogout) => (
  <Route path="/" name="app" component={ App }>
    <IndexRoute component={ SimplePageComponent } />
    <Route path="login" component={ LoginPage } />
    <Route path="logout" onEnter={ onLogout } />
  </Route>
);
