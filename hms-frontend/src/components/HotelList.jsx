import React from "react";
import { useEffect, useState } from 'react';
import axios from 'axios';
import "./HotelList.css";
import { Link } from "react-router-dom";

export default function HotelList() {
    const [hotel,setHotel] = useState([]);
 
    useEffect (()=>{
        axios.get(`http://localhost:8080/Hotel/get/all`)
        .then(response => {
            setHotel(response.data);
        })
        console.log(hotel);
    },[]);
    
    return (
        <div className="hotels">
            {/* <h1>List of all the hotel that are available</h1> */}
            <div>
                {hotel.map(hotel => ( 
                    <Link to={`/hotelid/${hotel.hotelId}/all/rooms`}>
                        <div className ="hotel-list"  key={hotel.hotelId}>
                            <img src={hotel.image} width={220} height={320}></img>
                            <h3>{hotel.hotelName}, {hotel.hotelLocation}</h3>
                        </div>
                    </Link>
                    ))}
            </div>
        </div>
    )
}