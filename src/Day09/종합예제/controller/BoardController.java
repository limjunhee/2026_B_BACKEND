package Day09.종합예제.controller;

import Day09.종합예제.model.dao.BoardDao;

public class BoardController {
    private BoardController(){}; // [1]
    private static final BoardController instance = new BoardController(); // [2]
    public static BoardController getInstance(){return instance;} // [3]

    private BoardDao bd = BoardDao.getInstance(); // * controller에서 dao 싱글톤 호출
}
