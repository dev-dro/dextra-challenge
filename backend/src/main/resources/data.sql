create table ingredient_menu
(
    id    bigint auto_increment primary key,
    name  varchar(250) unique not null,
    price decimal             not null
);

insert into ingredient_menu
values (1, 'Alface', 0.40),
       (2, 'Bacon', 2.00),
       (3, 'Hamburguer de Carne', 3.00),
       (4, 'Ovo', 0.80),
       (5, 'Queijo', 1.50);

create table item_menu
(
    id   bigint auto_increment primary key,
    name varchar(250) unique not null
);

insert into item_menu
values (1, 'X-Bacon'),
       (2, 'X-Burger'),
       (3, 'X-Egg'),
       (4, 'X-Egg Bacon');

create table client_order
(
    id          bigint auto_increment primary key,
    name        varchar(250) not null,
    final_price decimal      not null
);

create table item_order
(
    id              bigint auto_increment primary key,
    item_menu       bigint,
    price           decimal not null,
    client_order_id bigint,
    foreign key (item_menu) references item_menu (id),
    foreign key (client_order_id) references client_order (id)
);

create table ingredient_order
(
    id            bigint auto_increment primary key,
    name          varchar(250) not null,
    item_menu_id  bigint,
    item_order_id bigint,
    quantity      int default 1,
    foreign key (item_menu_id) references item_menu (id),
    foreign key (item_order_id) references item_order (id)
);

insert into ingredient_order
-- X-Bacon - Bacon, Hamburguer de carne, queijo
values (1, 'Bacon', 1, null, 1),
       (2, 'Hamburguer de Carne', 1, null, 1),
       (3, 'Queijo', 1, null, 1),
-- X-Burger - Hamburguer de carne e queijo
       (4, 'Hamburguer de Carne', 2, null, 1),
       (5, 'Queijo', 2, null, 1),
-- X-Egg - Ovo, Hamburguer de carne e queijo
       (6, 'Ovo', 3, null, 1),
       (7, 'Hamburguer de Carne', 3, null, 1),
       (8, 'Queijo', 3, null, 1),
-- X-Egg Bacon - Ovo, bacon, Hamburguer de carne e queijo
       (9, 'Ovo', 4, null, 1),
       (10, 'Hamburguer de Carne', 4, null, 1),
       (11, 'Queijo', 4, null, 1),
       (12, 'Bacon', 4, null, 1);
