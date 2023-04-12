drop procedure if exists test;
delimiter //
create procedure test(
    in _idPersonEnterprise int
)
begin
    set @idPerson = (select idPerson from personEnterprise where personEnterprise.idPersonEnterprise = _idPersonEnterprise);
    select @idPerson;
end //

call test(8);

describe detailProduct;

drop procedure if exists fetchDetailProduct;
create procedure fetchDetailProduct(
    in _idCatalogStatus int
)
begin
    select idDetailProduct,
           detailProduct.idCatalogSize,
           catalogSize.name as size,
           detailProduct.idCatalogColor,
           catalogColor.name as color,
           detailProduct.salePrice,
           detailProduct.purchasePrice
    from detailProduct
             inner join catalogSize on detailProduct.idCatalogSize = catalogSize.idCatalogSize
             inner join catalogColor on detailProduct.idCatalogColor = catalogColor.idCatalogColor
             inner join product on detailProduct.idProduct = product.idProduct
    where detailProduct.idCatalogStatus = _idCatalogStatus;
end
//

call fetchProduct(1);

drop procedure if exists gotoIdDetailProduct;
delimiter //
create procedure gotoIdDetailProduct(
    in _idDetailProduct int,
    in _idCatalogStatus int)
begin
    select detailProduct.idDetailProduct,
           detailProduct.idCatalogSize,
           catalogSize.name as size,
           detailProduct.idCatalogColor,
           catalogColor.name as color,
           detailProduct.salePrice,
           detailProduct.purchasePrice
    from detailProduct
             inner join catalogSize on detailProduct.idCatalogSize = catalogSize.idCatalogSize
             inner join catalogColor on detailProduct.idCatalogColor = catalogColor.idCatalogColor
    where detailProduct.idCatalogStatus = _idCatalogStatus and detailProduct.idDetailProduct = _idDetailProduct;
end
//

describe detailProduct;

drop procedure if exists saveDetailProduct;
delimiter //
create procedure saveDetailProduct(
    in _idCatalogSize int,
    in _idCatalogColor int,
    in _salePrice int,
    in _purchasePrice int)
begin
    insert into detailProduct(idCatalogSize, idCatalogColor, salePrice, purchasePrice, idCatalogStatus)
    values (_idCatalogSize, _idCatalogColor, _salePrice, _purchasePrice, 1) ;

    call gotoIdDetailProduct(last_insert_id(), 1);
end
//

call saveDetailProduct(2,2,6000,900);

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
call updateDetailProduct(
   3,
    2,
    3,
    101,
    2003
    );

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

call deleteDetailProduct(2,2);

call fetchDetailProduct(1);

drop procedure if exists searchDetailProduct;
delimiter //
create procedure searchDetailProduct(
    in _param varchar(35)
)
begin
    select idDetailProduct,
           detailProduct.idCatalogSize,
           catalogSize.name as size,
           detailProduct.idCatalogColor,
           catalogColor.name as color,
           detailProduct.salePrice,
           detailProduct.purchasePrice
    from detailProduct
             inner join catalogSize on detailProduct.idCatalogSize = catalogSize.idCatalogSize
             inner join catalogColor on detailProduct.idCatalogColor = catalogColor.idCatalogColor
    where detailProduct. detailProduct.idCatalogStatus = 1;
end //
