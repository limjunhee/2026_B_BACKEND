package Day09.종합예제.model.dao;

import java.util.ArrayList;

public class BoardDao {
    private BoardDao(){};
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance(){ return instance; };

    // * 추후 MYSQL 서버와 연동함 *
    private ArrayList<BoardDto> boardList = new ArrayList<>();
}
