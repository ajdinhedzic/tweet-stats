var React = require('react');
var Header = require('./Header');

class SearchResult extends React.Component {

	constructor(props){
		super(props);
	}

	render(){
		return (
			<div>
				<Header/>
				<p>{this.props.location.state.response}</p>
			</div>
		)
	}
}

module.exports = SearchResult;
