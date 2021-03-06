import SimpleComponent from 'component/SimpleComponent';
import { connect } from 'react-redux';
import { fetchSimple } from 'reducers/simple';

export default connect(
  state => ({ email: state.simple.email }),
  { fetchSimple }
)(SimpleComponent);
