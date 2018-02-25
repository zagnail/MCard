const FETCH = 'simple/FETCH';
const FETCH_SUCCESS = 'simple/FETCH_SUCCESS';
const FETCH_FAIL = 'simple/FETCH_FAIL';

const initialState = {
  message: ''
};

// Reducer

export default function simpleReducer(state = initialState, action) {
  switch (action.type) {
    case FETCH_SUCCESS:
      return {
        ...state,
        message: action.result.data.message
      };

    default:
      return state;
  }
}

// Actions

export function fetchSimple() {
  return {
    types: [FETCH, FETCH_SUCCESS, FETCH_FAIL],
    promise: client => client.get('/api/simple')
  };
}
