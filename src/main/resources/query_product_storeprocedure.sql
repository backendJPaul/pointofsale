drop procedure if exists fetchProduct;
delimiter //
create procedure fetchProduct(
    in _idCatalogStatus int
)
begin
    select product.idProduct,
           product.name,
           product.idCategory,
           category.name as category,
           product.idEnterprise,
           enterprise.name as enterprise,
           product.idCatalogGenre,
           catalogGenre.name genre
    from product
             inner join category on category.idCategory = product.idCategory
             inner join enterprise on enterprise.idEnterprise = product.idEnterprise
             inner join catalogGenre on catalogGenre.idCatalogGenre = product.idCatalogGenre
             where product.idCatalogStatus = _idCatalogStatus;
end //

call fetchProduct(1);

drop procedure if exists gotoIdProduct;
delimiter //
create procedure gotoIdProduct(
    in _idProduct int,
    in _idCatalogStatus int)
begin
    select product.idProduct,
           product.name,
           product.idCategory,
           category.name as category,
           product.idEnterprise,
           enterprise.name as enterprise,
           product.idCatalogGenre,
           catalogGenre.name genre
    from product
             inner join category on category.idCategory = product.idCategory
             inner join enterprise on enterprise.idEnterprise = product.idEnterprise
             inner join catalogGenre on catalogGenre.idCatalogGenre = product.idCatalogGenre
    where product.idCatalogStatus = _idCatalogStatus and product.idProduct = _idProduct;
end
//

describe product;

drop procedure if exists saveProduct;
delimiter //
create procedure saveProduct(
    in _name varchar(35),
    in _idCategory int,
    in _idEnterprise int,
    in _idCatalogGenre int)
begin

    insert into product(name, idCategory, idEnterprise, idCatalogGenre, idCatalogStatus)
    values (_name, _idCategory, _idEnterprise,_idCatalogGenre,1);

    call gotoIdProduct(last_insert_id(), 1);
end
//


call saveProduct("Quasila 3 botones",1,1,1);
call saveProduct("Jinju 1 boton",1,1,1);
call saveProduct("Polera color entero",1,1,1);
call saveProduct("Falda",1,1,1);
call saveProduct("Short",1,1,1);
call saveProduct("Polos kitty",1,1,1);
call saveProduct("Polo Naruto",1,1,1);

drop procedure if exists updateProduct;
delimiter //
create procedure updateProduct(
    in _idProduct int,
    in _name varchar(35),
    in _idCategory int,
    in _idEnterprise int,
    in _idCatalogGenre int)
begin

    update product
    set name = _name,
    idCategory = _idCategory,
    idEnterprise = _idEnterprise,
    idCatalogGenre = _idCatalogGenre
    where idProduct = _idProduct;

    call gotoIdProduct(_idProduct, 1);
end
//

drop procedure if exists deleteProduct;
delimiter //
create procedure deleteProduct(
    in _idProduct int,
    in _idCatalogStatus int)
begin

    update product set idCatalogStatus = _idCatalogStatus where idProduct = _idProduct;

    call gotoIdProduct(_idProduct, _idCatalogStatus);
end
//

call fetchProduct(1);

drop procedure if exists searchProduct;
delimiter //
create procedure searchProduct(
    in _param varchar(35)
)
begin
    select product.idProduct,
           product.name,
           product.idCategory,
           category.name as category,
           product.idEnterprise,
           enterprise.name as enterprise,
           product.idCatalogGenre,
           catalogGenre.name genre
    from product
             inner join category on category.idCategory = product.idCategory
             inner join enterprise on enterprise.idEnterprise = product.idEnterprise
             inner join catalogGenre on catalogGenre.idCatalogGenre = product.idCatalogGenre
    where product.name like concat('%', _param ,'%') and product.idCatalogStatus = 1;

end //
