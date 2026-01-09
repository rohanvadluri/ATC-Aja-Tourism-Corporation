import Navbar from "../components/Navbar";
import "../styles/Childrens.css";
import React from "react";
//import "./Packages.css";
import { useNavigate } from "react-router-dom";

import friendspack from "../assets/friendspack.png";
import friends1 from "../assets/friends1.png";
import friends2 from "../assets/friends2.png";
import friends3 from "../assets/friends3.png";
import friends4 from "../assets/friends4.png";

function FriendsPackage() {
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
        Buddies Break – Hyderabad{" "}
          <span className="badge22">4 Days & 3 Nights</span>
        </h1>

        <p className="location22">
          📍 City Hangouts – Adventure Parks – Heritage Spots – Cafes, Shopping & Night Vibes | ⭐⭐⭐⭐⭐
        </p>

        <img
          src={friendspack}
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
            Hyderabad Friends Escape is a fun-packed city experience designed for friends who love adventure, nightlife, sightseeing, and memorable moments together. The tour blends entertainment spots, iconic landmarks, cafes, shopping streets, and relaxed hangouts—perfect for college friends, working professionals, and travel squads..
          </p>
        </section>

        <section className="itinerary22">
          <h2>PACKAGE ITINERARY</h2>

          <div className="itinerary-grid22">
            <div className="day-card22">
              <img src={friends1} alt="Day 1" />
              <div>
                <span className="day22">Day 1</span>
                <h3>Arrival & Night Vibes</h3>
                <p>
                  Arrival in Hyderabad followed by a visit to Hussain Sagar Lake and Lumbini Park. Enjoy sunset views at Necklace Road and night hangouts at Durgam Cheruvu Bridge. Overnight stay.
                </p>
              </div>
            </div>

            <div className="day-card22">
              <img src={friends2} alt="Day 2" />
              <div>
                <span className="day22">Day 2</span>
                <h3>Thrill & Entertainment Day</h3>
                <p>
                 Spend the day at Wonderla Amusement Park enjoying high-energy rides and water attractions, followed by indoor snow fun at Snow World.
                </p>
              </div>
            </div>

            <div className="day-card22">
              <img src={friends3} alt="Day 3" />
              <div>
                <span className="day22">Day 3</span>
                <h3>Heritage, Cafes & Shopping Fun</h3>
                <p>
                  Explore Golconda Fort and Chowmahalla Palace, then enjoy shopping at Laad Bazaar. End the day with cafe hopping in Jubilee Hills or Gachibowli.
                </p>
              </div>
            </div>

            <div className="day-card22">
              <img src={friends4} alt="Day 4" />
              <div>
                <span className="day22">Day 4</span>
                <h3>Grand Experience & Departure</h3>
                <p>
                  Visit Ramoji Film City for studios, gardens, and photo spots, or enjoy mall time at Inorbit Mall before departure with epic memories.
                </p>
              </div>
            </div>
          </div>
        </section>
      </div>
    </div>
  );
}



export default FriendsPackage;
