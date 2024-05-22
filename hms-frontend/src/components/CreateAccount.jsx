import React from 'react'
import axios from 'axios';
import { useState } from 'react'
import { useParams } from 'react-router-dom';
import { Navigate, useNavigate } from 'react-router-dom';
import './CreateAccount.css';

function CreateAccount() {
    const [userName, setUserName] = useState('');
    const [userNum, setUserNum] = useState('');
    const [address, setAddress] = useState('');
    const [age,setAge] = useState('');
    const [email,setEmail]  = useState('');
    const [password,setPassword] = useState('');
    const [error,setError] =useState('');
    const navigator = useNavigate();
 
    const handleSubmit = async(e)=>{
        e.preventDefault();
        try{
            const response = await axios.post(`http://localhost:8080/User/add`,
            {
                userName,
                userNum,
                address,
                age,
                email,
                password
            });
            alert("Account created successfully")
            navigator(`/Login`)
        }catch(error){
            setError('An Error while posting your details please try again ...')
        }
    };
 
  return (
    <div className='CreatePage'>
        <h1>Please SignUp With Your Values</h1>
        <form className='Create' onSubmit={handleSubmit}>
            <div>
                <label>Name : </label>
                <input type="text" placeholder='Enter your name' value={userName} onChange = {(e) => setUserName(e.target.value)} required></input>
            </div>
            <div>
                <label>Contact Number : </label>
                <input type="number" placeholder='Enter your number' value={userNum} onChange= {(e) => setUserNum(e.target.value)} required></input>
            </div>
            <div>
                <label>Address : </label>
                <input type="text" placeholder='Enter your address' value={address} onChange= {(e) => setAddress(e.target.value)} required></input>
            </div>
            <div>
                <label>Age : </label>
                <input type="number" placeholder='Enter your age' value={age} onChange= {(e) => setAge(e.target.value)} required></input>
            </div>
            <div>
                <label>Email : </label>
                <input type="email" placeholder='Enter your emailId' value= {email} onChange = {(e) => setEmail(e.target.value)} required></input>
            </div>
            <div>
                <label>Password : </label>
                <input type="password" placeholder='Enter a strong password' value={password} onChange={(e)=> setPassword(e.target.value)} required></input>
            </div>
            <button> Submit </button>
        </form>
    </div>
  )
 
}

export default CreateAccount