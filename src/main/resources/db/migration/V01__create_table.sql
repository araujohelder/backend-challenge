CREATE TABLE tb_store
(
   id integer PRIMARY KEY NOT NULL,
   name varchar(50),   
   complement varchar(150),
   neighborhood varchar(75),
   number varchar(5),
   street varchar(100),
   city varchar(75),
   uf varchar(4),
   zipcode varchar(255)
);

create sequence tb_store_seq start 1 increment 1;

CREATE TABLE tb_order
(
   id integer PRIMARY KEY NOT NULL,
   confirmation_date DATE NOT NULL,
   status varchar(50),   
   complement varchar(150),
   neighborhood varchar(75),
   number varchar(5),
   street varchar(100),
   city varchar(75),
   uf varchar(4),
   zipcode varchar(255)
);

create sequence tb_order_seq start 1 increment 1;

CREATE TABLE tb_order_item
(
   id integer PRIMARY KEY NOT NULL,
   description varchar(50),  
   quantity integer,
   price decimal,
   id_order integer,
   FOREIGN KEY (id_order) REFERENCES tb_order (id)
);

create sequence tb_order_item_seq start 1 increment 1;

CREATE TABLE tb_payment
(
   id integer PRIMARY KEY NOT NULL,
   payment_date DATE,
   status varchar(50),   
   cred_card_number varchar(5),
   id_order integer,
   FOREIGN KEY (id_order) REFERENCES tb_order (id)
);

create sequence tb_payment_seq start 1 increment 1;
