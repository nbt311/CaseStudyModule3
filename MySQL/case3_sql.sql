create database case3;
use case3;
create table users ( 
id int primary key auto_increment, 
name varchar(255), 
email varchar(255) unique,  
phone varchar(255) unique,
avatar varchar(255),
username varchar(255) unique,
password varchar(255),
role varchar(255));

insert into users (name,email,phone,avatar,username,password,role) 
values("DucK Anh",
"ducanh25062001@gmail.com",
"0963212083",
"webapp/Image/admin-avatar.jpg",
"admin",
"admin",
"admin"),
 ("Trump",
 "nbtrung@gmail.com",
 "0369636368",
 "webapp/Image/trump-avatar.jpg",
 "trump311",
 "123456",
 "librarian");
