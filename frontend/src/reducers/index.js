import { combineReducers } from 'redux';
import simple from './simple';
import authentication from './authentication';
import user from './user';
import { routerReducer as routing } from 'react-router-redux';

export default combineReducers({
  simple,
  authentication,
  user,
  routing
});
