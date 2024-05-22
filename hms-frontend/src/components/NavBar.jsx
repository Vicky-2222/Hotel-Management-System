import React from "react";
import "./NavBar.css";

const NavBar = () => {
    return(
        <>
            <header className="header">
                <h1 className="logo">My Hotel Booking site </h1>
                <div className="nav">
                    <a href="/">Home</a>
                    <a href="/hotels">View Hotels</a>
                    <a href="/Login">View Your Bookings</a>
                </div>
            </header>
        </>
    );
};

export default NavBar;