create table company(id int(11) PRIMARY KEY auto_increment,name varchar(100) not null,schema_name varchar(40) not null);
create table users(id int(11) PRIMARY KEY auto_increment,name varchar(100),phone varchar(11) not null,companyId int(11) not null);
create table usersinfo(id int(11) PRIMARY KEY auto_increment,name varchar(100));