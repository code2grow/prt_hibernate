CREATE TABLE EMP(ID INT PRIMARY KEY,
   NAME VARCHAR(255) , DEPTID INT);

CREATE SEQUENCE EMP START WITH 1 
INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 100
 NO CYCLE 
 NOCACHE ;

insert into EMP(ID ,name,DEPTID) values(1, 'preetham',2);
insert into EMP(ID ,name,DEPTID) values(2, 'kp',2);
insert into EMP(ID, name,DEPTID) values(3, 'raghav',1);

select * from EMP;