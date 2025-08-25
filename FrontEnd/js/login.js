
//DOM connection of html to js
const loginUsername = document.getElementById("loginUsername");
const loginPassword = document.getElementById("loginPassword");
const loginBtn = document.getElementById("loginBtn");

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

    const data = await response.json();
    
    //Store the token
    localStorage.setItem("token", JSON.stringify(data));

    if(localStorage.getItem("token") != null){
        window.location.href = "home.html";
    }
});