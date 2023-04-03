let saveModal = document.getElementById("saveModal");
let editModal = document.getElementById("editModal")

let saveButton = document.getElementById("saveButton");
saveButton.addEventListener("click", saveButtonHandlerClick);
function saveButtonHandlerClick() {
    saveModal.style.display = "block";
}

let closeSaveButton = document.getElementById("closeSaveButton");
let closeEditButton = document.getElementById("closeEditButton");

closeSaveButton.addEventListener("click",closeButton);
closeEditButton.addEventListener("click",closeButton);

function closeButton() {
    saveModal.style.display = "none";
    editModal.style.display = "none"
    location.reload();
}
