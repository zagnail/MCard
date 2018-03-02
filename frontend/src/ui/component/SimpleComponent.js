import React, { Component } from 'react';

export default class SimpleComponent extends Component {
  render() {
    var email = this.props.email;

    return (
      <div>
        <p>{ email }</p>
        <button onClick={ this.props.fetchSimple }>Fetch</button>
      </div>
    );
  }
}
