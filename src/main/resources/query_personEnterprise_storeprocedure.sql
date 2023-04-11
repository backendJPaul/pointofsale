drop procedure if exists fetchCategory;
delimiter //
create procedure fetchCategory(
    in _idCatalogStatus int
)
begin
    select idCategory, name, idCatalogStatus from category where idCatalogStatus = _idCatalogStatus;
end
//
drop procedure if exists gotoIdCategory;
delimiter //
create procedure gotoIdCategory(
    in _idCategory int,
    in _idCatalogStatus int
)
begin
    select idCategory, name, idCatalogStatus from category where idCategory = _idCategory and idCatalogStatus = _idCatalogStatus;
end
//

drop procedure if exists saveCategory;
delimiter //
create procedure saveCategory(
    in _name varchar(35)
)
begin
    insert into category(name,idCatalogStatus) values (_name,1);
    call gotoIdCategory(LAST_INSERT_ID(),1);
end
//
drop procedure if exists updateCategory;
delimiter //
create procedure updateCategory(
    in _idCategory int,
    in _name varchar(35)
)
begin
    update category set name = _name where idCategory = _idCategory;
    call gotoIdCategory(_idCategory,1);
end
//
drop procedure if exists deleteCategory;
delimiter //
create procedure deleteCategory(
    in _idCatalogStatus int,
    in _idCategory int
)
begin
    update category set idCatalogStatus = _idCatalogStatus where idCategory = _idCategory;
    call gotoIdCategory(_idCategory,_idCatalogStatus);
end
//

drop procedure if exists searchCategory;
delimiter //
create procedure searchCategory(
    in _param varchar(35)
)
begin
    select idCategory, name, idCatalogStatus from category where name like concat('%',_param,'%');
end //

/* store procedures enterprisePerson */

