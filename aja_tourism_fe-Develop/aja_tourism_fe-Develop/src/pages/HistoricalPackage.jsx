import Navbar from "../components/Navbar";
import "../styles/Childrens.css";
import React from "react";
//import "./Packages.css";
import { useNavigate } from "react-router-dom";

import historicalpack from "../assets/historicalpack.jpg";
import historical1 from "../assets/historical1.webp";
import historical2 from "../assets/historical2.jpg";
import historical3 from "../assets/historical3.jpg";
import historical4 from "../assets/historical4.png";

function HistoricalPackage() {
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
          🏰 Heritage Trails – Historic Hyderabad Tour{" "}
          <span className="badge22">4 Days & 3 Nights</span>
        </h1>

        <p className="location22">
          📍 Royal Palace Visit – Heritage Architecture – Historic Legacy Experience – Departure & Memories | ⭐⭐⭐⭐⭐
        </p>

        {/* <img
          src={historicalpack}
          alt="Spiritual Package"
          className="hero-img22"
          style={{
    objectFit: "cover",
    objectPosition: "center 20%", // 👈 adjust 15%–30% as needed
    height: "800px",
    width: "100%"
  }} */}

  <img
  src={historicalpack}
  alt="Historical Package"
  className="hero-img22"
  style={{
    objectFit: "cover",
    objectPosition: "center 20%",
    height: "600px",
    width: "75%",        // 👈 reduced width
    margin: "0 auto",    // 👈 centers the image
    display: "block",
    borderRadius: "12px" // optional: premium look
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
            Heritage Trails – Historic Hyderabad Tour takes you through the rich legacy of the Nizams and the grandeur of the Deccan era. This 4-day journey covers iconic forts, royal palaces, world-famous museums, ancient markets, and architectural marvels, offering a deep cultural and historical experience ideal for families, students, and history lovers
          </p>
        </section>

        <section className="itinerary22">
          <h2>PACKAGE ITINERARY</h2>

          <div className="itinerary-grid22">
            <div className="day-card22">
              <img src={historical1} alt="Day 1" />
              <div>
                <span className="day22">Day 1</span>
                <h3>Royal Beginnings</h3>
                <p>
                  Arrival in Hyderabad followed by a visit to Charminar and Mecca Masjid. Explore the bustling lanes of Laad Bazaar and learn about the city’s origins. Overnight stay.
                </p>
              </div>
            </div>

            <div className="day-card22">
              <img src={historical2} alt="Day 2" />
              <div>
                <span className="day22">Day 2</span>
                <h3>Palaces & Museums</h3>
                <p>
                 Visit Chowmahalla Palace, the former seat of the Nizams, followed by Salar Jung Museum, home to one of the world’s largest antique collections. Evening leisure.
                </p>
              </div>
            </div>

            <div className="day-card22">
              <img src={historical3} alt="Day 3" />
              <div>
                <span className="day22">Day 3</span>
                <h3>Forts & Architectural Wonders</h3>
                <p>
                  Explore the majestic Golconda Fort, known for its acoustics and history. Continue to Qutb Shahi Tombs, showcasing Persian and Deccan architecture.
                </p>
              </div>
            </div>

            <div className="day-card22">
              <img src={historical4} alt="Day 4" />
              <div>
                <span className="day22">Day 4</span>
                <h3>Legacy & Departure</h3>
                <p>
                  Visit Falaknuma Palace (viewpoint or museum access) or Purani Haveli, followed by departure with a deeper understanding of Hyderabad’s royal past.
                </p>
              </div>
            </div>
          </div>
        </section>
      </div>
    </div>
  );
}


export default HistoricalPackage;
