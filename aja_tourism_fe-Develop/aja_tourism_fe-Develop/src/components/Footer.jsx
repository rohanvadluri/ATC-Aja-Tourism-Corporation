import React from 'react';
import { Link } from 'react-router-dom';
import "../styles/Footer.css";

const Footer = () => {
  const currentYear = new Date().getFullYear();
 
  return (
    <footer className="footer">
      <div className="footer-container">
        {/* Company Info Section */}
        <div className="footer-section">
          <h3 className="footer-logo">AJA Tourism</h3>
          <p className="footer-description">
            Discover the world with us. Creating unforgettable travel experiences
            since 2020. Your journey, our passion.
          </p>
          <div className="social-links">
            <a href="https://facebook.com" target="_blank" rel="noopener noreferrer" aria-label="Facebook">
              <i className="social-icon">📘</i>
            </a>
            <a href="https://twitter.com" target="_blank" rel="noopener noreferrer" aria-label="Twitter">
              <i className="social-icon">🐦</i>
            </a>
            <a href="https://instagram.com" target="_blank" rel="noopener noreferrer" aria-label="Instagram">
              <i className="social-icon">📷</i>
            </a>
            <a href="https://linkedin.com" target="_blank" rel="noopener noreferrer" aria-label="LinkedIn">
              <i className="social-icon">💼</i>
            </a>
          </div>
        </div>
 
        {/* Quick Links Section */}
        <div className="footer-section">
          <h4 className="footer-heading">Quick Links</h4>
          <ul className="footer-links">
            <li><Link to="/">Home</Link></li>
            <li><Link to="/about">About Us</Link></li>
            <li><Link to="/packages">Packages</Link></li>
            <li><Link to="/testimonials">Testimonials</Link></li>
            <li><Link to="/contact">Contact</Link></li>
          </ul>
        </div>
 
        {/* Services Section */}
        <div className="footer-section">
          <h4 className="footer-heading">Our Services</h4>
          <ul className="footer-links">
            <li><Link to="/packages">Tour Packages</Link></li>
            <li><Link to="/packages">Hotel Booking</Link></li>
            <li><Link to="/packages">Flight Tickets</Link></li>
            <li><Link to="/packages">Travel Insurance</Link></li>
            <li><Link to="/packages">Custom Tours</Link></li>
          </ul>
        </div>
 
        {/* Contact Info Section */}
        <div className="footer-section">
          <h4 className="footer-heading">Contact Us</h4>
          <ul className="footer-contact">
            <li>
              <span className="contact-icon">📍</span>
              <span>Hyderabad, Telangana, India</span>
            </li>
            <li>
              <span className="contact-icon">📧</span>
              <span>info@ajatourism.com</span>
            </li>
            <li>
              <span className="contact-icon">📞</span>
              <span>+91 9876543210</span>
            </li>
            <li>
              <span className="contact-icon">🕐</span>
              <span>Mon - Sat: 9:00 AM - 6:00 PM</span>
            </li>
          </ul>
        </div>
      </div>
 
      {/* Bottom Bar */}
      <div className="footer-bottom">
        <div className="footer-bottom-content">
          <p>&copy; {currentYear} AJA Tourism. All rights reserved.</p>
          <div className="footer-bottom-links">
            <Link to="/privacy">Privacy Policy</Link>
            <span className="separator">|</span>
            <Link to="/terms">Terms & Conditions</Link>
            <span className="separator">|</span>
            <Link to="/refund">Refund Policy</Link>
          </div>
        </div>
      </div>
    </footer>
  );
};
 
export default Footer;