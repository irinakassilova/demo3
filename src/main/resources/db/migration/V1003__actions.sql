create table actions
(
    id  serial primary key NOT NULL,
    name varchar(128)  NOT NULL,
    begin_date date ,
    end_date date ,
    product_id int not null,
    CONSTRAINT fk_actions_products FOREIGN KEY (product_id) REFERENCES products (id)
);

insert into actions(id, name, begin_date, end_date, product_id)
values (1, 'discount 10%', '2022-01-22', '2022-01-30', 1),
       (2, 'discount 20%', '2022-05-15', '2022-05-22', 2),
       (3, '2in1', '2022-06-01', '2022-06-15', 2);