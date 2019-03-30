 create database studentassessment;
 create table student(id int primary key auto_increment,name varchar(30),year_level int not null);
 create table subject (id int primary key auto_increment,name varchar(50),student_id int, foreign key(student_id) references student(id));
 create table assessment (id int,type varchar(80),topic varchar(80),format varchar(80),grade tinyint(1),subject_id int,dueDate varchar(40), primary key(subject_id,id) );
 create table grade (id int,degree varchar(12) primary key,knowledge varchar(100),skill varchar(250));
 create table student_grade(student_id int,subject_id int,assessment_id int,grade_id int,primary key(student_id,subject_id,assessment_id,grade_id));
 
 insert into grade values(1,'Very_high','thorough understanding','uses a high level of skill in both familiar
and new situations'),(2,'High','clear understanding','uses a high level of skill in familiar situations, and is beginning to use skills in new situations'),
(3,'Sound','understanding','uses skills in situations familiar to them'),
(4,'Developing','understands aspects of','uses varying levels of skill in situations familiar to them'),
(5,'Emerging','basic understanding','beginning to use skills in familiar situations');