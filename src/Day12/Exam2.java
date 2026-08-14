package Day12;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exam2 {
    public static void main(String[] args) {
     
    // JDBC란 자바와 데이터베이스 연동을 제공하는 인터페이스다.
    // 1. mysql-connector-j-26.7.0.jar 파일 lib 폴더에 저장

    //[연동]
    //[1] MySql 회사에서 제공하는 Driver 구현체 (동적) 로드 * 예외처리 필수 *
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver 연동 성공");    
        //[2] 데이터베이스 서버 연동
        // DriverManager.getConnection("jdbc:mysql://localhost:3306/데이터베이스명", "계정명","비밀번호");
        String url = "jdbc:mysql://127.0.0.1:3306/mydb0813";
        String user = "root"; String password = "1234";
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("데이터베이스 연동 성공");

        // [3] 연동된 데이터베이스 내 DML(insert, update, delete) 조작
        // 1. insert 하기
        String sql = "insert into test( name ) values( '유재석' ) "; // 자바 문자열에 SQL 작성(자동완성 안됨)
        PreparedStatement ps = conn.prepareStatement(sql); 
        // conn(연동된 인터페이스).prepareStatement( 기재할 SQL );
        // PreparedStatement(SQL이 기재된 인터페이스)
        int result = ps.executeUpdate(); // ps( SQL 기재된 인터페이스에서 SQL 실행)
        System.out.println( result ); // 1: 성공 / 0 : 실패
        System.out.println("레코드 등록 성공");

        // 2. select 하기, select 필드명 from 테이블명;
        String sql2 = "select * from test";
        PreparedStatement ps2 = conn.prepareStatement(sql2); // 작성한 SQL 기재하기
        ResultSet rs = ps2.executeQuery(); // 기재된 SQL 실행, 결과를 rs(ResultSet) 인터페이스 대입
        rs.next(); //조회 결과에서 다음 레코드 이동
        System.out.println(rs.getInt("no")); // rs.get타입("속성명")
        System.out.println(rs.getString("name")); // rs.get타입("속성명")
        System.out.println("레코드 조회 성공");
    } catch (ClassNotFoundException e) {
        System.out.println("Driver [클래스]가 존재하지 않습니다." + e ); // 라이브러리 설치 안됨
    } catch ( SQLException e ){
        System.out.println("DB서버와 연동 실패" + e);
    }
       
    }
}
