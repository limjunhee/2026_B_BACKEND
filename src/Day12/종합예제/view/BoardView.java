package Day12.종합예제.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Day12.종합예제.controller.BoardController;
import Day12.종합예제.model.dto.BoardDto;

public class BoardView {
    private BoardView() {} // 1.
    private static final BoardView instance = new BoardView(); // 2.
    public static BoardView getInstance() {return instance;} // 3.
    // 컨트롤러 불러옴
    private BoardController bc = BoardController.getInstance();
    // 입력 객체
    Scanner scan = new Scanner(System.in, "EUC-KR");
    // 무한 루프
    public void run(){
        while (true) {
            try {
                System.out.print("1. 등록 2. 전체조회 3. 개별수정 4. 개별삭제 선택: ");
                int ch = scan.nextInt();    
                if (ch == 1) {
                    save();
                }
                else if (ch == 2){
                    findAll();
                }
                else if (ch == 3) {
                    update();
                }
                else if (ch == 4) {
                    delete();
                }
            } catch (InputMismatchException e) {
                // 입력은 성공했지만 타입 반환에서 예외이므로 객체 초기화(이거 없으면 더 이상 입력 불가능한 상태에 빠져버림)
                scan = new Scanner( System.in, "EUC-KR"); 
                System.out.println("유효하지 않은 입력입니다.  " + e);
            }
            
        }
    }


    // [1] 등록 view
    public void save(){
        // 1.1
        System.out.print("내용 : ");    String 내용 = scan.next();
        System.out.print("작성자 : ");  String 작성자 = scan.next();

        // 1.2 자료 객체화, no(아무거나, 사용 X)
        BoardDto boardDto = new BoardDto(0, 내용, 작성자);

        // 1.3 컨트롤러에게 dto전달하여 결과 응답받기
        boolean result = bc.save(boardDto);
        if (result) {
            System.out.println(">등록 성공");
        } else { System.out.println(">등록 실패");}
    }

    // [2] 전체조회 view
    public void findAll(){
        // 1. 컨트롤러에게 모든 게시물 정보 요청하고 받기
        ArrayList<BoardDto> result = bc.findAll();
        for(BoardDto dto : result){ // 2. 반복문 이용하여 게시물정보들을 출력
            System.out.println(dto.getNo() + " / " + dto.getWriter()+" / " + dto.getContent() );
        }
    }

    // [3] 개별수정 view
    public void update(){
        System.out.print("수정할 번호: ");    int 수정할번호 = scan.nextInt();
        System.out.print("수정할 내용: ");    String 수정할내용 = scan.next();

        BoardDto boardDto = new BoardDto(수정할번호, 수정할내용, null);
        boolean result = bc.update( boardDto );
        if (result) {
            System.out.println(">수정 성공");
        } else {
            System.out.println(">수정 실패");
        }
    }

    // [4] 개별 삭제 delete
    public void delete(){
        System.out.print("삭제할 번호: ");    int 삭제할번호 = scan.nextInt();
        boolean result = bc.delete( 삭제할번호 ); // 매개변수가 1개 이므로 dto 없이함

        if (result) {
            System.out.println(">삭제 성공");
        } else {
            System.out.println(">삭제 실패(존재하지 않는 게시물)");
        }
    }
}
