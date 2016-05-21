var React = require('react');
var ReactDOM = require('react-dom');
var Header = require('./Header');

class Hello extends React.Component {
	render(){
		return (
			<Header/>
		)
	}
}

ReactDOM.render(
    <Hello />,
    window.document.querySelector("#target")
);