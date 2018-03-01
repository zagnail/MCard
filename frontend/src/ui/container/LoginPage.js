import LoginForm from 'component/LoginForm';
import { connect } from 'react-redux';
import { login } from 'reducers/authentication';

export default connect(
  state => ({ errorMessage: state.authentication.erroMessage }),
  { login }
)(LoginForm);
