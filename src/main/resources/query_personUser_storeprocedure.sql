drop procedure if exists test;
delimiter //
create procedure test(
    in _idPersonUser int
)
begin
    set @idPerson = (select idPerson from personUser where personEnterprise.idPersonUser = _idPersonEnterprise);
    select @idPerson;
end //

call test(8);

describe personUser;

drop procedure if exists fetchPersonUser;
create procedure fetchPersonUser(
    in _idCatalogStatus int
)
begin
    select  personUser.idPersonUser,
            catalogUser.name as username,
            person.idPerson,
            person.name,
            person.lastName,
            person.email,
            person.direction,
            person.phone
    from personUser
             inner join catalogUser on catalogUser.idCatalogUser = personUser.idCatalogUser
             inner join person on person.idPerson = personUser.idPerson
    where personUser.idCatalogStatus = _idCatalogStatus ;

end
//

drop procedure if exists gotoIdPersonUser;
delimiter //
create procedure gotoIdPersonUser(
    in _idPersonUser int,
    in _idCatalogStatus int)
begin
    select  personUser.idPersonUser,
            catalogUser.name as username,
            person.idPerson,
            person.name,
            person.lastName,
            person.email,
            person.direction,
            person.phone
    from personUser
             inner join catalogUser on catalogUser.idCatalogUser = personUser.idCatalogUser
             inner join person on person.idPerson = personUser.idPerson
    where idPersonUser = _idPersonUser and personUser.idCatalogStatus = _idCatalogStatus ;
end
//

describe personUser;

drop procedure if exists savePersonUser;
delimiter //
create procedure savePersonUser(
    in _idCatalogGenre int,
    in _personName varchar(35),
    in _lastName varchar(35),
    in _email varchar(35),
    in _personDirection varchar(35),
    in _phone varchar(9),
    in _idCatalogUser int,
    in _name varchar(35),
    in _password varchar(35)
)
begin
    declare keyIdPerson int default 0;
    declare keyIdPersonUser int default 0;

    insert into person(idCatalogGenre, name, lastName, email, direction, phone, idCatalogStatus)
    values (_idCatalogGenre, _personName, _lastName, _email, _personDirection, _phone, 1);
    set keyIdPerson = last_insert_id();

    insert into personUser(idCatalogUser, idPerson, name, password, idCatalogStatus)
    values (_idCatalogUser, keyIdPerson, _name, _password, 1);
    set keyIdPersonUser = last_insert_id();

    call gotoIdPersonUser(keyIdPerson,1);
end
//

call savePersonUser(1,
    "Heidi",
    "Huamani",
    "heidi@gmail.com",
    "Pasaje Jupiter 120",
    "953105002",
    1,
    "hhuamani",
    "root");

drop procedure if exists updatePersonUser;
delimiter //
create procedure updatePersonUser(
    in _idPersonUser int,
    in _idCatalogGenre int,
    in _personName varchar(35),
    in _lastName varchar(35),
    in _email varchar(35),
    in _personDirection varchar(35),
    in _phone varchar(9),
    in _idCatalogUser int,
    in _name varchar(35),
    in _password varchar(35))
begin
    set @idPerson = (select idPerson from personUser where personUser.idPersonUser = _idPersonUser);
    update person set idCatalogGenre = _idCatalogGenre,
                      name = _personName,
                      lastName = _lastName,
                      email = _email,
                      direction = _personDirection,
                      phone = _phone where idPerson = @idPerson;

    update personUser set idCatalogUser = _idCatalogUser,
                      name = _name,
                      password = _password where idPersonUser = _idPersonUser;

    call gotoIdPersonUser(_idPersonUser,1);
end
//

call fetchPersonUser(1);
call updatePersonUser(
   3,
    1,
    "Priscila",
    "Guianella",
    "priscila@hotmail.com",
    "Av. Las Calezas 283",
    "926706605",
    2,
    "Priscila",
    "42342342"
    );

drop procedure if exists deletePersonUser;
delimiter //
create procedure deletePersonUser(
    in _idPersonUser int,
    in _idCatalogStatus int)
begin
    set @idPerson = (select idPerson from personUser where idPersonUser = _idPersonUser);
    update person set idCatalogStatus = _idCatalogStatus where idPerson = @idPerson;

    update personUser set idCatalogStatus = _idCatalogStatus where idPersonUser = _idPersonUser;

    call gotoIdPersonUser(_idPersonUser, _idCatalogStatus);
end
//

drop procedure if exists searchPersonUser;
delimiter //
create procedure searchPersonUser(
    in _param varchar(35)
)
begin
    select  personUser.idPersonUser,
            catalogUser.name as username,
            person.idPerson,
            person.name,
            person.lastName,
            person.email,
            person.direction,
            person.phone
    from personUser
             inner join catalogUser on catalogUser.idCatalogUser = personUser.idCatalogUser
             inner join person on person.idPerson = personUser.idPerson

    where person.name like concat('%', _param, '%') and personUser.idCatalogStatus = 1;
end //
