SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;
SET default_tablespace = '';
SET default_with_oids = false;
SET search_path TO public;

DROP TABLE IF EXISTS users cascade;
DROP TABLE IF EXISTS books cascade;
DROP TABLE IF EXISTS orders cascade;
DROP TABLE IF EXISTS book_orders cascade;
DROP TABLE IF EXISTS user_details;

create table users(
  user_id serial primary key,
  user_name varchar(30) not null,
  user_email varchar(40) not null,
  user_first_name varchar(20),
  user_second_name varchar(30),
  user_password varchar(16) not null,
  is_admin boolean,
  user_credit int
);
create table user_details(
  detail_id serial primary key,
  user_city varchar(30),
  user_street varchar(20),
  user_zipcode int,
  user_street_number int,
  purchase_count int,
  feedback int,
  user_id int UNIQUE,
  foreign key (user_id) references users(user_id)
);

create table books(
  book_id serial primary key,
  book_title varchar(30),
  book_author varchar(30),
  book_page int,
  book_price int,
  stock int
);

create table orders(
  order_id serial PRIMARY KEY,
  order_price int,
  completed boolean,
  order_address varchar(50),
  order_user_id int UNIQUE,
  foreign key(order_user_id) references users(user_id)
);

create table book_orders(
  book_orders_id serial,
  book_id_order int,
  foreign key (book_id_order) references books(book_id),
  order_id_book int UNIQUE ,
  foreign key (order_id_book) references orders(order_id)
);

create or replace function balanceCheck() RETURNS trigger AS '
  BEGIN
    IF NEW.user_credit < 0 THEN
    RAISE ''Value cannot be less than zero'';
    END IF;
    RETURN NULL;
  END
  ' LANGUAGE plpgsql;

  create trigger balanceCheck
    AFTER UPDATE ON users
    FOR EACH ROW EXECUTE PROCEDURE balanceCheck();

insert into users(user_name,user_first_name,user_second_name,user_email,user_password,is_admin,user_credit) values ('Kiss János','Kiss','János','kj@gmail.com','radomhash',false,1000);
insert into users(user_name,user_first_name,user_second_name,user_email,user_password,is_admin,user_credit) values ('Valaki Valami','Valami','Valami','vv@gmail.com','radomhash',true,400);
