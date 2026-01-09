import Navbar from "../components/Navbar";
import "../styles/Childrens.css";
import React from "react";
//import "./Packages.css";
import { useNavigate } from "react-router-dom";

// images are inside src/components/images
import women from "../assets/women.png";
import womenday1 from "../assets/womenday1.png";
import womenday2 from "../assets/womenday2.png";
import womenday3 from "../assets/womenday3.png";
import womenday4 from "../assets/womenday4.png";
  
function WomenPackage() {
  const navigate = useNavigate();
  const handleBook = (packageId) => {
    navigate("/bookings", {
      state: { packageId },
    });
  };


  return (
    <div className="childrens-page">
      <div className="package-container22">

        <h1 className="title22">
          Queen’s Trail Hyderabad{" "}
          <span className="badge22">4 Days & 3 Nights</span>
        </h1>

        <p className="location22">
          A safe, joyful, and empowering journey designed exclusively for women.| ⭐⭐⭐⭐⭐
        </p>

        {/* <img
          src={women}
          alt="Wonderla Package"
          className="hero-img22"
        /> */}
        <img
                  src={women}
                  alt="Spiritual Package"
                  className="hero-img22"
                  style={{
            objectFit: "cover",
            objectPosition: "center 20%", // 👈 adjust 15%–30% as needed
            height: "700px",
            width: "75%"
          }}
/>
        <div className="price-box22">
          <div>
            <p className="price22">
              Price Starting From :
              <span className="new22"> ₹8999/-</span>
              <span className="old22"> ₹9899/-</span>
            </p>

            <div className="price-breakup22">
              <p>👨 Adult : <strong>₹8999/-</strong></p>
              <p>🧒 Children : <strong>₹5999/-</strong></p>
            </div>

            <div className="icons22">
              <span>🛏️</span>
              <span>🍴</span>
              <span>🚗</span>
              <span>🔭</span>
            </div>
          </div>

       <button className="book-btn22" onClick={() => handleBook(1)} > BOOK NOW </button>
        </div>

        <section className="overview22">
          <h2>Overview</h2>
          <p>
            This Women’s Special Hyderabad Tour is thoughtfully designed to offer a safe, empowering, and refreshing travel experience for women of all age groups. The itinerary includes cultural landmarks, leisure spots, shopping hubs, and relaxation activities, ensuring comfort, security, and memorable moments. The tour emphasizes safe accommodations, guided sightseeing, and flexible schedules, making it perfect for solo women travelers, friends, mothers, and working professionals seeking a stress-free getaway.
          </p>
        </section>

        <section className="itinerary22">
          <h2>PACKAGE ITINERARY</h2>

          <div className="itinerary-grid22">

            <div className="day-card22">
              <img src={womenday1} alt="Day 1" />
              <div>
                <span className="day22">Day 1</span>
                <h3>Arrival → City Highlights</h3>
                <p>Arrival at Hyderabad followed by a peaceful visit to Hussain Sagar Lake, Necklace Road walk, and evening leisure time. Overnight stay.</p>
              </div>
            </div>

            <div className="day-card22">
              <img src={womenday2} alt="Day 2" />
              <div>
                <span className="day22">Day 2</span>
                <h3>Heritage & Culture Tour</h3>
                <p>Visit Charminar, Chowmahalla Palace, and Laad Bazaar for shopping and cultural exploration. Guided tour with safe transport.</p>
              </div>
            </div>

            <div className="day-card22">
              <img src={womenday3} alt="Day 3" />
              <div>
                <span className="day22">Day 3</span>
                <h3>Relaxation & Entertainment</h3>
                <p>Explore Ramoji Film City with shows, gardens, and interactive attractions designed for a fun and relaxed experience.</p>
              </div>
            </div>

            <div className="day-card22">
              <img src={womenday4} alt="Day 4" />
              <div>
                <span className="day22">Day 4</span>
                <h3>Leisure → Departure</h3>
                <p>Morning visit to Golconda Fort or Durgam Cheruvu, followed by departure with memorable experiences.</p>
              </div>
            </div>

          </div>
        </section>

      </div>
    </div>
  );
}


export default WomenPackage;
