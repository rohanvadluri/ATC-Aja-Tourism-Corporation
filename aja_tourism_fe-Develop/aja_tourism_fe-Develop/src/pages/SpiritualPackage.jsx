import Navbar from "../components/Navbar";
import "../styles/Childrens.css";
import React from "react";
//import "./Packages.css";
import { useNavigate } from "react-router-dom";
import spiritualpack from "../assets/spiritualpack.png";
import spiritual1 from "../assets/spiritual1.png";
import spiritual2 from "../assets/spiritual2.png";
import spiritual3 from "../assets/spiritual3.png";
import spiritual4 from "../assets/spiritual4.png";

function SpiritualPackage() {
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
          Sri Kshetra Darshan – Hyderabad{" "}
          <span className="badge22">4 Days & 3 Nights</span>
        </h1>

        <p className="location22">
          📍 Temple Darshan – Sacred Aarti – Spiritual Heritage Sites – Final Prayers & Blessings | ⭐⭐⭐⭐⭐
        </p>

        <img
          src={spiritualpack}
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
              Price Starting From :<span className="new22"> ₹7499/-</span>
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
            Bhagyanagar Bhakti Yatra is a peaceful spiritual tour across Hyderabad, covering sacred temples and cultural heritage sites. The journey offers a calm, comfortable, and well-guided experience with safe travel, planned darshan, and quality stays—perfect for families and spiritual seekers looking for a refreshing devotional retreat.
          </p>
        </section>

        <section className="itinerary22">
          <h2>PACKAGE ITINERARY</h2>

          <div className="itinerary-grid22">
            <div className="day-card22">
              <img src={spiritual1} alt="Day 1" />
              <div>
                <span className="day22">Day 1</span>
                <h3>Arrival & Spiritual Welcome</h3>
                <p>
                  Arrival in Hyderabad, followed by temple visit and evening aarti. Relaxed check-in and overnight stay.
                </p>
              </div>
            </div>

            <div className="day-card22">
              <img src={spiritual2} alt="Day 2" />
              <div>
                <span className="day22">Day 2</span>
                <h3>Sacred Temples & Heritage</h3>
                <p>
                  Visit Birla Mandir, Chilkur Balaji Temple, and heritage spiritual sites. Guided darshan and peaceful evening.
                </p>
              </div>
            </div>

            <div className="day-card22">
              <img src={spiritual3} alt="Day 3" />
              <div>
                <span className="day22">Day 3</span>
                <h3>Pilgrimage & Cultural Experience</h3>
                <p>
                  Temple darshan, spiritual time, and visit to cultural landmarks. Leisure time for reflection and local shopping.
                </p>
              </div>
            </div>

            <div className="day-card22">
              <img src={spiritual4} alt="Day 4" />
              <div>
                <span className="day22">Day 4</span>
                <h3>Blessings & Departure</h3>
                <p>
                  Morning temple visit, final prayers, and departure with divine memories.
                </p>
              </div>
            </div>
          </div>
        </section>
      </div>
    </div>
  );
}

export default SpiritualPackage;
