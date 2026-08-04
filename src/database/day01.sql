
-- 현재 자바프로젝트 폴더 내 src > database


# 한 줄 주석
-- 한 줄 주석
/* 여러 줄 주석 */

-- 데이터베이스란 : 여러 데이터를 집합한 공간
-- 데이터베이스 서버란 : 여러 데이터베이스들을 저장한 pc/프로그램( mysql )


-- [1]
-- sql 문법 작성
-- ; 으로 마친다.
-- sql 실행할 문법에 커서 두고 ctrl + enter / Run 클릭 : 실행
SHOW DATABASES; -- 현재 연결된 DB 서버 내 모든 데이터베이스 목록 확인

-- [2] 데이터베이스 로컬 경로
SHOW VARIABLES LIKE 'datadir';

-- [3] 데이터베이스 생성, 주의할 점 : sql 문법은 대소문자 구분하지 않음
CREATE DATABASE mydb1234;

-- [4] 데이터베이스 삭제, if exists = 존재하면 삭제, 주의: 없는 DB면 삭제 불가
DROP DATABASE mydb1234;

DROP DATABASE IF EXISTS mydb1234;

-- [5] 데이터베이스 활성화 : 연결된 DB 서버 내 여러 개 DB 중 조작할 DB선택
USE mydb1234;


-- [활용] : 프로젝트 데이터베이스 생성
DROP DATABASE IF EXISTS test1234;
CREATE DATABASE test1234;
USE test1234;

