drop database ratingdb;
drop user rating;
create user rating with password 'password';
create database ratingdb with template=template0 owner=rating;
\connect ratingdb;
alter default privileges grant all on tables to rating;
alter default privileges grant all on sequences to rating;

create table et_user(
user_id SERIAL primary key not null,
user_name varchar(20) not null,
user_surname varchar(20) not null,
user_username varchar(30) not null,
user_password text not null
);

create table et_restaurant(
id SERIAL primary key not null,
name varchar(20) not null,
rating varchar(20) not null,
range varchar(50) not null,
hours varchar(20) not null,
city varchar(20) not null
);

create table et_bistro(
id SERIAL primary key not null,
name varchar(20) not null,
rating varchar(20) not null,
range varchar(50) not null,
hours varchar(20) not null,
city varchar(20) not null
);

create table et_take_away(
id SERIAL primary key not null,
name varchar(20) not null,
rating varchar(20) not null,
range varchar(50) not null,
hours varchar(20) not null,
city varchar(20) not null
);
