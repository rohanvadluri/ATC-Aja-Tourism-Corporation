import React, { useState, useEffect, useMemo } from "react";
import { useNavigate } from "react-router-dom";
import "./Bookings.css";
//import logo from "../assets/logo2.png";

const Bookings = () => {
  const navigate = useNavigate();

  const [userId, setUserId] = useState("");
  const [packageId, setPackageId] = useState("");
  const [travelDate, setTravelDate] = useState("");
  const [adults, setAdults] = useState(0);
  const [children, setChildren] = useState(0);
  const [hotelStar, setHotelStar] = useState("");
  const [mealsIncluded, setMealsIncluded] = useState(false);

  const [errors, setErrors] = useState({});

  /* ================= Load Razorpay ================= */
  useEffect(() => {
    if (window.Razorpay) return;

    const script = document.createElement("script");
    script.src = "https://checkout.razorpay.com/v1/checkout.js";
    script.async = true;
    document.body.appendChild(script);

    return () => document.body.removeChild(script);
  }, []);

  /* ================= Amount Calculation (NO setState) ================= */
  const { adultAmount, childAmount, totalAmount } = useMemo(() => {
    let adultPrice = 2500;
    let childPrice = 1000;
    let total = 0;

    if (hotelStar && adults > 0) {
      const starPrice =
        hotelStar === "3" ? 2000 : hotelStar === "4" ? 3000 : 4000;

      const mealPrice = mealsIncluded ? 500 : 0;

      adultPrice = starPrice + mealPrice;
      childPrice = Math.floor(adultPrice / 2);

      total = adults * adultPrice + children * childPrice;
    }

    return {
      adultAmount: adultPrice,
      childAmount: childPrice,
      totalAmount: total,
    };
  }, [adults, children, hotelStar, mealsIncluded]);

  /* ================= Validation ================= */
  const validateForm = () => {
    const newErrors = {};

    if (!userId.trim()) newErrors.userId = "User ID is required";
    if (!packageId.trim()) newErrors.packageId = "Package ID is required";

    if (!travelDate) {
      newErrors.travelDate = "Travel date is required";
    } else if (new Date(travelDate) < new Date().setHours(0, 0, 0, 0)) {
      newErrors.travelDate = "Travel date cannot be in the past";
    }

    if (!hotelStar) newErrors.hotelStar = "Select hotel category";
    if (totalAmount <= 0) newErrors.amount = "Invalid amount";

    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  /* ================= Razorpay Payment ================= */
  const openRazorpay = () => {
    if (!window.Razorpay) {
      alert("Razorpay not loaded");
      return;
    }

    const rzp = new window.Razorpay({
      key: "rzp_test_B9S8hmIWzP4YGf",
      amount: totalAmount * 100,
      currency: "INR",
      name: "AJA CORPORATION LIMITED",
      description: "Tour Booking Payment",
      image: `${window.location.origin}/logo2.png`,

      handler: function () {
        alert("✅ Payment Successful!");
        navigate("/", { replace: true });
      },

      prefill: {
        email: "manish@test.com",
        contact: "7205294038",
      },

      theme: {
        color: "#0d6efd",
      },
    });

    rzp.open();
  };

  /* ================= Submit ================= */
  const handleSubmit = (e) => {
    e.preventDefault();
    if (!validateForm()) return;
    openRazorpay();
  };

  return (
    <div className="booking-page">
      <div className="booking-bg">
        <div className="container">
          <div className="card shadow mx-auto booking-card">
            <div className="card-header bg-primary text-white">
              <h4>My Booking</h4>
            </div>

            <div className="card-body">
              <form onSubmit={handleSubmit} noValidate>
                <input
                  type="text"
                  className={`form-control mb-3 ${
                    errors.userId ? "is-invalid" : ""
                  }`}
                  placeholder="User ID"
                  value={userId}
                  onChange={(e) => setUserId(e.target.value)}
                />

                <input
                  type="text"
                  className={`form-control mb-3 ${
                    errors.packageId ? "is-invalid" : ""
                  }`}
                  placeholder="Package ID"
                  value={packageId}
                  onChange={(e) => setPackageId(e.target.value)}
                />

                <p>Travelling date</p>
                <input
                  type="date"
                  className={`form-control mb-3 ${
                    errors.travelDate ? "is-invalid" : ""
                  }`}
                  value={travelDate}
                  onChange={(e) => setTravelDate(e.target.value)}
                />

                {/* ADULTS */}
                <p className="label">Adults</p>
                <div className="counter">
                  <button type="button" onClick={() => setAdults(adults + 1)}>
                    +
                  </button>
                  <span>{adults}</span>
                  <button
                    type="button"
                    onClick={() => setAdults(Math.max(0, adults - 1))}
                  >
                    -
                  </button>
                </div>

                <p className="note">Note: Children must be below 10 years</p>

                {/* CHILDREN */}
                <p className="label">Children</p>
                <div className="counter">
                  <button type="button" onClick={() => setChildren(children + 1)}>
                    +
                  </button>
                  <span>{children}</span>
                  <button
                    type="button"
                    onClick={() => setChildren(Math.max(0, children - 1))}
                  >
                    -
                  </button>
                </div>
                 <p className="label">Hotel Type</p>
                <div className="mt-3">
                  {["3", "4", "5"].map((star) => (
                    <label key={star} className="me-3">
                      <input
                        type="radio"
                        checked={hotelStar === star}
                        onChange={() => setHotelStar(star)}
                      />{" "}
                      {star} Star
                    </label>
                  ))}
                </div>

                <div className="mt-3">
                  <input
                    type="checkbox"
                    checked={mealsIncluded}
                    onChange={(e) => setMealsIncluded(e.target.checked)}
                  />{" "}
                  Meals (+₹500 per person)
                </div>

                <div className="mt-3 p-3 border rounded bg-light">
                  <p>
                    Adult Price / Person: <strong>₹ {adultAmount}</strong>
                  </p>
                  <p>
                    Child Price / Person: <strong>₹ {childAmount}</strong>
                  </p>
                  <hr />
                  <h5 className="text-success">
                    Total Amount: ₹ {totalAmount}
                  </h5>
                </div>

                <button type="submit" className="btn btn-success w-100 mt-3">
                  Proceed to Payment
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Bookings;
