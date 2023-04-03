import {CategoryService} from "./modules/CategoryService.js";
import {ModalCategory} from "./modules/ModalCategory";

const categoryService = new CategoryService("api/category/");
const modalCategory = new ModalCategory();

async function fetchCategory() {
    const categories = await categoryService.fFetch();
    const sectionDiv = document.getElementById("sectionDiv");

    for (let category of categories) {

        const categoryDiv = document.createElement("div")
        categoryDiv.className = "categoryDiv"

        const pId = document.createElement("p");
        pId.innerText = "Id: ";
        const spamId = document.createElement("spam")
        spamId.innerText = category.idCategory;
        pId.appendChild(spamId);

        const pName = document.createElement("p");
        pName.innerText = "Nombre: ";
        const spamName = document.createElement("spam")
        spamName.innerText = category.name;
        pName.appendChild(spamName);

        const updateButton = document.createElement("input");
        updateButton.setAttribute("type", "button");
        updateButton.setAttribute("value", "Actualizar");
        updateButton.setAttribute("id", "updateButton" + category.idCategory);
        updateButton.addEventListener("click", updateCategory);

        async function updateCategory() {
            //let _category = await categoryService.gotoId(category.idCategory);
            //categoryText.value = _category.name;
        }

        const deleteButton = document.createElement("input");
        deleteButton.setAttribute("type", "button");
        deleteButton.setAttribute("value", "Eliminar");

        categoryDiv.appendChild(pId);
        categoryDiv.appendChild(pName);
        categoryDiv.appendChild(updateButton);
        categoryDiv.appendChild(deleteButton);

        sectionDiv.appendChild(categoryDiv);
    }
}

await fetchCategory();

const categoryText = document.getElementById("categoryText");
const categoryButton = document.getElementById("categoryButton");

categoryButton.addEventListener("click", saveCategory);

async function saveCategory() {
    let _name = categoryText.value;
    let category = {
        name: _name
    }
    await categoryService.save(category);
    await fetchCategory();
}


