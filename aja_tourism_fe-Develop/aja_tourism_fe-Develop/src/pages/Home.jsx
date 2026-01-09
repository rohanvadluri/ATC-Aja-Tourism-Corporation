import React from "react";
import "../styles/Home.css";
import Navbar from "../components/Navbar";
import HeroVideo from "../components/HeroVideo";
 import { useNavigate } from "react-router-dom";

const packages = [
  {
    title: "Heritage Package",
    img: "/Heritage.jpg",
    price: "₹9,999",
  },
  {
    title: "Family Package",
    img: "/Family.jpg",
    price: "₹12,499",
  },
  {
    title: "Student Package",
    img: "/Student.jpg",
    price: "₹15,999",
  },
];
 
const destinations = [
  {
    name: "Charminar",
    img: "/charminar.jpg",
  },
  {
    name: "Golconda Fort",
    img: "/golconda.jpg",
  },
  {
    name: "Hussain Sagar Lake",
    img: "/hussain.jpg",
  },
  {
    name: "Ramoji Film City",
    img: "/ramojii.jpg",
  },
];
 
const Home = () => {
  const navigate = useNavigate();
  return (
    <>
      <Navbar />
      <HeroVideo />
 
      {/* HERO SECTION */}
      <section className="home-hero">
        <div className="home-overlay">
          <div className="home-hero-content">
            <h1>Explore the Pearl City</h1>
            <h3>with AJA Tourism Corporation</h3>
            <p>Experience the beauty of the city</p>
            <button className="home-hero-btn"  onClick={() => navigate("/login")} >
              Get Started </button>
          </div>
        </div>
      </section>
 
      {/* TOP EXCLUSIVE PACKAGES */}
      <section className="home-section">
        <h2>Top Exclusive Packages</h2>
 
        <div className="home-package-grid">
          {packages.map((pkg, index) => (
            <div className="home-package-card" key={index}>
              <img src={pkg.img} alt={pkg.title} loading="lazy" />
              <div className="home-package-body">
                <h3>{pkg.title}</h3>
                <p>4 Days · Food · Guide</p>
                <span>{pkg.price}</span>
                <button onClick={() => navigate("/login")}> View Details
                </button>
              </div>
            </div>
          ))}
        </div>
      </section>
 
      {/* SERVICES */}
      <section className="home-section home-dark">
        <h2>Our Services</h2>
        <div className="home-service-grid">
          <div className="home-service-card">Customizable Tours</div>
          <div className="home-service-card">Hotel & Resorts</div>
          <div className="home-service-card">Transport Services</div>
          <div className="home-service-card">24/7 Support</div>
        </div>
      </section>
 
      {/* DESTINATIONS */}
      <section className="home-section">
        <h2>Top Destinations</h2>
 
        <div className="home-destination-grid">
          {destinations.map((place, index) => (
            <div className="home-destination-card" key={index}>
              <img src={place.img} alt={place.name} loading="lazy" />
              <div className="home-destination-name">{place.name}</div>
            </div>
          ))}
        </div>
      </section>
 
      {/* WHY US */}
      <section className="home-section home-dark">
        <h2>Why Book ATC Packages with Us</h2>
 
        <div className="home-why-grid">
          <div className="home-why-card">Experienced Guides</div>
          <div className="home-why-card">Best Price Guarantee</div>
          <div className="home-why-card">Personalized Itineraries</div>
          <div className="home-why-card">Customer Satisfaction</div>
        </div>
 
        <div className="home-center">
          <button className="home-primary-btn" onClick={() => navigate("/contact")} >  Get in Touch </button>
        </div>
      </section>
    </>
  );
};
 
export default Home;
