import { NavLink } from "react-router-dom";
import { useState } from "react";
import "../styles/Navbar.css";
import logo from "../assets/logo2.png";

const Navbar = () => {
  const [open, setOpen] = useState(false);

  return ( 
    <nav className="nav-navbar">
      
      {/* LOGO LEFT */}
      <div className="nav-left">
        <img src={logo} alt="AJA Tourism Logo" className="nav-logo" />
        <span className="nav-logo-text">AJA Tourism Corporation</span>
      </div>

      {/* MENU RIGHT */}
      <ul className="nav-menu">
        <li><NavLink to="/" end>Home</NavLink></li>
        <li><NavLink to="/packages">Packages</NavLink></li>  
        <li><NavLink to="/gallery">Gallery</NavLink></li>
        <li><NavLink to="/testimonials">Testimonials</NavLink></li>
        <li><NavLink to="/contact">Contact Us</NavLink></li>
        <li><NavLink to="/about">About Us</NavLink></li>

        {/* LOGIN DROPDOWN */}
        <li className="nav-login-dropdown">
          <button
            className="nav-login-btn"
            onClick={() => setOpen(!open)}
          >
            Login ▾
          </button>

          {open && (
            <ul className="nav-dropdown-menu">
              <li><NavLink to="/login">User Login</NavLink></li>
              <li><NavLink to="/admin-login">Admin Login</NavLink></li>
            </ul>
          )}
        </li>
      </ul>
    </nav>
  );
};

export default Navbar;
