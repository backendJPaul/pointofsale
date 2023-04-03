import {CategoryService} from "./modules/CategoryService.js";

const categoryService = new CategoryService("api/category/");
const search = window.location.search;
const urlSearchParams = new URLSearchParams(window.location.search);
async function initComponents(){
    const category = await categoryService.gotoId(urlSearchParams.get("idCategory"));
    document.getElementById("nameText").value = category.name;
}
initComponents();
async function update(){
    let category = {
        idCategory : urlSearchParams.get("idCategory"),
        name : document.getElementById("nameText").value
    }
    await categoryService.update(category);
    window.location = "../category.html";
}
saveButton.addEventListener("click", update);