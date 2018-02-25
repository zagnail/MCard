import React from 'react';
import { Route, Redirect, IndexRoute } from 'react-router';

import App from 'container/App';
import SimplePageComponent from 'container/SimplePageComponent';

export default () => (
  <Route path="/" name="app" component={ App }>
    <IndexRoute component={ SimplePageComponent } />
  </Route>
);
