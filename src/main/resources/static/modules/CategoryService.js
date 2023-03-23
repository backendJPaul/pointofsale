export class CategoryService {
    constructor(url) {
        this.url = url;
    }

    async fFetch() {
        const request = await fetch(this.url, {
            method: "GET",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
        });

        let arrayObj = [];
        const response = await request.json();

        for (let category of response) {
            let obj = {
                idCategory: category.idCategory,
                name: category.name,
                idCatalogStatus: category.idCatalogStatus
            }
            arrayObj.push(obj);
        }
        return arrayObj;
    }

    async gotoId(id) {
        const request = await fetch(this.url + id, {
            method: "GET",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
        });
        let category;
        const response = await request.json();
        category = {
            idCategory: response.idCategory,
            name: response.name,
            idCatalogStatus: response.idCatalogStatus
        }
        return category;
    }

    async save(_category){
        const request = await fetch(this.url, {
            method: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(_category)
        });

        let category;
        const response = await request.json();

        category = {
            idCategory : response.idCategory,
            name : response.name,
            idCatalogStatus : response.idCatalogStatus
        }
        return category;
    }

    async update(_category){
        const request = await fetch(this.url, {
            method: "PUT",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(_category)
        });

        let category;
        const response = await request.json();

        category = {
            idCategory : response.idCategory,
            name : response.name,
            idCatalogStatus : response.idCatalogStatus
        }
        return category;
    }

    async delete(_category){
        const request = await fetch(this.url, {
            method: "DELETE",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(_category)
        });

        let category;
        const response = await request.json();

        category = {
            idCategory : response.idCategory,
            name : response.name,
            idCatalogStatus : response.idCatalogStatus
        }
        return category;
    }

    async search(_category) {
        const request = await fetch(this.url + "search/", {
            method: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(_category)
        });

        let arrayObj = [];
        const response = await request.json();

        for (let category of response) {
            let obj = {
                idCategory: category.idCategory,
                name: category.name,
                idCatalogStatus: category.idCatalogStatus
            }
            arrayObj.push(obj);

        }
        return arrayObj;
    }

}

