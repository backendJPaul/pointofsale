select detailProduct.idDetailProduct
       from detailproduct
       inner join product on detailProduct.idProduct = product.idProduct;


drop procedure if exists fetchDetailProduct;
delimiter //
create procedure fetchDetailProduct(
    in _idCatalogStatus int
)
begin
    select idDetailProduct,
           detailProduct.idProduct,
           product.name as product,
           detailProduct.idCatalogSize,
           catalogSize.name as size,
           detailProduct.idCatalogColor,
           catalogColor.name as color,
           detailProduct.salePrice,
           detailProduct.purchasePrice
    from detailProduct
             inner join product on detailProduct.idProduct = product.idProduct
             inner join catalogSize on detailProduct.idCatalogSize = catalogSize.idCatalogSize
             inner join catalogColor on detailProduct.idCatalogColor = catalogColor.idCatalogColor
    where detailProduct.idCatalogStatus = 1;
end
//

drop procedure if exists gotoIdDetailProduct;
delimiter //
create procedure gotoIdDetailProduct(
    in _idDetailProduct int,
    in _idCatalogStatus int)
begin
    select idDetailProduct,
           product.name as product,
           detailProduct.idCatalogSize,
           catalogSize.name as size,
           detailProduct.idCatalogColor,
           catalogColor.name as color,
           detailProduct.salePrice,
           detailProduct.purchasePrice
    from detailProduct
             inner join product on detailProduct.idProduct = product.idProduct
             inner join catalogSize on detailProduct.idCatalogSize = catalogSize.idCatalogSize
             inner join catalogColor on detailProduct.idCatalogColor = catalogColor.idCatalogColor
    where detailProduct.idDetailProduct = _idDetailProduct and detailProduct.idCatalogStatus = _idCatalogStatus;

end
//

drop procedure if exists saveDetailProduct;
delimiter //
create procedure saveDetailProduct(
    in _idProduct int,
    in _idCatalogSize int,
    in _idCatalogColor int,
    in _salePrice int,
    in _purchasePrice int)
begin
    insert into detailProduct(idProduct, idCatalogSize, idCatalogColor, salePrice, purchasePrice, idCatalogStatus)
    values (_idProduct, _idCatalogSize, _idCatalogColor, _salePrice, _purchasePrice, 1) ;

    call gotoIdDetailProduct(last_insert_id(), 1);
end
//

insert into detailProduct(idProduct, idCatalogSize, idCatalogColor, salePrice, purchasePrice, idCatalogStatus)
values (idProduct, idCatalogSize, idCatalogColor, salePrice, purchasePrice, 1);


insert into detailProduct(idProduct, idCatalogSize, idCatalogColor, salePrice, purchasePrice, idCatalogStatus)
values (idProduct, idCatalogSize, idCatalogColor, salePrice, purchasePrice, 1);

call saveDetailProduct(
    1,
    1,
    1,
    900,
    800);

call saveDetailProduct(
        2,
        2,
        3,
        200,
        4500);


call saveDetailProduct(
        3,
        3,
        3,
        600,
        1000);

drop procedure if exists updateDetailProduct;
delimiter //
create procedure updateDetailProduct(
    in _idDetailProduct int,
    in _idCatalogSize int,
    in _idCatalogColor int,
    in _salePrice int,
    in _purchasePrice int)
begin
    update detailProduct
    set idCatalogSize = _idCatalogSize,
    idCatalogColor = _idCatalogColor,
    salePrice = _salePrice,
    purchasePrice = _purchasePrice
    where idDetailProduct = _idDetailProduct;

    call gotoIdProduct(_idDetailProduct, 1);
end
//

drop procedure if exists deleteDetailProduct;
delimiter //
create procedure deleteDetailProduct(
    in _idDetailProduct int,
    in _idCatalogStatus int)
begin

    update detailProduct set idCatalogStatus = _idCatalogStatus where idDetailProduct = _idDetailProduct;

    call gotoIdDetailProduct(_idDetailProduct, _idCatalogStatus);
end
//

drop procedure if exists searchDetailProduct;
delimiter //
create procedure searchDetailProduct(
    in _param varchar(35)
)
begin
    select detailProduct.idDetailProduct,
           product.name,
           detailProduct.idCatalogSize,
           catalogSize.name as size,
           detailProduct.idCatalogColor,
           catalogColor.name as color,
           detailProduct.salePrice,
           detailProduct.purchasePrice
    from detailProduct
            inner join product on detailProduct.idProduct = product.idProduct
             inner join catalogSize on detailProduct.idCatalogSize = catalogSize.idCatalogSize
             inner join catalogColor on detailProduct.idCatalogColor = catalogColor.idCatalogColor
    where product.name like concat('%',_param,'%') and detailProduct.idCatalogStatus = detailProduct.idCatalogStatus = 1;
end //