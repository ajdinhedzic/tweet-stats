var React = require('react');
var FormControl = require('react-bootstrap/lib/FormControl');
var FormGroup = require('react-bootstrap/lib/FormGroup');
var ControlLabel = require('react-bootstrap/lib/ControlLabel');
var Button = require('react-bootstrap/lib/Button');


class SearchBar extends React.Component {
	constructor(props){
		super(props);

		this.state = {
			value: ''
		};
	}

	handleChange(e){
		this.setState({value: e.target.value});
	}

	render(){
		return (
			<form className="col-md-6 col-md-offset-3">
				<div className="row">
					<FormGroup>
						<ControlLabel>Enter a twittername</ControlLabel>
						<FormControl 
							type="text"
							value={this.state.value}
							placeholder="Enter twitter handle"
							onChange={this.handleChange}
						/>
					</FormGroup>
				</div>
				<div className="row text-center">
					<Button 
						type="submit" 
						bsSize="lg" 
						bsStyle="success">
							Search
					</Button>
				</div>
			</form>
		)
	}
}

module.exports = SearchBar;