import {CategoryService} from "./modules/CategoryService.js";

let categoryService = new CategoryService("api/category/");

async function save(){
    let category = {
        name: document.getElementById("nameText").value
    }
    await categoryService.save(category);
    window.location = "category.html";
}

let saveButton = document.getElementById("saveButton");
saveButton.addEventListener("click", save);

