const productsContainer = document.getElementsByClassName("products-container")[0];

let array = localStorage.getItem("products") ? JSON.parse(localStorage.getItem("products")) : [];

window.addEventListener("load", getProducts());

async function getProducts() {
    const token = JSON.parse(localStorage.getItem("token"));
    
    if(token != null) {
    const response = await fetch("http://localhost:8080/api/trendora/products", {
        method: "GET",
        headers: {
            "Authorization": `Bearer ${token.token}`
        }
    });

    const data = await response.json();

    console.log(data);

    localStorage.setItem("products", JSON.stringify(data));
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

}