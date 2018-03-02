const FETCH = 'simple/FETCH';
const FETCH_SUCCESS = 'simple/FETCH_SUCCESS';
const FETCH_FAIL = 'simple/FETCH_FAIL';

const initialState = {
  email: ''
};

// Reducer

export default function simpleReducer(state = initialState, action) {
  switch (action.type) {
    case FETCH_SUCCESS:
      return {
        ...state,
        email: action.result.data.email
      };

    default:
      return state;
  }
}

// Actions

export function fetchSimple() {
  return {
    types: [FETCH, FETCH_SUCCESS, FETCH_FAIL],
    promise: client => client.get('/api/session')
  };
}
