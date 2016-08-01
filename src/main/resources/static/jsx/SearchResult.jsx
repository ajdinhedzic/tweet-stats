var React = require('react');
var Header = require('./Header');
var ResultCategory = require('./ResultCategory');

class SearchResult extends React.Component {

	constructor(props){
		super(props);
		this.state = ({response: this.props.location.state.response});
	}

	render(){
		return (
			<div>
				<Header/>
				<p></p>
				<div className="col-sm-12">
					<div className="row">
						<div className="col-sm-4">
							<ResultCategory title='Positive' result={this.state.response.positive} />
						</div>
						<div className="col-sm-4">
							<ResultCategory title='Neutral' result={this.state.response.neutral} />
						</div>
						<div className="col-sm-4">
							<ResultCategory title='Negative' result={this.state.response.negative} />
						</div>
					</div>
				</div>
				</div>
		)
	}
}

module.exports = SearchResult;
