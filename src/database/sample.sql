-- day12 Exam2와 연동
DROP DATABASE if EXISTS mydb0813;
create DATABASE mydb0813;

use mydb0813;

create table board( 
    no int AUTO_INCREMENT,
    content VARCHAR(30),
    writer VARCHAR(30),
    constraint PRIMARY KEY (no)
);

insert INTO board( content, writer ) values("안녕하세요", "유재석"),("하하", "유재석");