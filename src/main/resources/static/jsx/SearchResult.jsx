var React = require('react');
var Header = require('./Header');

class SearchResult extends React.Component {
	render(){
		return (
			<div>
				<Header/>
				<p>Changed</p>
			</div>
		)
	}
}

module.exports = SearchResult;
