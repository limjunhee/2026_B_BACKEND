package Day09.종합예제2.model.dao;

import java.util.ArrayList;

import Day09.종합예제2.model.dto.WaitingDto;

public class WaitingDao {
    private WaitingDao(){};
    private static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance(){ return instance; }

    // * 데이터베이스 대신에 ArrayList 사용하여 데이터베이스 표/데이터 역할 *
    private ArrayList<WaitingDto> waitingList = new ArrayList<>();

    // [1] 대기내역 추가 로직
    public boolean addWaiting(WaitingDto waitingDto){
        // 1. 매개변수 - controller로부터 저장할 정보 객체 받음

        // 2. 리스트에 저장하기
        waitingList.add(waitingDto);

        // 3. 성공 반환
        return true;
    }

    // [2] 대기내역 전체 조회 로직
    public ArrayList<WaitingDto> findAllWaiting(){
        // 1.컨트롤러에 매개변수 받기(없음)

        // 2. 리스트 전체 반환
        return waitingList;
    }

    // [3] 개별 대기내역 수정 로직
    public boolean editWaiting(WaitingDto waitingDto){
        // 1. 매개변수 - 찾고 있는 전화번호와 변경할 인원수
        // 2. 결과(bool)를 반환할 변수
        boolean result = false;
        for(WaitingDto dto : waitingList){ //향상된 for문 이용
            if (dto.getPhone_number().equals(waitingDto.getPhone_number())) {// 전화번호가 일치한다면?
                int newdto = waitingDto.getCount();
                dto.setCount(newdto);
                result = true;
            }
        }
        return result;
    }

    // [4] 개별 대기내역 삭제 로직
    public boolean deleteWaiting(String pn){
        boolean result = false;
        for(WaitingDto dto : waitingList){
            if (dto.getPhone_number().equals(pn)) {
                waitingList.remove(dto);
                result = true;
            }
        }

        return result;
    }
}
