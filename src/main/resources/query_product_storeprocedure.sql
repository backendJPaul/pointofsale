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

select * from enterprise;



drop procedure if exists fetchProduct;
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
end
//

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

call saveProduct("3 botones sin rasgado",
                 1,
                 1,
                 1
);

drop procedure if exists updatePersonEnterprise;
delimiter //
create procedure updatePersonEnterprise(
    in _idPersonEnterprise int,
    in _idCatalogGenre int,
    in _personName varchar(35),
    in _lastName varchar(35),
    in _email varchar(35),
    in _personDirection varchar(35),
    in _phone varchar(9),
    in _ruc varchar(35),
    in _enterpriseDirection varchar(35),
    in _telephone varchar(9),
    in _enterpriseName varchar(35))
begin
    set @idPerson = (select idPerson from personEnterprise where personEnterprise.idPersonEnterprise = _idPersonEnterprise);
    update person set idCatalogGenre = _idCatalogGenre,
                      name = _personName,
                      lastName = _lastName,
                      email = _email,
                      direction = _personDirection,
                      phone = _phone where idPerson = @idPerson;

    set @idEnterprise = (select idEnterprise from personEnterprise where personEnterprise.idPersonEnterprise = _idPersonEnterprise );
    update enterprise set ruc = _ruc,
                      direction = _enterpriseDirection,
                      telephone = _telephone,
                      name = _enterpriseName where idEnterprise = @idEnterprise;

    call gotoIdPersonEnterprise(_idPersonEnterprise,1);
end
//

call updatePersonEnterprise(
   8,
    2,
    "Hernan",
    "Sandoval",
    "hsandoval1@hotmail.com",
    "Av. Las Calezas 283",
    "926706605",
    "454545454",
    "324324324",
    "42342342",
    "LeonStar"
    );

drop procedure if exists deletePersonEnterprise;
delimiter //
create procedure deletePersonEnterprise(
    in _idPersonEnterprise int,
    in _idCatalogStatus int)
begin
    set @idPerson = (select idPerson from personEnterprise where idPersonEnterprise = _idPersonEnterprise);
    update person set idCatalogStatus = _idCatalogStatus where idPerson = @idPerson;

    set @idEnterprise = (select idEnterprise from personEnterprise where idPersonEnterprise = _idPersonEnterprise);
    update enterprise set idCatalogStatus = _idCatalogStatus where idEnterprise = @idEnterprise;

    update personEnterprise set idCatalogStatus = _idCatalogStatus where idPersonEnterprise = _idPersonEnterprise;

    call gotoIdPersonEnterprise(_idPersonEnterprise, _idCatalogStatus);
end
//

drop procedure if exists searchPersonEnterprise;
delimiter //
create procedure searchPersonEnterprise(
    in _param varchar(35)
)
begin
    select personenterprise.idPersonEnterprise,
           person.idPerson,
           person.name,
           person.lastName,
           person.email,
           person.direction,
           person.phone,
           enterprise.idEnterprise,
           enterprise.ruc,
           enterprise.direction,
           enterprise.telephone,
           enterprise.name
    from personEnterprise
             inner join person on personenterprise.idPerson = person.idPerson
             inner join enterprise on personEnterprise.idEnterprise = enterprise.idEnterprise
    where person.name like concat('%', _param, '%') and personenterprise.idCatalogStatus = 1;
end //