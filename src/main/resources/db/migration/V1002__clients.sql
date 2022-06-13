create table clients
(
    id  serial primary key NOT NULL,
    first_name varchar(128) NOT NULL,
    last_name varchar(450) NOT NULL,
    iin int NOT NULL
);

insert into clients(id, first_name, last_name, iin)
values (1, 'Jon', 'Smith', 12345),
       (2, 'Sue', 'Dowson', 12435);

