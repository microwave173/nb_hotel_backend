create table user
(
    name     varchar(50) not null,
    id       int auto_increment
        primary key,
    password varchar(50) not null,
    tag      varchar(50) null
);

