var React = require('react');
var Navbar = require('react-bootstrap/lib/Navbar');
var NavItem = require('react-bootstrap/lib/NavItem');
var MenuItem = require('react-bootstrap/lib/MenuItem');
var NavDropdown = require('react-bootstrap/lib/NavDropdown');
var Nav = require('react-bootstrap/lib/Nav');


class Header extends React.Component {
	render(){
		return (
		<Navbar>
            <Navbar.Header>
              <Navbar.Brand>
                <a href="#">Tweet Analysis</a>
              </Navbar.Brand>
            </Navbar.Header>
          </Navbar>
		)
	}
}

module.exports = Header;