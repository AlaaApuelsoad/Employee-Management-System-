CREATE DATABASE  IF NOT EXISTS demo;
USE demo;
--
-- Table structure for table `qnet_employee`
--
Drop table if exists qnet_employees;

CREATE TABLE qnet_employees(
  id int NOT NULL AUTO_INCREMENT,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  age int NOT NULL,
  department varchar(45) Default Null,
  salary int Not Null,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-
-- Data for table `qnet_employee`
--

INSERT INTO qnet_employees VALUES 
	(1,'John','Doe','John.doe@foo.com',35,'HR',15000),
    (2,'Maryy','Jane','Marry.doe@foo.com',30,'Engineering',12000),
    (3,'Peter','Kane','Peter.doe@foo.com',25,'Acoountant',8000),
    (4,'Leslie','Han','Leslie.doe@foo.com',27,'Customer Service',9000),
    (5,'Bruce','Wayne','Bruce.doe@foo.com',50,'Legal',13000),
    (6,'Randy','Pau','Randy.doe@foo.com',37,'HR',15000);
	
