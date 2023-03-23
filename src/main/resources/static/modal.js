let openButton = document.getElementById("saveButton");
let closeButton = document.getElementById("closeButton");
let modalDiv = document.getElementById("saveModal");

openButton.addEventListener("click", showModal);
closeButton.addEventListener("click",closeButtonHandlerClick);

function showModal(){
    modalDiv.style.display = "block";

}

function closeButtonHandlerClick() {
    modalDiv.style.display = "none";
}
