var React = require('react');

class ResultCategory extends React.Component {

	constructor(props){
		super(props);
	}

	render(){
		return (
			<div>
				<h2>{this.props.title}</h2>
				<h3>{this.props.result}</h3>
			</div>
		)
	}
}

module.exports = ResultCategory;