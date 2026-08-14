package Day09.종합예제2.view;

import java.util.ArrayList;
import java.util.Scanner;

import Day09.종합예제2.controller.WaitingController;
import Day09.종합예제2.model.dto.WaitingDto;

public class WaitingView {
    // 싱글톤 생성
    private WaitingView(){};
    private static final WaitingView instance = new WaitingView();
    public static WaitingView getInstance(){ return instance; }

    // MVC 패턴 흐름의 controller 싱글톤 호출
    private WaitingController wc = WaitingController.getInstance();

    private Scanner scan = new Scanner(System.in, "EUC-KR");

    // [*] 메인 입출력
    public void run() {
        while (true) {
            System.out.println("1. 대기인원 추가하기 | 2.대기현황 리스트 출력 | 3. 대기현황 개별수정");
            int ch = scan.nextInt();
            if (ch == 1) {
                addWaiting();
            } else if (ch == 2) {
                findAllWaiting();
            } else if (ch == 3){
                editWaiting();
            } else if (ch == 4){
                deleteWaiting();
            }
        }
    }

    // [1] 대기내역 작성 입출력
    public void addWaiting(){
        // 1. 입력
        System.out.print("전화번호 입력 : ");       String phone_number = scan.next();
        System.out.print("총 인원수 입력 : ");      int count = scan.nextInt();

        // 2. 객체화
        WaitingDto waitingDto = new WaitingDto(phone_number, count);

        // 3. controller에게 요청하고 응답받기.
        boolean result = wc.addWaiting(waitingDto);

        // 4. 처리하기
        if (result) {
            System.out.println("대기내역 등록 성공");
        } else {
            System.out.println("대기내역 등록 실패");
        }
    }

    // [2] 대기내역 전체 출력
    public void findAllWaiting(){
        // 1. 컨트롤러로부터 모든 게시물 요청하고 받기
        ArrayList<WaitingDto> result = wc.findAllWaiting();
        for(WaitingDto waiting : result){
            System.out.println(
                waiting.getPhone_number() + " : " + waiting.getCount()
            );
        }
    }

    // [3] 대기명단 개별 수정
    public void editWaiting(){
        System.out.print("[수정] 전화번호 입력: ");     String pn = scan.next();
        System.out.print("[수정]변경할 인원 입력: ");   int new_c = scan.nextInt();

        WaitingDto waitingDto = new WaitingDto(pn, new_c);

        boolean result = wc.editWaiting(waitingDto);

        if (result) {
            System.out.println("수정 성공!");
        } else {
            System.out.println("수정 실패, 전화번호를 다시 확인하세요.");
        }
    }

    public void deleteWaiting(){
        System.out.print("명단에서 삭제하려는 연락처 입력: ");
        String pn = scan.next();
        boolean result = wc.deleteWaiting(pn);
        if (result) {
            System.out.println("삭제 성공!");
        } else {
            System.out.println("삭제 실패.");
        }
    }
}
