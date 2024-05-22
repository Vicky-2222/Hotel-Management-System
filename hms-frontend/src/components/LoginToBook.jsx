import React from 'react'
import axios from 'axios';
import { useState } from 'react'
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import "./UserLogin.css";
 
function LoginToBook() {
    const [email,setEmail] = useState('');
    const [password,setPassword] = useState('');
    const [error,setError] = useState('');
    const [authenticated, setAuthenticated] = useState(false);
    const navigator = useNavigate();
 
    const handleSubmit = async (e) => {
        e.preventDefault();
        try{
       const response= await axios.get(`http://localhost:8080/User/get/email/${email}`);
       console.log(response);
       const s = response;
 
       console.log(response.data.password);
       console.log(response.data.userId);

       if(response.data){
        if(response.data.password === password){
            setError('');
            setAuthenticated(true);
            navigator(`userId/${response.data.userId}/booking`)
        }else{
            setError('Invalid email or password');
            alert('Invalid password Please type correct password');
        }
       }else{
        setError('Invalid email or password');
        alert('Email is Not Present please register first')
       }
       
        } catch(error){
            console.log("Error");
        }
    };
 
   return (
    <div className='LoginPage'>
        <h2>Please login to make the booking</h2>
        <form className='Login' onSubmit={handleSubmit}>
            <div>
                <label>Email :  </label>
                <input type ="email" value={email} onChange={(e) => setEmail(e.target.value)} required></input>
            </div>
            <div>
                <label>password :  </label>
                <input type="password" value={password} onChange= {(e) => setPassword(e.target.value)} required></input>
            </div>
            <button type="submit">Login</button><br/><br/>
            <span>Not Having a account ? Please create a account here : </span>
            <Link to ="/CreateAccount"><button>Sign Up</button></Link>
        </form>
    </div>
  )
}
 
export default LoginToBook