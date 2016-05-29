var React = require('react');
var ReactDOM = require('react-dom');
var Header = require('./Header');
var TwitterHandleSearch = require('./TwitterHandleSearch');
var Router = require('react-router');
var Route = require('react-router');

class Hello extends React.Component {
	render(){
		return (
			<div>
				<Header/>
				<TwitterHandleSearch />
			</div>
		)
	}
}

ReactDOM.render(
    <Router>
		<Route path="/" component={Hello}>
    </Router>,
    window.document.querySelector("#target")
);