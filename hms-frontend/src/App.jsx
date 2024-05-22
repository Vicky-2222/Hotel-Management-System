import React from 'react';
import HomePage from './components/Homepage';
import {Route, Routes } from "react-router-dom";
import HotelList from "./components/HotelList";
import UserLogin from './components/UserLogin';
import NavBar from './components/NavBar';
import CreateAccount from './components/CreateAccount';
import Room from './components/Room';
import ViewBooking from './components/ViewBooking';
import LoginToBook from './components/LoginToBook';
import Booking from './components/Booking';
import BookingStatus from './components/BookingStatus';



const App = () => {
  return (
    <>
      <NavBar/>
      <Routes>
          <Route  path="/" element={<HomePage/>} />
          <Route path="/Login" element={<UserLogin/>} />
          <Route path="/Login/viewallbookings/:userId" element={<ViewBooking/>} />
          <Route path="/CreateAccount" element={<CreateAccount/>} />
          <Route path="/hotels" element={<HotelList/>} />
          <Route path="/hotelid/:hotelId/all/rooms" element={<Room/>} />
          <Route path="/hotelid/:hotelId/all/rooms/roomId/:roomId" element={<LoginToBook/>} />
          <Route path="/hotelid/:hotelId/all/rooms/roomId/:roomId/userId/:userId/booking" element={<Booking/>} />
          <Route path="/hotelid/:hotelId/all/rooms/roomId/:roomId/userId/:userId/booking/bookingStatus" element={<BookingStatus/>} />
          
      </Routes>
      <footer className="footer">
        <p>© 2024 My Hotel. All rights reserved.</p>
      </footer>
    </>
  );
};

export default App;

