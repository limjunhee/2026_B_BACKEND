# 1. 데이터베이스 생성
drop database if exists mydb0814;
-- 만약에 'mydb0814' 데이터베이스 존재하면 삭제
create database mydb0814;
-- 'mydb0814' 데이터베이스 생성
use mydb0814;
-- 'mydb0814' 데이터베이스 사용 , 워크벤치 재실행후에도
# 2. 테이블 생성
create table table1(     -- 'table1' 테이블 생성 
 num_pk int ,      -- 'num_pk' 속성/컬럼/필드 을 int 타입 선언 
    constraint primary key( num_pk ) -- 선언된 'num_pk' 속성을 pk(식별키) 설정 
);
# 2. 테이블 생성
create table table2(
 no_pk int , 
    constraint primary key( no_pk ) ,
    num_fk int ,        -- 'num_fk' 속성 을 int 타입 선언  
    constraint foreign key( num_fk ) references table1( num_pk )   -- 선언된 'num_fk'' 속성을 fk(참조키) 설정 'table1' 테이블의 'num_pk' 를 참조 
    on update cascade  on delete cascade  -- 만약에 table1 의 'num_pk' 값이 수정/삭제 되면 'num_fk' 값도 같이 수정/삭제 
);
# 3. 서로 다른 테이블 합치기 = JOIN , # PK레코드와 FK레코드를 하나의 테이블로 조회
# 샘플 데이터
insert into table1 values( 1 ) , (2) , (3) , (4) , (5);

insert into
    table2
values (1, 1),
    (2, 2),
    (3, 1),
    (4, 1),
    (5, 2);
# 레코드 조회
select * from table1;

select * from table2;

-- table : 1 2 3 4 5
-- talbe : 1 1, 3 1, 4 1, 2 2, 5 2

