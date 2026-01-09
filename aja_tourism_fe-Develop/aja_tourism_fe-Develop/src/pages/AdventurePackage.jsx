import Navbar from "../components/Navbar";
import "../styles/Childrens.css";
import React from "react";
//import "./Packages.css";
import { useNavigate } from "react-router-dom";

import adventurespack from "../assets/adventurespack.png";
import adventure1 from "../assets/adventure1.png";
import adventure2 from "../assets/adventure2.png";
import adventure3 from "../assets/adventure3.png";
import adventure4 from "../assets/adventure4.png";

function AdventurePackage() {
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
          🏞️ Thrill Trails – Hyderabad Adventure Escape{" "}
          <span className="badge22">4 Days & 3 Nights</span>
        </h1>

        <p className="location22">
          📍 Hill Trekking – Nature Trails – Rock Climbing – Adventure Parks – Wildlife Safari | ⭐⭐⭐⭐⭐
        </p>

        <img
          src={adventurespack}
          alt="Spiritual Package"
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
            Thrill Trails – Hyderabad Adventure Escape is designed for adventure lovers seeking excitement, nature, and unforgettable outdoor experiences. This 4-day package combines hill trekking, forest trails, lakeside activities, rock formations, and adventure parks, making it perfect for youngsters, friends, and thrill-seekers who want an energetic and refreshing getaway.
          </p>
        </section>

        <section className="itinerary22">
          <h2>PACKAGE ITINERARY</h2>

          <div className="itinerary-grid22">
            <div className="day-card22">
              <img src={adventure1} alt="Day 1" />
              <div>
                <span className="day22">Day 1</span>
                <h3>Arrival & City Adventure</h3>
                <p>
                  Arrival in Hyderabad followed by a visit to Durgam Cheruvu Lake for kayaking and lakeside walks. Enjoy the scenic views at Khajaguda Hills with light trekking and sunset photography. Overnight stay.
                </p>
              </div>
            </div>

            <div className="day-card22">
              <img src={adventure2} alt="Day 2" />
              <div>
                <span className="day22">Day 2</span>
                <h3>Hills, Trekking & Nature</h3>
                <p>
                  Early morning departure to Ananthagiri Hills. Enjoy forest trekking, camping-style activities, viewpoints, and nature trails. Spend time at Anantha Padmanabha Swamy Temple surroundings and relax amidst greenery.
                </p>
              </div>
            </div>

            <div className="day-card22">
              <img src={adventure3} alt="Day 3" />
              <div>
                <span className="day22">Day 3</span>
                <h3>Rock Climbing & Adventure Parks</h3>
                <p>
                  Visit Khajaguda Rock Formations for rock climbing and exploration, followed by a thrilling session at Mount Opera Theme Park / Ocean Park with adventure rides and water activities.
                </p>
              </div>
            </div>

            <div className="day-card22">
              <img src={adventure4} alt="Day 4" />
              <div>
                <span className="day22">Day 4</span>
                <h3>Wildlife & Departure</h3>
                <p>
                  Explore Nehru Zoological Park Safari or Mrugavani National Park for wildlife and nature trails. Departure with high-energy memories and adventure-filled experiences.
                </p>
              </div>
            </div>
          </div>
        </section>
      </div>
    </div>
  );
}

export default AdventurePackage;
