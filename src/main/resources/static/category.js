import {CategoryService} from "./modules/CategoryService.js";
const categoryService = new CategoryService("api/category/");

let categories = await categoryService.fFetch();

let containerDiv = document.getElementById("containerDiv");

let _idCategory;

function update() {
    window.location = "category_update.html?idCategory=" + _idCategory;
}

async function del(_idCategory){
    console.log(_idCategory);
    let category = {
        idCatalogStatus : 2,
        idCategory : _idCategory
    }
    await categoryService.delete(category);
    window.location = "category.html";
}
for(let category of categories){``
    let categoryDiv = document.createElement("div");
    categoryDiv.setAttribute("class","categoryDiv");

    let image = document.createElement("img");
    image.setAttribute("src","#");

    let id = document.createElement("h2");
    id.innerText = category.idCategory;

    let name = document.createElement("h1");
    name.innerText = category.name;

    let updateButton = document.createElement("a");
    //updateButton.setAttribute("href","category_update.html");
    updateButton.innerText = "Update";
    updateButton.addEventListener("click",() => {
        window.location = "category_update.html?idCategory=" + category.idCategory;
    });
    let delButton = document.createElement("a");
    delButton.innerText = "Delete";
    delButton.addEventListener("click", () =>{
        del(category.idCategory);
    });

    categoryDiv.appendChild(image);
    categoryDiv.appendChild(id);
    categoryDiv.appendChild(name);
    categoryDiv.appendChild(updateButton);
    categoryDiv.appendChild(delButton);

    containerDiv.appendChild(categoryDiv);
}
