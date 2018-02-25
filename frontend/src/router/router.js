import React from 'react';
import { Route, Redirect, IndexRoute } from 'react-router';

import App from 'container/App';

export default () => (
  <Route path="/" name="app" component={ App }>
  
  </Route>
);
