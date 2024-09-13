// Questo è un commento in JavaScript
console.log("Hello, world!");
document.addEventListener("DOMContentLoaded", function() {
    const modificaButton = document.getElementById("modificaButton");
    const myForm = document.getElementById("myForm");

    modificaButton.addEventListener("click", function() {
        if (myForm.style.display === "none") {
            myForm.style.display = "block";
        } else {
            myForm.style.display = "none";
        }
    });
});
