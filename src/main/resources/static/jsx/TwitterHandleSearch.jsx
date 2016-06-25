var React = require('react');
var SearchBar = require('./SearchBar');
var {Router, browserHistory} = require('react-router');

class TwitterHandleSearch extends React.Component {
	fetchSentimentAnalysisBy(twitterHandle){
		var request = new XMLHttpRequest();
		request.open('GET', twitterHandle + '/sentiment', true);

		request.onload = function() {
		  if (request.status >= 200 && request.status < 400) {
		    var resp = request.responseText;
		    console.log(resp);
		    browserHistory.push('analysis');
		  } else {
			console.log("error");
		  }
		};
		request.send();
	}

	render(){
		return (
			<SearchBar onChange={this.fetchSentimentAnalysisBy}/>
		)
	}
}

module.exports = TwitterHandleSearch