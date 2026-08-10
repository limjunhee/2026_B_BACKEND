package Day09.종합예제.view;

import Day09.종합예제.controller.BoardController;

public class BoardView {
    private BoardView(){}; // [1]
    private static final BoardView instance = new BoardView(); // [2]
    public static BoardView getInstance(){return instance;} // [3]

    private BoardController bc = BoardController.getInstance(); // * view에서 controller 싱글톤 호출
}
