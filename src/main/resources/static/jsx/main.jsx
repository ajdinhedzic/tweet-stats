var React = require('react');
var ReactDOM = require('react-dom');
var { browserHistory } = require('react-router');
var Root = require('./Root');

ReactDOM.render(
	<Root history={browserHistory}/>, document.querySelector("#target")
);