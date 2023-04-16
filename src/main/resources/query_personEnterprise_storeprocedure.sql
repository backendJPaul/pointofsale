drop procedure if exists savePerson;
delimiter //
create procedure savePerson(in _idCatalogGenre int,
                            in _name varchar(35),
                            in _lastName varchar(35),
                            in _email varchar(35),
                            in _direction varchar(35),
                            in _phone varchar(9))
begin
    insert person(idCatalogGenre, name, lastName, email, direction, phone, idCatalogStatus)
    values (_idCatalogGenre, _name, _lastName, _email, _direction, _phone, 1);
end //

drop procedure if exists saveEnterprise;
delimiter //
create procedure saveEnterprise(
    in _ruc varchar(11),
    in _direction varchar(35),
    in _telephone varchar(9),
    in _name varchar(35))
begin
    insert into enterprise(name, ruc, direction, telephone, idCatalogStatus)
    values (_name, _ruc, _direction, _telephone, 1);
end //

drop procedure if exists fetchPersonEnterprise;
create procedure fetchPersonEnterprise(
    in _idCatalogStatus int
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
           enterprise.name,
           enterprise.ruc,
           enterprise.direction,
           enterprise.telephone
           from personEnterprise
           inner join person on personenterprise.idPerson = person.idPerson
           inner join enterprise on personEnterprise.idEnterprise = enterprise.idEnterprise
    where personenterprise.idCatalogStatus = _idCatalogStatus;
end
//

drop procedure if exists gotoIdPersonEnterprise;
delimiter //
create procedure gotoIdPersonEnterprise(
    in _idPersonEnterprise int,
    in _idCatalogStatus int)
begin
    select personenterprise.idPersonEnterprise,
           person.idPerson,
           person.name,
           person.lastName,
           person.email,
           person.direction,
           person.phone,
           enterprise.idEnterprise,
           enterprise.name,
           enterprise.ruc,
           enterprise.direction,
           enterprise.telephone
    from personEnterprise
             inner join
         person on personenterprise.idPerson = person.idPerson
             inner join
         enterprise on personEnterprise.idEnterprise = enterprise.idEnterprise
    where idPersonEnterprise = _idPersonEnterprise
      and personenterprise.idCatalogStatus = _idCatalogStatus;
end
//

drop procedure if exists savePersonEnterprise;
delimiter //
create procedure savePersonEnterprise(
    in _personName varchar(35),
    in _lastName varchar(35),
    in _email varchar(35),
    in _personDirection varchar(35),
    in _phone varchar(9),
    in _idCatalogGenre int,
    in _enterpriseName varchar(35),
    in _ruc varchar(35),
    in _enterpriseDirection varchar(35),
    in _telephone varchar(9))
begin
    declare keyIdPerson int default 0;
    declare keyIdEnterprise int default 0;
    declare keyIdPersonEnterprise int default 0;

    insert into person(name, lastName, email, direction, phone, idCatalogGenre, idCatalogStatus)
    values (_personName, _lastName, _email, _personDirection, _phone, _idCatalogGenre, 1);
    set keyIdPerson = last_insert_id();

    describe enterprise;

    insert into enterprise(name, ruc, direction, telephone,  idCatalogStatus)
    values (_enterpriseName, _ruc, _enterpriseDirection, _telephone, 1);
    set keyIdEnterprise = last_insert_id();

    insert into personEnterprise(idPerson, idEnterprise, idCatalogStatus)
    values (keyIdPerson,keyIdEnterprise,1);
    set keyIdPersonEnterprise = last_insert_id();

    call fetchPersonEnterprise(1);
end
//

call savePersonEnterprise("Liz",
                          "Povis",
                          "lpovis@gmail.com",
                          "Av Restauracion 222",
                          "99834839",
                          1,
                          "Leoncito",
                          "32312312",
                          "Av. Lorenzo Encalada 178",
                          "432432432");

call savePersonEnterprise("Walter",
                          "Leon",
                          "lwalter@gmail.com",
                          "Av Restauracion 222",
                          "99834839",
                          1,
                          "Leon Sport",
                          "32312312",
                          "Av. Lorenzo Encalada 178",
                          "432432432");
call savePersonEnterprise("Cesia",
                          "Lein",
                          "cleon@gmail.com",
                          "Av Restauracion 222",
                          "99834839",
                          1,
                          "CJ Estilos",
                          "32312312",
                          "Av. Lorenzo Encalada 178",
                          "432432432");

drop procedure if exists updatePersonEnterprise;
delimiter //
create procedure updatePersonEnterprise(
    in _idPersonEnterprise int,
    in _personName varchar(35),
    in _lastName varchar(35),
    in _email varchar(35),
    in _personDirection varchar(35),
    in _phone varchar(9),
    in _idCatalogGenre int,
    in _ruc varchar(35),
    in _enterpriseDirection varchar(35),
    in _telephone varchar(9),
    in _enterpriseName varchar(35))
begin
    set @idPerson = (select idPerson from personEnterprise where personEnterprise.idPersonEnterprise = _idPersonEnterprise);
    update person set name = _personName,
                      lastName = _lastName,
                      email = _email,
                      direction = _personDirection,
                      phone = _phone,
                      idCatalogGenre = _idCatalogGenre
                      where idPerson = @idPerson;


    set @idEnterprise = (select idEnterprise from personEnterprise where personEnterprise.idPersonEnterprise = _idPersonEnterprise );
    update enterprise set ruc = _ruc,
                      direction = _enterpriseDirection,
                      telephone = _telephone,
                      name = _enterpriseName where idEnterprise = @idEnterprise;

    call gotoIdPersonEnterprise(_idPersonEnterprise,1);
end
//

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