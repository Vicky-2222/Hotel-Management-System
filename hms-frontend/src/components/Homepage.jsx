import React from "react";
import { Link } from "react-router-dom";
import "./HomePage.css";

const HomePage = () => {
  return (
    <div className="container">
      <main className="intro">
        <h1>Welcome to My Hotel Booking Site </h1>
        <p>Your perfect getaway awaits!</p>
        <Link to="/hotels">
          <button className="cta-button">Explore More</button>
        </Link>
      </main>

      <section className="features">
        <div className="feature">
          <h2>Explore Our Rooms</h2>
          <p>Discover comfortable and stylish rooms for every traveler.</p>
        </div>

        <div className="feature">
          <h2>Relax by the Pool</h2>
          <p>Our serene pool area is perfect for unwinding after a day of adventure.</p>
        </div>
        
        <div className="feature">
          <h2>Exceptional Dining</h2>
          <p>Indulge in gourmet meals at our on-site restaurant.</p>
        </div>
      </section>
    </div>
  );
};

export default HomePage;