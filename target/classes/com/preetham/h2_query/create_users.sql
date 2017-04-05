CREATE TABLE USER(ID INT PRIMARY KEY,
   NAME VARCHAR(255) , EMAIL VARCHAR(255));

CREATE SEQUENCE USER START WITH 1 
INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 100
  NO CYCLE 
 NOCACHE ;

insert into USER(id,name,email) values(1, 'preetham','preetham@gmail.com');
insert into USER(id,name,email) values(2, 'kp','kp@gmail.com');

select * from user;