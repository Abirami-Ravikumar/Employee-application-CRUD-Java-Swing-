create database employeemanagementsystem;

show databases;

use employeemanagementsystem;

create table login(username varchar(20),password varchar(20));
insert into login values('admin','12345');


create table employee(name varchar(20), fname varchar(20), dob varchar(30), salary varchar(20),
 address varchar(100), phone varchar(10), email varchar(20), higher varchar(20), desig varchar(20), 
 aadhaar varchar(20), empid varchar(10) unique key not null);