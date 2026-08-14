package Day12.종합예제.controller;

import java.util.ArrayList;

import Day12.종합예제.model.dao.BoardDao;
import Day12.종합예제.model.dto.BoardDto;

public class BoardController {
    private BoardController() {}
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance() {return instance;}
    private BoardDao bd = BoardDao.getInstance();

    // [1]
    public boolean save(BoardDto boardDto){

        boolean result = bd.save(boardDto);
        return result;
    }

    // [2]
    public ArrayList<BoardDto> findAll(){
        ArrayList<BoardDto> result = bd.findAll();

        return result;
    }

    // [3]
    public boolean update(BoardDto boardDto){
        boolean result = bd.update(boardDto);
        return result;
    }

    // [4]
    public boolean delete(int no){
        boolean result = bd.delete(no);
        return result;
    }
}
