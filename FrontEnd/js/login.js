
//DOM connection of html to js
const loginUsername = document.getElementById("loginUsername");
const loginPassword = document.getElementById("loginPassword");
const loginBtn = document.getElementById("loginBtn");
const usernameError = document.getElementById("usernameError");
const passwordError = document.getElementById("passwordError");

//Receive the users data and throw it 
//in the backend 
loginBtn.addEventListener("click", async () => {

    let login = {
        username: loginUsername.value,
        password: loginPassword.value
    }

    console.log(login);

    //Send the users username and password and get the token
    const response = await fetch("http://localhost:8080/api/trendora/auth/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(login)
    });

    switch(response.status){
        case 200:
            const data = await response.json();
            localStorage.setItem("token", JSON.stringify(data));
            window.location.href = "home.html";
            break;
        case 403: 
            usernameError.textContent = "Username is incorrect";
            passwordError.textContent = "Password is incorrect";
            break;
        default:
    }    
});