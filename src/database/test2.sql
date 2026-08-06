drop DATABASE if EXISTS project;

create database project;

show DATABASES;

use project;

show tables;

create table brandtable (
    brandid int PRIMARY key AUTO_INCREMENT,
    brandname VARCHAR(20),
    brandlogo VARCHAR(50)
);

create table cigartable (
    cigarid int PRIMARY key,
    brandid int,
    constraint FOREIGN key (brandid) REFERENCES brandtable (brandid),
    cigarname VARCHAR(20),
    category VARCHAR(10),
    price int,
    nicotine double,
    tar double,
    iscapsule BOOLEAN,
    cigarimg VARCHAR(30)
);

create table membertable (
    memberid int PRIMARY key AUTO_INCREMENT,
    userid int,
    userpw int,
    username VARCHAR(10),
    userphoto VARCHAR(50)
);

create table listtable (
    listid int PRIMARY key,
    memberid INT,
    constraint FOREIGN key (memberid) REFERENCES membertable (memberid),
    listtitle VARCHAR(20),
    listday date,
    thumbsup int,
    thumbsdown int
);

create table reviewtable (
    reviewid int PRIMARY key AUTO_INCREMENT,
    cigarid int,
    constraint FOREIGN key (cigarid) REFERENCES cigartable (cigarid),
    memberid int,
    constraint FOREIGN key (memberid) REFERENCES membertable (memberid),
    review VARCHAR(50),
    score int,
    listday date
);