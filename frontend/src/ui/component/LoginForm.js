import React, { Component } from 'react';

const LabeledInput = (props) => (
  <div className="pure-control-group">
    <label>
      { props.label }
    </label>
    <input { ...props } />
  </div>
);

const ErrorPanel = ({ messageKey }) => (
  <p className="error-panel">
    { messageKey }
  </p>
);

export default class LoginForm extends Component {
  
  constructor(props) {
    super(props);

    this.state = {
      email: "",
      password: ""
    };
  }

  handleInputChange = (e) => {
    let value = e.target.value;
    let inputName = e.target.name;
    this.setState({ [inputName]: value });
  };

  handleSubmit = (e) => {
    e.preventDefault();
    const { email, password } = this.state;
    const { login } = this.props;
    login(email, password);
  };

  render() {
    const { errorMessage } = this.props;
    const errorPanel = errorMessage ? <ErrorPanel messageKey={ errorMessage } /> : null;

    return (
      <div>
        <h2>Login Page</h2>
        <p>Default email and password are 'test@test.com' and 'password'</p>

        { errorPanel }

        <form onSubmit={ this.handleSubmit } className="pure-form pure-form-aligned">
          <LabeledInput onChange={ this.handleInputChange } label="Email" name="email" type="email" />
          <LabeledInput onChange={ this.handleInputChange } label="Password" name="password" type="password" />

          <div className="pure-controls">
            <button type="submit" className="pure-button pure-button-primary">Login</button>
          </div>
        </form>
      </div>
    );
  }
}
