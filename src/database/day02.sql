# [1] 데이터베이스 삭제
DROP DATABASE IF EXISTS test1234;

# [2] 데이터베이스 생성
CREATE DATABASE test1234;

# [3] show
SHOW DATABASES;

# [4] 
USE test1234; -- 데이터베이스 여러 개가 존재하므로, 사용할 DB를 선택해야 한다.


# ----------------------------------------------------------------------------------- #
# DDL : 데이터베이스 / 테이블 생성 / 삭제 / 수정 질의어 (RollBack 안됨, auto commit됨 -> 트랜잭션 불가능)

# 1) 테이블 생성 : 1. 테이블 생성할 데이터베이스 활성화 2) create table 테이블명( 속성명 타입, 속성명 타입 );
CREATE TABLE test1( 필드명1 INT, 필드명2 DOUBLE, 필드명3 TEXT );

# 2) 테이블 목록 조회
show tables;

# 3) 특정 테이블 속성 확인
DESCRIBE test1

# 4) 특정 테이블 삭제
--DROP TABLE test1

# 5) 테이블 수정하기
# 1) 새 필드 추가
ALTER TABLE test1 ADD 필드명4 FLOAT;

# 2) 필드/속성 타입 수정
ALTER Table test1 MODIFY 필드명3 longtext;

# 3) 필드/속성명, 타입 수정
alter Table test1 CHANGE 필드명1 필드명5 BIGINT;

# 6) 테이블 이름 변경하기
RENAME TABLE test1 to new_test1

# 7) 테이블 모든 레코드(행/데이터) 삭제
TRUNCATE Table new_test1;

# -------------------------------------------------------------------------------------------------#
# 테이블의 속성/필드 타입 *DBMS 회사마다 차이*
USE test1234;

CREATE TABLE test2(
    정수필드1 TINYINT , 정수필드2 SMALLINT , 정수필드3 MEDIUMINT , 
    정수필드4 INT, 정수필드5 BIGINT, 정수필드6 INT UNSIGNED,
    -- sign (부호) -> unsigned(부호가 없다). tinyint(1바이트 `128 ~ 127) --> 0 ~ 255

    실수필드1 FLOAT, 실수필드2 DOUBLE, 실수필드3 DECIMAL , -- DECIMAL : 문자 타입이면서 소수점 오차 없음

    날짜필드1 DATE, 시간필드1 TIME, 날짜시간필드1 DATETIME, -- 날짜+시간 풀로 표현하고 싶으면 DATETIME

    문자필드1 CHAR(3), 문자필드2 VARCHAR(3), 문자필드3 text, 문자필드4 longtext , 
    -- char[3] 3글자까지 저장 가능
    -- char( 문자 고정길이 ) vs VARCHAR( 문자 가변길이 )
    -- 예시) "수박" -> char( [수][박][*] ) vs varchar( [수][박] )
    -- 첨부파일(사진 등 포함된 것) 저장시 : 4GB까지 가능한 longtext 권장됨
    논리필드 BOOLEAN -- BOOLEAN(1비트) --> TINYINT(1) 마지막 필드타입 뒤로 , 넣지 말것
);

DESCRIBE test2;

# ------------------------------------------------------------------------------------------------------- #
# 속성/필드 제약 조건

CREATE TABLE test3(
    필드명1 TINYINT NOT NULL,-- 해당 필스/속성에는 null을 저장할 수 없도록 설정함 * 값이 null이면 오류가 발생한다.
    필드명2 SMALLINT UNIQUE,-- 해당 필드/속성에는 중복값을 저장할 수 없도록 설정 * 값이 다른 레코드와 같다면 오류발생
    필드명3 INT DEFAULT 100 ,-- 해당 필드/속성에 레코드 생성시 기본값 10 대입된다.
    필드명4 DATETIME DEFAULT now(), -- 예) 레코드 삽입시 현재날짜/시간/now() 자동 대입된다.
    
    필드명5 BIGINT AUTO_INCREMENT, 
    constraint PRIMARY KEY( 필드명5 ) -- 특정 필드/속성을 pk로 설정하겠다.
    -- 해당 필드 속성에 레코드(행) 삽입 시 자동으로 순서 번호를 할당, 1 2 3 4 5 6 ~
    -- PRIMARY KEY(pk) : 기본키(식별키), 식별 가능한 고유 값을 갖는 필드 ( not null + unique 내장됨 )
        -- 학번, 사번, 회원번호, 게시물코드 등
    -- FOREIGN KEY(fk) : 참조/외래 키(PK가 다른 테이블에 위치한 경우), 다른 테이블의 기본키 참조하는 키
        -- 수강신청한 학번, 급여지급사번, 판매된제품코드
        -- 참조 옵션 : PK가 삭제 혹은 수정된 경우 FK는 어떻게 할 것인가?
            -- on delete/update CASCADE     : pk가 삭제/수정되면 fk도 같이 삭제/수정
            -- on delete/update set null    : pk가 삭제 / 수정되면 fk는 null로 수정 (fk는 null 가능)
            -- on delete/update RESTRICT    : (생략시 기본값) pk가 fk로부터 참조 중이면 삭제/수정 불가능
);

create table test4(
    필드명1 BIGINT,
    constraint Foreign Key (필드명1) REFERENCES test3(필드명5) on delete CASCADE
);

# 예제 회원제 게시판 ------------------------------------------------------------------------------------------- #
# 1) 데이터베이스 생성
DROP DATABASE if EXISTS boardservice0805;
CREATE DATABASE boardservice0805;
use boardservice0805;


CREATE Table member( 
    mno int AUTO_INCREMENT,        -- 자동 회원 번호
    constraint PRIMARY KEY( mno ),   -- 회원 번호를 pk로 설정
    mid VARCHAR(30) not NULL UNIQUE, -- 회원 아이디, 최대 30글자이며 공백 불가, 중복 불가함
    mpwd VARCHAR(20) NOT NULL,      -- 회원 비밀번호, 최대 20글자, 공백 불가, 중복 가능
    mname VARCHAR(10) not NULL,     -- 회원 닉네임
    mdate DATETIME DEFAULT now()    -- 회원가입날짜/시간 , 현재 날짜/시간 자동으로 기본값 설정
 );

 CREATE Table board(
    bno int AUTO_INCREMENT,
    constraint PRIMARY KEY( bno ),   -- 게시물번호 pk 설정
    btitle VARCHAR(255),            -- 게시물 제목
    bcontent longtext,              -- 게시물 내용, 대용량(사진)포함한 최대 4G까지
    bdate DATETIME DEFAULT now(),   -- 게시물 작성일
    bview int DEFAULT 0,             -- 게시물 조회수
    mno int, -- 작성자( 회원 아이디 말고 회원 번호(PK))
    constraint FOREIGN KEY(mno) REFERENCES member(mno)
        on delete CASCADE -- 회원 탈퇴/삭제 시 그 회원이 작성한 게시물도 같이 삭제됨 (만약 게시물 존재하기 때문에 탈퇴 못하게 막겠다? RESTRICT)
 );