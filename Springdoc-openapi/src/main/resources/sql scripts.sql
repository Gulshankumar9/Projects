show databases ;
 
create database openApi;

use openApi;

create database Hello;
use Hello;

drop table teachers;
drop table students;

CREATE TABLE teachers (
    teacher_id INT,
    university_id INT,
    teacher_name VARCHAR(100),
    subject_id INT,
    PRIMARY KEY (teacher_id, university_id)
);

CREATE TABLE students (
    student_id INT,
    university_id INT,
    student_name VARCHAR(100),
    subject_id INT,
    PRIMARY KEY (student_id, university_id)
);
INSERT INTO teachers (teacher_id, university_id, teacher_name, subject_id)
VALUES
    (1, 1001, 'John Smith', 101),
    (2, 1002, 'Jane Doe', 102),
    (3, 1003, 'Michael Johnson', 103),
    (4, 1004, 'Emily Williams', 104),
    (5, 1005, 'Robert Brown', 105);

INSERT INTO students (student_id, university_id, student_name, subject_id)
VALUES
    (1, 1001, 'Student A', 101),
    (2, 1002, 'Student B', 102),
    (3, 1003, 'Student C', 103),
    (4, 1004, 'Student D', 104),
    (5, 1005, 'Student E', 105);


select * from teachers;
select * from students;



