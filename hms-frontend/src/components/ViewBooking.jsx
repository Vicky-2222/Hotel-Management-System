import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom';
import axios from 'axios';
import { Link } from 'react-router-dom';
import './ViewBooking.css'

function ViewBooking() {
    const [booking,setBooking] = useState([]);
    const [showConfirmation, setShowConfirmation] = useState(false);
    const {userId} = useParams();
    useEffect(() => {
        axios.get(`http://localhost:8080/Booking/userId/${userId}`)
        .then(response => {
            setBooking(response.data);
            console.log(response.data);
        })
    },[userId]);
    const handleDelete = (id)=>{
        console.log(id);
        axios.delete(`http://localhost:8080/Booking/delete/${id}`)
        .then(response => {
            console.log(response.data);
            window.location.reload();
        })
    }
  return (
    <div className="allbookingmain">
        <h1 className="bookingheading"> Booking History </h1>
        <div className="allbookingcards">
        { booking.length> 0 ? (
            booking.map( (booking,index) => (
                <div className="allbookingcard" key={index}>
                    <div className="card-body">
                        <h3>Booking {index +1}</h3>
                        <span>Booking Id : {booking.bookingId}</span><br></br>
                        <span>Status of Booking : {booking.bookingStatus}</span><br></br>
                        <span>Booked Time : {booking.bookedTime}</span><br></br>
                        <span>Booked Date : {booking.bookedDate}</span><br></br>
                        <span>Hotel Id : {booking.hotelId}</span><br></br>
                        <span>Hotel Name : {booking.hotelName}</span><br></br>
                        <span>Room Id : {booking.roomId}</span><br/>
                        <span>Room : {booking.roomType}</span><br></br>
                        <span>User Id : {booking.userId} </span><br></br>
                        <span>User Name : {booking.userName} </span><br></br>

                        <button className="danger" onClick={ () => setShowConfirmation(true)}>Cancel This Booking</button>
                        {showConfirmation && (
                            <div className="modal">
                                <div className = "modal-content">
                                    <p>Are you sure you want to Cancel The Ticket</p>
                                    <button onClick={() => handleDelete(booking.bookingId)}> Yes</button>
                                    <button onClick={() => setShowConfirmation(false)}>No</button>
                                </div>
                            </div>
                        )}
                    </div>
                </div>
                ))
           ) : (
            <p> User Doesnt Book Any Turf . Please Book One Turf To Check the Booked Turfs</p>
           )}
        </div><br/>
        <Link to ="/">
            <button className='bt'>Click Here To Go Home Page</button>
        </Link>
    </div>
   
  )
}
 
export default ViewBooking