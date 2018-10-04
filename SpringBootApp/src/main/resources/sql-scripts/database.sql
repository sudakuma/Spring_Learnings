CREATE DATABASE IF NOT EXISTS springbootapp;

USE springbootapp;

CREATE TABLE IF NOT EXISTS Employee(
  id bigint(5) NOT NULL AUTO_INCREMENT,
  name varchar(200) NOT NULL,
  age bigint(5) NOT NULL,
  companyname varchar(200) NOT NULL,
  salary bigint(5) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB;

show tables;


INSERT INTO Employee (id, name, age ,companyname ,salary) VALUES
	(1, 'Sudarshan Kumar', 31, 'Capgemini',20000),
	(2, 'Indrajeet Kumar', 25, 'Cisco',30000),
	(3, 'Amit', 25, 'Dell',30000); 
select * from Employee