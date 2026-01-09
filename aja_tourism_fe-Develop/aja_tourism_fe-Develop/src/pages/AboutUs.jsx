import React from "react";
import "../styles/AboutUs.css";
import Navbar from "../components/Navbar";
 
 
const AboutUs = () => {
  const imgPath = "/src/assets/hyd.png";
 
  return (
    <>
    <Navbar/>
    <div className="aboutus">
 
      {/* HERO SECTION */}
      <section className="about-hero">
        <div className="hero-overlay">
          <div className="hero-content">
            <h1>About AJA Tourism Corporation </h1>
            <p>
              AJA Tourism Corporation is your gateway to exploring the incredible
              city of Hyderabad and beyond. We specialize in offering exclusive
              and customized travel packages that cater to your preferences,
              ensuring a memorable experience in the City of Pearls.
            </p>
            <button className="primary-btn">Learn More</button>
          </div>
        </div>
      </section>
 
    </div>
    </>
  );
};
 
export default AboutUs;