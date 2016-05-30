var React = require('react');
var ReactDOM = require('react-dom');
var {Router, Route} = require('react-router');
var Index = require('./Index')

const routes = {
	path: '/',
	component: Index
} 

ReactDOM.render(<Router routes={routes} />, document.querySelector("#target")
);