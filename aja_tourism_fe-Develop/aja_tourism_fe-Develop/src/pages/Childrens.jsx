// import React, { useState } from "react";
import "../styles/Childrens.css";
import Navbar from "../components/Navbar";
 import { useNavigate } from "react-router-dom";
function Childrens() {
    const navigate = useNavigate();
//   const [hotel, setHotel] = useState("3");
const handleBook = (packageId) => {
    navigate("/bookings", {
      state: { packageId },
    });
  };

  return (
     <div className="childrens-page">
       <Navbar /> 
    <div className="package-container22">
      {/* HEADER */}
      <h1 className="title22">
        Amazing Bhagyanagar Tour{" "}
        <span className="badge22">4 Days & 3 Nights</span>
      </h1>
      <p className="location22">
        📍 Wonderla Amusement Park - Butterfly Park - Snow World | ⭐⭐⭐⭐⭐
      </p>
      {/* HERO IMAGE */}
      <img src="./images/childrenPackage.png" alt="Wonderla Package" className="hero-img22" />
      {/* PRICE & BOOK */}
      <div className="price-box22">
        <div>
          <p className="price22">
            Price Starting From :<span className="new22"> ₹7499/-</span>
            <span className="old22"> ₹9899/-</span>
          </p>
          <div className="price-breakup22">
            <p>
              👨 Adult : <strong>₹7499/-</strong>
            </p>
            <p>
              🧒 Children : <strong>₹5499/-</strong>
            </p>
          </div>
          <div className="icons22">
            <span>🛏️</span>
            <span>🍴</span>
            <span>🚗</span>
            <span>🔭</span>
          </div>
        </div>
        {/* BOOK NOW LINK */}
          <button className="book-btn22" onClick={() => handleBook(1)} > BOOK NOW </button>
      </div>
    
      {/* OVERVIEW */}
      <section className="overview22">
        <h2>Overview</h2>
        <p>
          This Children’s Special Hyderabad Tour is designed to offer a perfect
          mix of fun, learning, and relaxation for kids and families. The
          package covers Wonderla Amusement Park, Ramoji Film City, Nehru
          Zoological Park, Snow World, and interactive science centers. Each day
          is planned with comfortable travel time, safe activities, and engaging
          experiences that keep children entertained while allowing parents to
          relax.
        </p>
      </section>
      {/* ITINERARY */}
      <section className="itinerary22">
        <h2>PACKAGE ITINERARY</h2>
        <div className="itinerary-grid22">
          <div className="day-card22">
            <img src="./images/day1.webp" alt="Day 1" />
            <div>
              <span className="day22">Day 1</span>
              <h3>Arrival → Hyderabad City</h3>
              <p>
                Arrival at Hyderabad. Visit Birla Science Centre and Birla
                Mandir. Overnight stay.
              </p>
            </div>
          </div>
          <div className="day-card22">
            <img src="./images/day2.jpg" alt="Day 2" />
            <div>
              <span className="day22">Day 2</span>
              <h3>Hyderabad → Ramoji Film City</h3>
              <p>
                Full day visit to Ramoji Film City with shows and attractions.
              </p>
            </div>
          </div>
          <div className="day-card22">
            <img src="./images/day3.jpg" alt="Day 3" />
            <div>
              <span className="day22">Day 3</span>
              <h3>Zoo Park → Mir Alam</h3>
              <p>Visit Nehru Zoological Park and relax at Mir Alam Park.</p>
            </div>
          </div>
          <div className="day-card22">
            <img src="./images/day4.jpg" alt="Day 4" />
            <div>
              <span className="day22">Day 4</span>
              <h3>Wonderla → Snow World → Departure</h3>
              <p>
                Enjoy Wonderla rides, Snow World, Hussain Sagar boat ride and
                departure.
              </p>
            </div>
          </div>
        </div>
      </section>
    </div></div>
  );
}
export default Childrens;