use jdbc;

create table users
(
    id   int primary key identity,
    name varchar(100) not null,
    age  int          not null check (age > 0)
);