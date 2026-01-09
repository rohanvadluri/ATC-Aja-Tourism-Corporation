import Navbar from "../components/Navbar";
import React from "react";
//import "./Packages.css";
import { useNavigate } from "react-router-dom";

import familypack from "../assets/familypack.png";
import fam1 from "../assets/fam1.png";
import fam2 from "../assets/fam2.png";
import fam3 from "../assets/fam3.png";
import fam4 from "../assets/fam4.png";
 function FamilyPackage() {
  const navigate = useNavigate();
  const handleBook = (packageId) => {
    navigate("/bookings", {
      state: { packageId },
    });
  };
  return (
    <div className="childrens-page">
       <Navbar /> 
      <div className="package-container22">
        <h1 className="title22">
          Hyderabad Family Delight{" "}
          <span className="badge22">4 Days & 3 Nights</span>
        </h1>

        <p className="location22">
          📍 City Sightseeing – Fun & Adventure Parks – Heritage Landmarks – Shopping & Leisure Experiences | ⭐⭐⭐⭐⭐
        </p>

        <img
          src={familypack}
          alt="Family Package"
          className="hero-img22"
          style={{
    objectFit: "cover",
    objectPosition: "center 20%", // 👈 adjust 15%–30% as needed
    height: "600px",
    width: "75%"
  }}
        />

        <div className="price-box22">
          <div>
            <p className="price22">
              Price Starting From :<span className="new22"> ₹8999/-</span>
              <span className="old22"> ₹9899/-</span>
            </p>

            <div className="price-breakup22">
              <p>
                👨 Adult : <strong>₹8999/-</strong>
              </p>
              <p>
                🧒 Children : <strong>₹5999/-</strong>
              </p>
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
            Hyderabad Family Delight is a well-balanced tour designed for families to enjoy fun attractions, sightseeing, relaxation, and quality time together. The package includes amusement parks, nature spots, iconic landmarks, and leisure experiences, making it ideal for parents, children, and elders.
          </p>
        </section>

        <section className="itinerary22">
          <h2>PACKAGE ITINERARY</h2>

          <div className="itinerary-grid22">
            <div className="day-card22">
              <img src={fam1} alt="Day 1" />
              <div>
                <span className="day22">Day 1</span>
                <h3>City Leisure</h3>
                <p>
                  Start your family tour with a relaxing visit to Hussain Sagar Lake and Lumbini Park, followed by an evening stroll at Necklace Road.
                </p>
              </div>
            </div>

            <div className="day-card22">
              <img src={fam2} alt="Day 2" />
              <div>
                <span className="day22">Day 2</span>
                <h3>Fun & Entertainment</h3>
                <p>
                  Enjoy a full day at Wonderla Amusement Park and Snow World, filled with exciting rides and snow activities for all age groups.
                </p>
              </div>
            </div>

            <div className="day-card22">
              <img src={fam3} alt="Day 3" />
              <div>
                <span className="day22">Day 3</span>
                <h3>Heritage & Shopping</h3>
                <p>
                  Visit Chowmahalla Palace and Salar Jung Museum, then spend time shopping at Laad Bazaar for local souvenirs.
                </p>
              </div>
            </div>

            <div className="day-card22">
              <img src={fam4} alt="Day 4" />
              <div>
                <span className="day22">Day 4</span>
                <h3>Grand Finale</h3>
                <p>
                  Explore Ramoji Film City or Nehru Zoological Park before departure, ending the trip with joyful family memories.
                </p>
              </div>
            </div>
          </div>
        </section>
      </div>
    </div>
  );
}

export default FamilyPackage;
