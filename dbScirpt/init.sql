CREATE DATABASE IF NOT EXISTS demo;
user demo;
CREATE TABLE user_lg(
   id int PRIMARY KEY  auto_increment,
   ip VARCHAR (20),
   last_address varchar(50),
   last_date  varchar(30)
);