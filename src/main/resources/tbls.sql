create table if not exists Users (
    id numeric primary key,
    name varchar(255) not null,
    mobNum varchar(255) not null,
    email varchar(255) not null
);

create table if not exists Orders (
    id numeric primary key,
    product numeric not null,
    users numeric not null,
    prType varchar(255) not null,
    foreign key (users) references Users(id) on delete cascade
);

create table if not exists Material (
    id numeric primary key,
    name varchar(255) not null,
    price numeric not null,
    useTime numeric not null,
    description numeric not null,
    prType varchar(255) not null,
    type varchar(255) not null
);

create table if not exists Workspace (
    id numeric primary key,
    name varchar(255) not null,
    price numeric not null,
    useTime numeric not null,
    description numeric not null,
    prType varchar(255) not null,
    type varchar(255) not null

);

create table if not exists Offer (
    id numeric primary key,
    name varchar(255) not null,
    price numeric not null,
    useTime numeric not null,
    description numeric not null,
    prType varchar(255) not null,
    type varchar(255) not null
    users numeric not null,
    foreign key (users) references Users(id) on delete cascade

);