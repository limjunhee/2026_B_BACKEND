package Day11.종합예제.controller;

import java.util.ArrayList;

import Day11.종합예제.model.dao.BoardDao;
import Day11.종합예제.model.dao.IBaseDao;
import Day11.종합예제.model.dto.BoardDto;

public class BoardController {
    private BoardController() {}
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance() { return instance; }

    private IBaseDao ib = BoardDao.getInstance();

    public boolean save(BoardDto boardDto) {
        // TODO 1: boardDto 전달받아 DAO의 save()를 호출하고 결과 반환
    }

    public ArrayList<BoardDto> findAll() {
        // TODO 2: DAO의 findAll() 호출하여 결과 반환
    }
}