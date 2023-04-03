import {CategoryService} from "./modules/CategoryService.js";
const categoryService = new CategoryService("api/category/");

let categorySaveButton = document.getElementById("categorySaveButton");
categorySaveButton.addEventListener("click",saveCategory)

async function saveCategory(){
    let category = {
        name: document.getElementById("categorySaveText").value
    }
    await categoryService.save(category);
}

async function fetchCategory(){



    const tableItemContainer = document.getElementById("tableItemContainer");
    const categories = await categoryService.fFetch();

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


        inputButtonEdit.addEventListener("click", inputButtonEditHandlerClick);
        let idCategory;
        function inputButtonEditHandlerClick(){
            let editModal = document.getElementById("editModal");
            let categoryEditText = document.getElementById("categoryEditText");
            categoryEditText.value = category.name;
            idCategory = category.idCategory;
            editModal.style.display = "block";
        }

        let categoryEditButton = document.getElementById("categoryEditButton");
        categoryEditButton.addEventListener("click", categoryEditButtonHandler);
        async function categoryEditButtonHandler(){
            let category = {
                idCategory : idCategory,
                name : document.getElementById("categoryEditText").value
            }
            console.log(category);
            await categoryService.update(category);
        }

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
