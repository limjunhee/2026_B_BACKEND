package Day09.종합예제2.controller;

import java.util.ArrayList;

import Day09.종합예제2.model.dao.WaitingDao;
import Day09.종합예제2.model.dto.WaitingDto;

public class WaitingController {
    // 싱글톤 생성
    public WaitingController(){};
    private static final WaitingController instance = new WaitingController();
    public static WaitingController getInstance(){ return instance; }

    // MVC 패턴 흐름의 dao 싱글톤 호출
    private WaitingDao wc = WaitingDao.getInstance();

    // [1] 대기내역 추가 컨트롤러
    public boolean addWaiting(WaitingDto waitingDto){
        // 1. 매개변수 - view로부터 저장할 정보 객체로 받음

        // 2. DAO에게 요청하고 응답받기
        boolean result = wc.addWaiting(waitingDto);

        // 3. DAO에게 받은 결과를 VIEW에게 응답하기
        return result;
    }

    // [2] 대기내역 전체 조회 컨트롤러
    public ArrayList<WaitingDto> findAllWaiting(){
        // 1. 현재는 view로부터 받아올 매개변수 X

        // 2. dao에게 요청하고 응답받기
        ArrayList<WaitingDto> result = wc.findAllWaiting();
        return result;
    }

    // [3] 대기내역 전체 수정 컨트롤러
    public boolean editWaiting(WaitingDto waitingDto){
        if (waitingDto == null) {
            return false;
        }
        boolean result = wc.editWaiting(waitingDto);
        return true;
    }

    // [3] 대기내역 전체 수정 컨트롤러
    public boolean deleteWaiting(String pn) {
        if (pn == null) {
            return false;
        }
        boolean result = wc.deleteWaiting(pn);
        return true;
    }
}
