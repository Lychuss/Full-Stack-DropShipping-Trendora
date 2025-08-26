const signupNickname = document.getElementById("signupNickname");
const signupUsername = document.getElementById("signupUsername");
const signupPassword = document.getElementById("signupPassword");
const signupBtn = document.getElementById("signupBtn");

//Receive the user data and throw it into the server 
//to get check if its available
signupBtn.addEventListener("click", async () => {
    let signup = {
        name: signupNickname.value,
        username: signupUsername.value,
        password: signupPassword.value
    }

    console.log(JSON.stringify(signup));

    const response = await fetch("https://full-stack-dropshipping-trendora.onrender.com/api/trendora/auth/signup", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(signup)
    });

    console.log(response.status);

    switch(response.status){
        case 200: 
            window.location.href = "login.html";
            break;
        case 400:
            signupUsername.setCustomValidity("Username is already taken!");
            signupUsername.reportValidity();
            break;
        default:
    }



});