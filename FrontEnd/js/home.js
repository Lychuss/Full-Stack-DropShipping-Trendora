const productsContainer = document.getElementsByClassName("products-container")[0];
const shopsContainer = document.getElementsByClassName("shops-container")[0];

let array = localStorage.getItem("products") ? JSON.parse(localStorage.getItem("products")) : [];
let shops = localStorage.getItem("shops") ? JSON.parse(localStorage.getItem("shops")) : [];

window.addEventListener("DOMContentLoaded", getProducts());

async function getProducts() {
    const token = JSON.parse(localStorage.getItem("token"));

    console.log(token.token);
    
    if(token != null) {
    const response = await fetch("https://full-stack-dropshipping-trendora.onrender.com/api/trendora/products", {
        method: "GET",
        headers: {
            "Authorization": `Bearer ${token.token}`
        }
    });

    const shops = await fetch("https://full-stack-dropshipping-trendora.onrender.com/api/trendora/shops", {
        method: "GET",
        headers: {
            "Authorization": `Bearer ${token.token}`
        }
    });

    const data = await response.json();
    const partners = await shops.json();

    localStorage.setItem("products", JSON.stringify(data));
    localStorage.setItem("shops", JSON.stringify(partners));
  }

  for(const products of array){

        const shopProduct = document.createElement("div");
        shopProduct.classList.add("product-card");

        const image = document.createElement("img");
        image.src = products.image;
        image.alt = products.item;

        const name = document.createElement("h3");
        name.textContent = products.name;

        const description = document.createElement("p");
        description.textContent = products.description;

        const price = document.createElement("p");
        const icon = document.createElement("i");
        icon.className = "fa-solid fa-peso-sign";
        price.className = "price";
        price.appendChild(icon);
        price.appendChild(document.createTextNode(" " + products.price));

        const button = document.createElement("button");
        button.textContent = "Add to cart";
  
        shopProduct.append(
            image,
            name,
            description,
            price,
            button
        );

        productsContainer.appendChild(shopProduct);
  }

  for(const shops of shops){
        const shopPartner = document.createElement("div");
        shopProduct.classList.add("product-card");

        const image = document.createElement("img");
        image.src = shops.image;
        image.alt = shops.name;

        const name = document.createElement("h3");
        name.textContent = shops.name;

        const button = document.createElement("button");
        button.textContent = "Follow Shop";
  
        shopProduct.append(
            image,
            name,
            button
        );

        shopsContainer.appendChild(shopPartner);

  }
}