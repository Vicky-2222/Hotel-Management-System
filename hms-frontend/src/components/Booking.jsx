import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import axios from 'axios';
import {Navigate} from 'react-router-dom';
import './Booking.css';

function Booking() {
    const {hotelId,roomId,userId} = useParams({});
    const [users , setUsers] = useState({});
    const [rooms,setrooms] = useState({});
    const [hotels, sethotels] = useState({});
    const navigator = useNavigate();

 useEffect (()=>{
    axios.get(`http://localhost:8080/Hotel/get/${hotelId}`)
    .then(response => {
      sethotels(response.data);
    }).catch(error => {
      console.log("hotel id is not found");
    })
 
    axios.get(`http://localhost:8080/Room/get/${roomId}`)
    .then(response => {
      setrooms(response.data)
    }).catch(error => {
      console.log("room id not found")
    })
 
    axios.get(`http://localhost:8080/User/get/${userId}`)
    .then(response=>{
      setUsers(response.data)
    }).catch(error => {
      console.log("User id is not found")
    })
 
  },[hotelId,roomId,userId]);
 
  const handlePostRequest = () => {
    axios.post(`http://localhost:8080/Booking/userId/${userId}/hotelId/${hotelId}/roomId/${roomId}`)
    .then(response =>{
      console.log(response.data)
      navigator(`bookingStatus`)
    }).catch(error =>{
      console.log('Error')
    });
  }
 
 
  return (
    <div className="Booking">
      <div className="BookingHeader">
        <h2>Book Your Ticket</h2>
        <h2>Your Selected hotel details are present below</h2>
      </div>
      <div className='Bookinglist'>
        <div className="Bookingcard">
          <span>Hotel Name : {hotels.hotelName}</span><br></br>
          <span>Hotel Location : {hotels.hotelLocation}</span><br></br>
          <span>Rooms : {rooms.roomType}</span><br></br>
          <span>Price Per Day For This rooms : {rooms.amount}</span><br></br>
          <span>User Id : {users.userId} </span><br></br>
          <span>User Name :{users.userName}</span><br></br>
          <br></br>
          <span className="money">Total To Be Paid : {rooms.amount}</span><br></br><br></br>
          <button onClick={handlePostRequest}>Book The hotel</button>
          <span></span>
        </div>
      </div>
    </div>
  )
}
 
export default Booking