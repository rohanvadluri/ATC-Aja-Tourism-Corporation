import Navbar from "../components/Navbar";
import "../styles/Childrens.css";
import React from "react";
//import "./Packages.css";
import { useNavigate } from "react-router-dom";
import studentspack from "../assets/studentspack.png";
import friends1 from "../assets/friends1.png";
import friends2 from "../assets/friends2.png";
import friends3 from "../assets/friends3.png";
import friends4 from "../assets/friends4.png";

function StudentsPackage() {
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
       🎓 Campus Quest – Hyderabad Student Tour{" "}
          <span className="badge22">4 Days & 3 Nights</span>
        </h1>

        <p className="location22">
          📍 Educational Tours – Science & Innovation Centers – Heritage & Culture Sites – Entertainment & Learning Experiences | ⭐⭐⭐⭐⭐
        </p>

        <img
          src={studentspack}
          alt="Students Package"
          className="hero-img22"
          style={{
    objectFit: "cover",
    objectPosition: "center 20%", // 👈 adjust 15%–30% as needed
    height: "750px",
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
         Campus Quest – Hyderabad Student Tour is a carefully designed educational and recreational trip that combines learning, exploration, and fun. The package includes science centers, heritage monuments, cultural sites, and entertainment hubs, making it ideal for school students, college groups, and educational institutions seeking a safe, informative, and enjoyable travel experience.
          </p>
        </section>

        <section className="itinerary22">
          <h2>PACKAGE ITINERARY</h2>

          <div className="itinerary-grid22">
            <div className="day-card22">
              <img src={friends1} alt="Day 1" />
              <div>
                <span className="day22">Day 1</span>
                <h3>City Orientation & Science Learning</h3>
                <p>
                  Arrival in Hyderabad followed by a visit to Birla Science Museum and Planetarium for interactive science learning. Evening leisure at Birla Mandir viewpoint and city orientation. Overnight stay.
                </p>
              </div>
            </div>

            <div className="day-card22">
              <img src={friends2} alt="Day 2" />
              <div>
                <span className="day22">Day 2</span>
                <h3>Innovation, Technology & Fun</h3>
                <p>
                 Visit Ramoji Film City to understand filmmaking, live sets, and creative production. Students gain exposure to media, creativity, and teamwork while enjoying guided attractions.
                </p>
              </div>
            </div>

            <div className="day-card22">
              <img src={friends3} alt="Day 3" />
              <div>
                <span className="day22">Day 3</span>
                <h3>History, Culture & Heritage</h3>
                <p>
                 Explore Golconda Fort and Chowmahalla Palace to learn about Hyderabad’s history and architecture. Later visit Salar Jung Museum for exposure to global art, culture, and antiques.
                </p>
              </div>
            </div>

            <div className="day-card22">
              <img src={friends4} alt="Day 4" />
              <div>
                <span className="day22">Day 4</span>
                <h3>Entertainment & Departure</h3>
                <p>
                 Enjoy a fun-filled day at Wonderla Amusement Park or Snow World, followed by departure with learning experiences, bonding, and unforgettable memories.
                </p>
              </div>
            </div>
          </div>
        </section>
      </div>
    </div>
  );
}


export default StudentsPackage;
