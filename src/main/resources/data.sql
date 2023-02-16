insert into course(id,name,is_deleted) 
values('10001','Mathematics',false);
insert into course(id,name,is_deleted) 
values('10002','Science',false);
insert into course(id,name,is_deleted) 
values('10003','English',false);

insert into passport(id,number)
values(40001,'E123456');
insert into passport(id,number)
values(40002,'E123457');
insert into passport(id,number)
values(40003,'E123458');

insert into student(id,name,passport_id)
values(20001,'adarsh',40001);
insert into student(id,name,passport_id)
values(20002,'Ayush',40002);
insert into student(id,name,passport_id)
values(20003,'karan',40003);




insert into review(id,rating,description,course_id)
values(60001,1,'Good',10001);
insert into review(id,rating,description,course_id)
values(60002,5,'rood',10001);
insert into review(id,rating,description,course_id)
values(60003,4,'Hood',10002);


insert into student_course(student_id,course_id)
values(20001,10001);
insert into student_course(student_id,course_id)
values(20002,10001);
insert into student_course(student_id,course_id)
values(20003,10001);
insert into student_course(student_id,course_id)
values(20003,10003);





