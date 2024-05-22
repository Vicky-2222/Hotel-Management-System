import React from 'react'
import './BookingStatus.css';
import { useParams } from 'react-router-dom';
import { Link } from 'react-router-dom';


function BookingStatus() {
    const {userId} =  useParams();

  return (
    <>
    <div className="booking-status-container">
        <h1>Room Booked Successfully</h1>
        <p>Your Hotel is booked for your special day. Enjoy your Time here</p>
      <div className="Bookingsstatuscontainer">
          <Link to={`/Login/viewallbookings/${userId}`}>
            <button>Click Here To See Your Bookings</button>
          </Link><br/>
          <Link to ="/">
            <button>Click Here To Go Home Page</button>
          </Link>
      </div>
    </div>
    </>
  )
}

export default BookingStatus;