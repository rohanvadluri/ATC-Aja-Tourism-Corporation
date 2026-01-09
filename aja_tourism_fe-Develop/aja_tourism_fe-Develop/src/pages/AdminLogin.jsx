import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const AdminLogin = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const navigate = useNavigate();

const handleLogin = () => {
  if (username === "admin" && password === "admin") {
    navigate("/dashboard"); // ✅ redirect here
  } else {
    alert("Invalid Admin Credentials");
  }
};
  return (
    <>
     <style>{`
/* ================= BACKGROUND ================= */

.login-container {
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;

  background-image:
    linear-gradient(
      rgba(10, 20, 40, 0.75),
      rgba(10, 20, 40, 0.75)
    ),
    url("https://triptimeholidays.com/admin/image-of-tours/galleryimg/5154348Kerala%20Family%20Tour%20Package.jpg");

  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;

  font-family: "Segoe UI", Arial, Helvetica, sans-serif;
}

/* ================= LOGIN CARD ================= */

.login-box {
  width: 380px;
  padding: 35px 30px;
  border-radius: 14px;

  /* Glassmorphism */
  background: rgba(255, 255, 255, 0.92);
  backdrop-filter: blur(6px);

  box-shadow: 0 25px 60px rgba(0, 0, 0, 0.35);
  animation: fadeUp 0.6s ease;
}

/* Animation */
@keyframes fadeUp {
  from {
    opacity: 0;
    transform: translateY(15px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

/* ================= HEADING ================= */

.login-box h2 {
  text-align: center;
  margin-bottom: 25px;
  color: #0f172a;
  font-size: 26px;
  font-weight: 700;
  letter-spacing: 0.5px;
}

/* ================= INPUTS ================= */

.login-box input {
  width: 100%;
  padding: 12px 14px;
  margin-bottom: 18px;
  border: 1px solid #d1d5db;
  border-radius: 8px;
  font-size: 14px;
  background: #f9fafb;
  transition: border 0.3s ease, box-shadow 0.3s ease;
}

.login-box input:focus {
  outline: none;
  border-color: #2563eb;
  box-shadow: 0 0 0 3px rgba(37, 99, 235, 0.2);
}

/* ================= BUTTON ================= */

.login-box button {
  width: 100%;
  padding: 12px;
  margin-top: 8px;

  background: linear-gradient(135deg, #1e40af, #0f172a);
  border: none;
  color: #ffffff;

  font-size: 15px;
  font-weight: 600;
  border-radius: 8px;
  cursor: pointer;

  transition: transform 0.25s ease, box-shadow 0.25s ease;
}

.login-box button:hover {
  transform: translateY(-2px);
  box-shadow: 0 10px 25px rgba(15, 23, 42, 0.4);
}

/* ================= FOOT NOTE ================= */

.admin-note {
  text-align: center;
  margin-top: 16px;
  font-size: 12px;
  color: #6b7280;
  letter-spacing: 0.3px;
}
`}</style>


      <div className="login-container">
        <div className="login-box">
          <h2>Admin Login</h2>
          
        
          <input
            type="text"
            placeholder="Admin Username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />

          <input
            type="password"
            placeholder="Admin Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />

          <button onClick={handleLogin}>Login</button>
           
          <div className="admin-note">
            Authorized personnel only
          </div>
          
        </div>
      </div>
    </>
  );
};

export default AdminLogin;
