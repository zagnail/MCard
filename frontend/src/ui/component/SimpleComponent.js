import React, { Component } from 'react';

export default class SimpleComponent extends Component {
  render() {
    var message = this.props.message;

    return (
      <div>
        <p>{ message }</p>
        <button onClick={ this.props.fetchSimple }>Fetch</button>
      </div>
    );
  }
}
