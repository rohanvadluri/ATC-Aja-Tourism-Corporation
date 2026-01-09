import Navbar from "../components/Navbar";
import "../styles/Childrens.css";
import React from "react";
//import "./Packages.css";
import { useNavigate } from "react-router-dom";
import couplepack from "../assets/couplepack.png";
import couple1 from "../assets/couple1.png";
import couple2 from "../assets/couple2.png";
import couple3 from "../assets/couple3.png";
import couple4 from "../assets/couple4.png";

function CouplePackage() {
    
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
       💑 Romantic Escape – Hyderabad Couple Tour{" "}
          <span className="badge22">4 Days & 3 Nights</span>
        </h1>

        <p className="location22">
          📍 City Hangouts – Adventure Parks – Heritage Spots – Cafes, Shopping & Night Vibes | ⭐⭐⭐⭐⭐
        </p>

        <img
          src={couplepack}
          alt="Spiritual Package"
          className="hero-img22"
          style={{
    objectFit: "cover",
    objectPosition: "center 20%", // 👈 adjust 15%–30% as needed
    height: "600px",
    width: "80%"
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
              {/* <p>
                🧒 Children : <strong>₹5999/-</strong>
              </p> */}
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
            Romantic Escape – Hyderabad is a specially curated tour for couples seeking quality time, romance, and memorable experiences together. The package blends scenic views, heritage charm, cozy cafes, shopping, and leisure attractions, making it ideal for newlyweds, honeymooners, and couples looking for a relaxed city getaway.
          </p>
        </section>

        <section className="itinerary22">
          <h2>PACKAGE ITINERARY</h2>

          <div className="itinerary-grid22">
            <div className="day-card22">
              <img src={couple1} alt="Day 1" />
              <div>
                <span className="day22">Day 1</span>
                <h3>Arrival & Romantic Evenings</h3>
                <p>
                  Arrival in Hyderabad followed by a peaceful visit to Hussain Sagar Lake and Lumbini Park. Enjoy a romantic sunset walk at Necklace Road and dinner with lake views. Overnight stay.
                </p>
              </div>
            </div>

            <div className="day-card22">
              <img src={couple2} alt="Day 2" />
              <div>
                <span className="day22">Day 2</span>
                <h3>Fun, Laughter & Bonding</h3>
                <p>
                 Spend the day together at Wonderla Amusement Park, enjoying thrilling rides and water attractions. Continue the fun at Snow World, creating joyful couple moments.
                </p>
              </div>
            </div>

            <div className="day-card22">
              <img src={couple3} alt="Day 3" />
              <div>
                <span className="day22">Day 3</span>
                <h3>Heritage, Cafes & Shopping</h3>
                <p>
                  Explore Golconda Fort and Chowmahalla Palace for heritage and scenic views. Later, enjoy couple shopping at Laad Bazaar and relax at cozy cafes in Jubilee Hills or Gachibowli.
                </p>
              </div>
            </div>

            <div className="day-card22">
              <img src={couple4} alt="Day 4" />
              <div>
                <span className="day22">Day 4</span>
                <h3>Grand Experience & Departure</h3>
                <p>
                  Visit Ramoji Film City for beautiful gardens, romantic photo spots, and movie-themed attractions, or enjoy a relaxed shopping experience at Inorbit Mall before departure.
                </p>
              </div>
            </div>
          </div>
        </section>
      </div>
    </div>
  );
}

export default CouplePackage;
