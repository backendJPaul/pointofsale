use posstore;

create table catalogStatus
(
    idCatalogStatus int auto_increment,
    primary key (idCatalogStatus),
    name varchar(35)
);
create table catalogGenre
(
    idCatalogGenre int auto_increment,
    primary key (idCatalogGenre),
    name varchar(2)
);

create table catalogSize
(
    idCatalogSize int auto_increment,
    primary key (idCatalogSize),
    name varchar(35)
);

create table catalogColor
(
    idCatalogColor int auto_increment,
    primary key (idCatalogColor),
    name varchar(6)
);

create table catalogTag
(
    idCatalogTag int auto_increment,
    primary key (idCatalogTag),
    name varchar(35)
);

drop table if exists user;
create table catalogUser
(
    idCatalogUser int auto_increment,
    primary key (idCatalogUser),
    name varchar(35)
);



insert into catalogUser(name)
values ("admin");
insert into catalogUser(name)
values ("saler");
insert into catalogUser(name)
values ("database");

insert into catalogGenre(name)
values ("Hombre");
insert into catalogGenre(name)
values ("Mujer");
insert into catalogGenre(name)
values ("Nino");
insert into catalogGenre(name)
values ("Nina");
insert into catalogGenre(name)
values ("Nino bebe");
insert into catalogGenre(name)
values ("Nina bebe");
insert into catalogGenre(name)
values ("WO");

insert into catalogColor(name)
values ("000000");
insert into catalogColor(name)
values ("FFFFFF");
insert into catalogColor(name)
values ("000000");
insert into catalogColor(name)
values ("000000");
insert into catalogColor(name)
values ("000000");
insert into catalogColor(name)
values ("000000");
insert into catalogColor(name)
values ("000000");
insert into catalogColor(name)
values ("000000");

insert into catalogSize(name)
values ("XS");
insert into catalogSize(name)
values ("S");
insert into catalogSize(name)
values ("M");
insert into catalogSize(name)
values ("L");
insert into catalogSize(name)
values ("XL");
insert into catalogSize(name)
values ("XXL");

insert into catalogSize(name)
values ("2");
insert into catalogSize(name)
values ("4");
insert into catalogSize(name)
values ("6");
insert into catalogSize(name)
values ("8");
insert into catalogSize(name)
values ("10");
insert into catalogSize(name)
values ("12");
insert into catalogSize(name)
values ("14");
insert into catalogSize(name)
values ("16");

insert into catalogSize(name)
values ("26");
insert into catalogSize(name)
values ("28");
insert into catalogSize(name)
values ("30");
insert into catalogSize(name)
values ("32");
insert into catalogSize(name)
values ("34");
insert into catalogSize(name)
values ("36");
insert into catalogSize(name)
values ("38");
insert into catalogSize(name)
values ("40");
insert into catalogSize(name)
values ("42");

insert into catalogSize(name)
values ("1 plaza");
insert into catalogSize(name)
values ("1 1/2 plaza");
insert into catalogSize(name)
values ("2 plazas");
insert into catalogSize(name)
values ("Queen");
insert into catalogSize(name)
values ("King");

insert into catalogStatus(name)
values ("enable");
insert into catalogStatus(name)
values ("disable");
insert into catalogStatus(name)
values ("delete");

insert into catalogTag(name)
values ("1 botones");
insert into catalogTag(name)
values ("2 botones");
insert into catalogTag(name)
values ("3 botones");
insert into catalogTag(name)
values ("Estampado");
insert into catalogTag(name)
values ("Rasgado");

