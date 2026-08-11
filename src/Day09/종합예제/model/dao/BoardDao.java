package Day09.종합예제.model.dao;

import java.util.ArrayList;

import Day09.종합예제.model.dto.BoardDto;

public class BoardDao {
    private BoardDao(){};
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance(){ return instance; };

    // * 추후 MYSQL 서버와 연동함 *
    private ArrayList<BoardDto> boardList = new ArrayList<>();

    //[1] 게시물 작성 로직
    public boolean save(BoardDto boardDto){
        // 1. controller으로부터 저장할 정보 객체 받는다.
        // * 추후에 insert 이용한 db에 저장
        // 2. 리스트에 저장
        boardList.add( boardDto );
        // 3. 성공반환
        return true;
    }

    //[2] 게시물 전체 조회 로직
    public ArrayList<BoardDto> findAll(){
        return boardList;
    }
}
