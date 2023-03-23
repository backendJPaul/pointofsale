import {CategoryService} from "./modules/CategoryService.js";
const categoryService = new CategoryService("api/category/");


const inputButtonSearch = document.getElementById("inputButtonSearch");
inputButtonSearch.addEventListener("keypress",inputButtonSearchEventChange);
function inputButtonSearchEventChange(){
    fetchCategory(inputButtonSearch.value);
}

async function fetchCategory(pattern){

    const tableItemContainer = document.getElementById("tableItemContainer");
    tableItemContainer.innerText = "";

    tableItemContainer.innerHTML =
        >:wq"<div class='itemTitle'>Categorias</div>" +
        "<div class='itemHeader'>ID</div>"+
        "<div class='itemHeader'>Nombre</div>"+
        "<div class='itemHeader'>Editar</div>"+
        "<div class='itemHeader'>Eliminar</div>";

    let categories = null;

    if(pattern != null){
        let category = {
            name: pattern
        }
        categories = await categoryService.search(category)
    }
    else if(pattern == "" || pattern == null){
        categories = await categoryService.fFetch();
    }

    for (let category of categories) {
        const divItemId = document.createElement("div");
        divItemId.className = "itemId";
        divItemId.innerText = category.idCategory;

        tableItemContainer.appendChild(divItemId);

        const divName = document.createElement("div");
        divName.className = "itemName";
        divName.innerText = category.name;

        tableItemContainer.appendChild(divName);


        const divItemUpdate = document.createElement("div");
        divItemUpdate.className = "itemUpdate";

        const inputButtonEdit = document.createElement("input");
        inputButtonEdit.setAttribute("type","button");
        inputButtonEdit.setAttribute("value","Editar");
        inputButtonEdit.setAttribute("class","button");
        inputButtonEdit.setAttribute("id","inputButtonEdit" + category.idCategory);
        divItemUpdate.appendChild(inputButtonEdit);

        tableItemContainer.appendChild(divItemUpdate);

        const divItemDelete = document.createElement("div");
        divItemDelete.className = "itemDelete";

        const inputButtonDelete = document.createElement("input");

        inputButtonDelete.setAttribute("type","button");
        inputButtonDelete.setAttribute("value","Eliminar");
        inputButtonDelete.setAttribute("class","button");
        inputButtonDelete.setAttribute("id","inputButtonDelete" + category.idCategory);
        divItemDelete.appendChild(inputButtonDelete);

        tableItemContainer.appendChild(divItemDelete);
    }
}

fetchCategory();