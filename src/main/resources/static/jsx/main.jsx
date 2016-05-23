var React = require('react');
var ReactDOM = require('react-dom');
var Header = require('./Header');
var TwitterHandleSearch = require('./TwitterHandleSearch');

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
    <Hello />,
    window.document.querySelector("#target")
);