var React = require('react');
var ReactDOM = require('react-dom');
var {Router, Route, IndexRoute} = require('react-router');
var Index = require('./Index');
var SearchResult = require('./SearchResult');

class Root extends React.Component {

    render() {
        return (
            <Router history={this.props.history}>
                <Route path="/" component={Index}/>
                <Route path="analysis" component={SearchResult}/>
            </Router>
        )
    }
}

module.exports = Root;