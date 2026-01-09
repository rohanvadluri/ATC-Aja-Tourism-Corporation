import React from "react";
import {
  PieChart,
  Pie,
  Cell,
  LineChart,
  Line,
  BarChart,
  Bar,
  XAxis,
  YAxis,
  Tooltip,
  Legend,
  ResponsiveContainer
} from "recharts";

import { FaClipboardList, FaUsers, FaRupeeSign, FaMapMarkerAlt } from "react-icons/fa";
import "./DashboardPage.css";

/* ---------- SAMPLE DATA ---------- */
const bookingData = [
  { name: "Jan", bookings: 40 },
  { name: "Feb", bookings: 55 },
  { name: "Mar", bookings: 70 },
  { name: "Apr", bookings: 60 },
  { name: "May", bookings: 90 }
];

const revenueData = [
  { name: "Packages", value: 400 },
  { name: "Hotels", value: 300 },
  { name: "Transport", value: 300 },
  { name: "Guides", value: 200 }
];

const customerData = [
  { name: "Hyderabad", customers: 120 },
  { name: "Delhi", customers: 90 },
  { name: "Mumbai", customers: 80 },
  { name: "Bangalore", customers: 70 }
];

const COLORS = ["#0088FE", "#00C49F", "#FFBB28", "#FF8042"];

const DashboardHome = () => {
  return (
    <div className="dashboard-home">

      {/* STATS CARDS */}
      <div className="stats-grid">
        <div className="stat-card">
          <FaClipboardList className="card-icon icon-booking" />
          <h3>Total Bookings</h3>
          <p>220</p>
        </div>

        <div className="stat-card">
          <FaUsers className="card-icon icon-customers" />
          <h3>Total Customers</h3>
          <p>210</p>
        </div>

        <div className="stat-card">
          <FaRupeeSign className="card-icon icon-revenue" />
          <h3>Revenue</h3>
          <p>₹4.8L</p>
        </div>

        <div className="stat-card">
          <FaMapMarkerAlt className="card-icon icon-location" />
          <h3>Destinations</h3>
          <p>18</p>
        </div>
      </div>

      {/* CHARTS */}
      <div className="charts-grid">

        {/* LINE CHART */}
        <div className="chart-box">
          <h3>Monthly Bookings</h3>
          <ResponsiveContainer width="100%" height={300}>
            <LineChart data={bookingData}>
              <XAxis dataKey="name" />
              <YAxis />
              <Tooltip />
              <Legend />
              <Line type="monotone" dataKey="bookings" stroke="#0b5ed7" strokeWidth={3}/>
            </LineChart>
          </ResponsiveContainer>
        </div>

        {/* BAR CHART */}
        <div className="chart-box">
          <h3>Customers by City</h3>
          <ResponsiveContainer width="100%" height={300}>
            <BarChart data={customerData}>
              <XAxis dataKey="name" />
              <YAxis />
              <Tooltip />
              <Legend />
              <Bar dataKey="customers" fill="#198754" />
            </BarChart>
          </ResponsiveContainer>
        </div>

        {/* PIE CHART */}
        <div className="chart-box">
          <h3>Revenue Sources</h3>
          <ResponsiveContainer width="100%" height={300}>
            <PieChart>
              <Pie
                data={revenueData}
                dataKey="value"
                nameKey="name"
                cx="50%"
                cy="50%"
                outerRadius={100}
                label
              >
                {revenueData.map((entry, index) => (
                  <Cell key={index} fill={COLORS[index % COLORS.length]} />
                ))}
              </Pie>
              <Tooltip />
            </PieChart>
          </ResponsiveContainer>
        </div>

      </div>
    </div>
  );
};

export default DashboardHome;
