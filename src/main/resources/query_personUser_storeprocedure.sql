drop procedure if exists fetchPersonUser;
delimiter //
create procedure fetchPersonUser(
    in _idCatalogStatus int
)
begin
    select  personUser.idPersonUser,
            catalogUser.idCatalogUser,
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
            catalogUser.idCatalogUser,
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

drop procedure if exists savePersonUser;
delimiter //
create procedure savePersonUser(
    in _personName varchar(35),
    in _lastName varchar(35),
    in _email varchar(35),
    in _personDirection varchar(35),
    in _phone varchar(9),
    in _idCatalogGenre int,
    in _idCatalogUser int,
    in _name varchar(35),
    in _password varchar(35)
)
begin
    declare keyIdPerson int default 0;
    declare keyIdPersonUser int default 0;

    insert into person(name, lastName, email, direction, phone,idCatalogGenre, idCatalogStatus)
    values (_personName, _lastName, _email, _personDirection, _phone,_idCatalogGenre, 1);
    set keyIdPerson = last_insert_id();

    insert into personUser(idCatalogUser, idPerson, name, password, idCatalogStatus)
    values (_idCatalogUser, keyIdPerson, _name, _password, 1);
    set keyIdPersonUser = last_insert_id();

    call gotoIdPersonUser(keyIdPersonUser,1);
end
//

call savePersonUser(
    "Heidi",
    "Huamani",
    "hhuamani@gmail.com",
    "Av. Lorenzo Encalada 178",
    "234345456",
    1,
    2,
    "hhuamani",
    "root");

call gotoIdPersonUser(1,1);

call updatePersonUser(
        3,
        1,
        "Keila",
        "Guianella",
        "priscila@hotmail.com",
        "Av. Las Calezas 283",
        "926706605",
        2,
        "Priscila",
        "42342342"
    );

call savepersonuser(
        "cesia",
        "leon",
        "cleon@gmail.com",
        "encalada 189a",
        "234345456",
        2,
        2,
        "aalbornos",
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
            catalogUser.idCatalogUser,
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

call fetchPersonUser(1);