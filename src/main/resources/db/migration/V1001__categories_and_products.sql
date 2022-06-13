CREATE TABLE categories
(
    id serial primary key NOT NULL,
    name    varchar(128)  NOT NULL
);

create table products
(
    id  serial primary key NOT NULL,
    name varchar(128)  NOT NULL,
    price int  not null,
    description varchar(450),
    category_id int not null,
    CONSTRAINT fk_product_category FOREIGN KEY (category_id) REFERENCES categories (id)
);

insert into categories(id, name)
values (1, 'milk'),
       (2, 'sweets');

insert into products(id, name, price, description, category_id)
values (1, 'milky', 200, 'tasty milk', 1),
       (2, 'cake', 120, 'sweet cake', 2),
       (3, 'candy', 2311, 'chocolate candies', 2);