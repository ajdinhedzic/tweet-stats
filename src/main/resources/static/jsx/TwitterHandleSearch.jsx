var React = require('react');
var SearchBar = require('./SearchBar');
var {Router, browserHistory} = require('react-router');

class TwitterHandleSearch extends React.Component {

	constructor(props){
		super(props);

		this.state = {
			responseText: ''
		};

		this.fetchSentimentAnalysisBy = this.fetchSentimentAnalysisBy.bind(this);
	}

	fetchSentimentAnalysisBy(twitterHandle){
		var request = new XMLHttpRequest();
		request.open('GET', twitterHandle + '/sentiment', true);

		request.onload = function() {
		  if (request.status >= 200 && request.status < 400) {
		    var resp = request.responseText;
				this.setState({responseText:resp});
		    console.log(this.state.responseText);
				browserHistory.push({
					pathname: 'analysis',
					state: { response: this.state.responseText }
				});
		  } else {
			console.log("error");
		  }
		}.bind(this);
		request.send();
	}

	render(){
		return (
			<SearchBar onChange={this.fetchSentimentAnalysisBy}/>
		)
	}
}

module.exports = TwitterHandleSearch