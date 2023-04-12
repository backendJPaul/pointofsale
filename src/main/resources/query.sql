
drop table if exists person;
create table person
(
    idPerson        int auto_increment,
    primary key (idPerson),
    idCatalogGenre  int,
    foreign key (idCatalogGenre) references catalogGenre (idCatalogGenre),
    name            varchar(35),
    lastName        varchar(35),
    email           varchar(35),
    direction       varchar(35),
    phone           varchar(9),
    idCatalogStatus int,
    foreign key (idCatalogStatus) references catalogStatus (idCatalogStatus)
);

drop table if exists enterprise;
create table enterprise
(
    idEnterprise    int auto_increment,
    primary key (idEnterprise),
    ruc             varchar(11),
    direction       varchar(35),
    telephone       varchar(9),
    name            varchar(35),
    idCatalogStatus int,
    foreign key (idCatalogStatus) references catalogStatus (idCatalogStatus)
);

drop table if exists personEnterprise;
create table personEnterprise
(
    idPersonEnterprise int auto_increment,
    primary key (idPersonEnterprise),
    idPerson int,
    foreign key (idPerson) references person (idPerson),
    idEnterprise int,
    foreign key (idEnterprise) references enterprise (idEnterprise),
    idCatalogStatus int,
    foreign key (idCatalogStatus) references catalogStatus (idCatalogStatus)
);

drop table if exists personUser;
create table personUser
(
    idPersonUser int auto_increment,
    primary key (idPersonUser),
    idCatalogUser int,
    foreign key (idCatalogUser) references catalogUser(idCatalogUser),
    idPerson int,
    foreign key (idPerson) references person (idPerson),
    name varchar(35),
    password varchar(35),
    idCatalogStatus int,
    foreign key (idCatalogStatus) references catalogStatus (idCatalogStatus)
);

drop table if exists login;
create table login
(
    idLogin int auto_increment,
    primary key (idLogin),

    idPersonUser int,
    foreign key (idPersonUser) references personUser (idPersonUser),

    dateLogin timestamp default current_timestamp,

    idCatalogStatus int,
    foreign key (idCatalogStatus) references catalogStatus (idCatalogStatus)
);

drop table if exists customer;
create table customer
(
    idCustomer int auto_increment,
    primary key (idCustomer),

    idPerson   int,
    foreign key (idPerson) references person (idPerson)
);

create table category
(
    idCategory      int auto_increment,
    primary key (idCategory),
    name            varchar(35),
    idCatalogStatus int,
    foreign key (idCatalogStatus) references catalogStatus (idCatalogStatus)
);

create table product
(
    idProduct       int auto_increment,
    primary key (idProduct),
    name            varchar(35),
    idCategory      int,
    foreign key (idCategory) references category (idCategory),
    idEnterprise    int,
    foreign key (idEnterprise) references enterprise (idEnterprise),
    idCatalogGenre  int,
    foreign key (idCatalogGenre) references catalogGenre (idCatalogGenre),
    idCatalogStatus int,
    foreign key (idCatalogStatus) references catalogStatus (idCatalogStatus)

);

drop table if exists detailProduct;
create table detailProduct
(
    idDetailProduct int auto_increment,
    primary key (idDetailProduct),

    idProduct int,
    foreign key (idProduct) references product(idProduct),

    idCatalogSize   int,
    foreign key (idCatalogSize) references catalogSize (idCatalogSize),

    idCatalogColor  int,
    foreign key (idCatalogColor) references catalogColor (idCatalogColor),

    salePrice       double(9, 2),
    purchasePrice   double(9, 2),

    idCatalogStatus int,
    foreign key (idCatalogStatus) references catalogStatus (idCatalogStatus)
);
drop table if exists expense;
create table expense
(
    idExpense       int auto_increment,
    primary key (idExpense),
    title           varchar(35),
    description     tinytext,
    date            timestamp,
    quantity        int,
    idDetailProduct int,
    foreign key (idDetailProduct) references detailProduct (idDetailProduct),

    idCatalogStatus int,
    foreign key (idCatalogStatus) references catalogStatus (idCatalogStatus)
);

create table inventoryDetailProduct
(
    idInventoryDetailProduct int auto_increment,
    primary key (idInventoryDetailProduct),
    quantity                 int,
    dateCurrent              timestamp default current_timestamp,
    idDetailProduct          int,
    foreign key (idDetailProduct) references detailProduct (idDetailProduct)

);

create table tagProduct
(
    idTaProduct     int auto_increment,
    primary key (idTaProduct),
    idProduct       int,
    foreign key (idProduct) references product (idProduct),
    idCatalogTag    int,
    foreign key (idCatalogTag) references catalogTag (idCatalogTag),
    idCatalogStatus int,
    foreign key (idCatalogStatus) references catalogStatus (idCatalogStatus)
);

create table payment
(
    idPayment int auto_increment,
    primary key (idPayment),
    name      varchar(35),
    discount  float(9, 2)
);

create table sale
(
    idSale          int auto_increment,
    primary key (idSale),

    discount        double,
    subtotal        double,
    total           double(9, 2),

    idPayment       int,
    foreign key (idPayment) references payment (idPayment),

    idEnterprise    int,
    foreign key (idEnterprise) references enterprise (idEnterprise),

    idCatalogStatus int,
    foreign key (idCatalogStatus) references catalogStatus (idCatalogStatus)
);

create table saleDetail
(
    quantity        int,

    idSaleDetail    int,
    primary key (idSaleDetail),
    idDetailProduct int,
    foreign key (idDetailProduct) references detailProduct (idDetailProduct),

    idSale          int,
    foreign key (idSale) references sale (idSale),

    idCatalogStatus int,
    foreign key (idCatalogStatus) references catalogStatus (idCatalogStatus)
);
