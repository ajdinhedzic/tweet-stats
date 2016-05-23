var React = require('react');
var ReactDOM = require('react-dom');
var Header = require('./Header');
var SearchBar = require('./SearchBar');

class Hello extends React.Component {
	render(){
		return (
			<div>
				<Header/>
				<SearchBar/>
			</div>
		)
	}
}

ReactDOM.render(
    <Hello />,
    window.document.querySelector("#target")
);