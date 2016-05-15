var React = require('react');
var ReactDOM = require('react-dom');

class Hello extends React.Component {
	render(){
		return (
			<button className="btn btn-success">Hello World</button>
		)
	}
}

ReactDOM.render(
    <Hello />,
    window.document.querySelector("#target")
);