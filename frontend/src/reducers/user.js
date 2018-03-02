import { browserHistory } from 'react-router';
import { redirectToLoginWithMessage } from './authentication';

const NEW_REQUEST = 'user/NEW_REQUEST';
const NEW_SUCCESS = 'user/NEW_SUCCESS';
const NEW_FAIL = 'user/NEW_FAIL';

const ERROR_MESSAGE = 'user/ERROR_MESSAGE';

const initialState = {
  message: '',
  loading: true
};

// Reducer

export default function reducer(state = initialState, action) {
  switch (action.type) {
    case NEW_SUCCESS:
      return {
        ...state,
        message: action.result.data.message
      };

    case NEW_FAIL:
      return {
        ...state,
        message: action.error.data.message
      };

    case ERROR_MESSAGE:
      return {
        ...state,
        message: action.message
      };

    default:
      return state;
  }
}

// Actions

export function displayRegisterError(message) {
  return { type: ERROR_MESSAGE, message };
}

export function registration(email, password) {
  return {
    types: [NEW_REQUEST, NEW_SUCCESS, NEW_FAIL],
    promise: (client) => client.post('/api/user/new', { email, password }),
    afterSuccess: (dispatch, getState, response) => {
      if (response.status === 201) {
        browserHistory.push('login');
      } else {
        redirectToRegisterationWithMessage(response.data.message);
      }
    }
  };
}

function redirectToRegisterationWithMessage(messageKey) {
  return (dispatch, getState) => {
    const currentPath = getState().routing.locationBeforeTransitions.pathname;
    dispatch(displayAuthError(messageKey));
    browserHistory.replace({ pathname: '/register', state: { nextPathname: currentPath } });
  };
}
