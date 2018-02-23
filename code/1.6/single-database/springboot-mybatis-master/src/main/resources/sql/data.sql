create table company(id int(11) PRIMARY KEY auto_increment,name varchar(100) not null,schema_name varchar(40) not null);
create table users(id int(11) PRIMARY KEY auto_increment,name varchar(100),phone varchar(11) not null,companyId int(11) not null);
create table usersinfo(id int(11) PRIMARY KEY auto_increment,name varchar(100));
create table commodity (id int(11) PRIMARY key auto_increment,name varchar(100) not null,price decimal(14,2) not null,discountPrice decimal(14,2) not null,status char(1),description varchar(1000));
create table orders(id int(11) PRIMARY KEY auto_increment,order name varchar(100) not null,createTime char(10),createUserId int(11) not null);
