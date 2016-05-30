var React = require('react');
var Header = require('./Header');
var TwitterHandleSearch = require('./TwitterHandleSearch');

class Index extends React.Component {
	render(){
		return (
			<div>
				<Header/>
				<TwitterHandleSearch />
			</div>
		)
	}
}

module.exports = Index