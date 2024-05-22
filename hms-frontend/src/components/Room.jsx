import React from 'react';
import { useState , useEffect } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import { Link } from 'react-router-dom';
import './Room.css'

function Room() {
    const [rooms ,setRooms]  = useState([]);
    const { hotelId } = useParams();
 
    useEffect(()=>{
        axios.get(`http://localhost:8080/Room/getall/HotelId/${hotelId}`)
        .then(response => {
            setRooms(response.data);
        })
        .catch(error => {
            console.error('Error in Fetching the rooms by hotel id', error);
        });
    },[hotelId]);
  return (
    <div className="roomsmain">
        <h1 className="roomList">Available Rooms For Selected hotel</h1>
        <div className ="rooms-cards">
            {rooms.map(room => ( 
            <div className = "rooms-card" key={room.roomId}>
                <span>{room.roomType}</span><br></br>
                <span> Price : {room.amount}</span><br></br>
                {/* <h4> Availablility  : {room.available ? "Available":"NotAvailable"}</h4><br></br> */}
                {room.available ? (
                <Link to={`roomId/${room.roomId}`}>
                    <button>Select the Room</button>
                </Link>
                ) : (
                <button onClick={ () => alert("Not available for booking. The selected timeslot is already booked . please choose another timeSlot")}>Not available</button>
                )}
            </div>))}
        </div>
    </div>
  )
}
 
export default Room