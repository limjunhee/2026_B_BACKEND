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

    // Object타입으로 Dao에 넘겨줘야함
    public boolean save(BoardDto boardDto) {
        // TODO 1: boardDto 전달받아 DAO의 save()를 호출하고 결과 반환
        Object obj1 = boardDto;
        boolean result = ib.save(obj1);
        return result;
    }

    public ArrayList<BoardDto> findAll() {
        // TODO 2: DAO의 findAll() 호출하여 결과 반환
        ArrayList<Object> list = ib.findAll(); // 저장된 게시글 전체가져오라고 findAll 호출후 결과를 ArrayList<Object> list 에 담는다
        ArrayList<BoardDto> result = new ArrayList<>(); // 게시글전용 목록을생성한다
        for (Object item : list) { // DAO가 준 Object를 하나씩 꺼내서
            result.add((BoardDto) item); // boardDto 로 형변환한 뒤
        } // 게시글 전용 result에 넣기
          // **강제형변환 안됨!! Object 와 BoardDto는 상속관계이지만 ArrayList<Object>와
          // ArrayList<BoardDto>는 상속관계 X
        return result;
    }
}