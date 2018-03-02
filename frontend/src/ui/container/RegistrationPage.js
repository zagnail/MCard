import RegistrationForm from 'component/RegistrationForm';
import { connect } from 'react-redux';
import { registration } from 'reducers/user';

export default connect(
  state => ({ errorMessage: state.user.message }),
  { registration }
)(RegistrationForm);
