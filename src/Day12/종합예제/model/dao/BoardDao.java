package Day12.종합예제.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Day12.종합예제.model.dto.BoardDto;

public class BoardDao extends BaseDao {
    private BoardDao() {}
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance() {return instance;}

    public boolean save( BoardDto boardDto ){
        try {
            // 1.1 SQL 작성, 값에 와일드카드(?) 이용한 매개변수 대입
            String sql = "insert into board(content, writer) values(?,?)";
            
            // 1.2 연동된 데이터베이스에 SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql); // BaseDao에서 상속받는 변수
            
            // 1.3 기재된 SQL 문법 내 ?(와일드카드) 매개변수 값 대입, ps.set 타입( ?번호, 값);
            ps.setString(1, boardDto.getContent()); // 1(첫번째 물음표)에 dto content 대입
            ps.setString(2, boardDto.getWriter());  // 2(두번째 물음표)에 dto writer 대입

            // 1.4 기재된 SQL 실행, .executeUpdate() insert/update/delete 에서 사용
            int result = ps.executeUpdate(); //실행 후 처리된 레코드 수 반환함

            // 1.5 sql 결과
            if (result == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println( e );
        }

        return false;
    }

    public ArrayList<BoardDto> findAll(){
        ArrayList<BoardDto> list = new ArrayList<>();
        try {
            // 2.1 SQL 작성한다.
            String sql = "select * from board";

            // 2.2 SQL 기재한다 *예외발생*
            PreparedStatement ps = conn.prepareStatement(sql);
            
            // 2.3 ? 매개변수 대입한다. <생략>
            // 2.4 기재된 SQL 실행
            ResultSet rs = ps.executeQuery(); // 2.4 기재된 SQL문 실행, .executeQuery() select

            // 2.5 SQL 결과 ( select 조회 결과는 항상 테이블로 반환한다. ) 즉) 레코드 하나씩 타입변환
            while (rs.next()) { // rs.next() : 다음 레코드(행)으로 이동, 마지막 레코드까지 하나씩 반복하겠다는 뜻

                // 2.6 현재 레코드(DB) 정보 --> DTO 변환
                BoardDto boardDto = new BoardDto();
                boardDto.setNo( rs.getInt("no")); // rs.get타입( "가져올속성명" );
                boardDto.setContent( rs.getString("content"));
                boardDto.setWriter(rs.getString("writer"));

                // 2.7 변환한 DTO --> 리스트에 담기
                list.add( boardDto );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        // 2.8
        return list;
    }


    public boolean update(BoardDto boardDto){
        try {
            String sql = "update board set content = ? where no = ?";// 1. sql작성
            PreparedStatement ps = conn.prepareStatement(sql);// 2. sql 기재 * 예외처리 *
            
            ps.setString(1, boardDto.getContent());// 3. sql 내 ? 매개변수 대입
            ps.setInt(2, boardDto.getNo());
            
            int result = ps.executeUpdate();// 4. sql 실행
            
            if (result == 1) { // 5. 실행 결과 반환
                return true;
            }
        } catch (SQLException e) {
            System.out.println( e );
        }

        return false; // 5. 실행 결과 반환
    }

    public boolean delete(int no){
        try {
            String sql = "delete from board where no = ?"; // sql 작성
            PreparedStatement ps = conn.prepareStatement(sql); //기재

            ps.setInt(1, no); // ?에 no 대입

            int result = ps.executeUpdate();

            if (result == 1) {
                return true;
            }
        } catch (Exception e) {
            System.out.println( e );
        }
        return false;
    }
}