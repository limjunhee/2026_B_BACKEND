package Day09;

import java.util.ArrayList;

public class Exam1 {
    public static void main(String[] args) {
        /*
         * 배열 : 여러개 (동일한타입) 자료들을 저장하는 타입, 정적 길이
         * ArrayList 클래스:
         * 
         * 1. 컬렉션(수집) 프레임(틀)워크(일), 자료 수집관련 클래스/기능 제공
         * 
         * 2. 목적: 가변길이, 배열 관련된 기능(메소드) 제공한다. <편리함>
         * 
         * 3. 사용법
         *      ArrayList<제네릭타입> 변수명 = new.ArrayList();
         *      - 제네릭타입: 리스트 내 저장할 요소들의 타입, 즉) < String > 리스트에 여러 개 String 저장
         *      - 주의할 점 : <제네릭타입>은 기본타입이 불가능하다. int -> Integer 래퍼타입( 기본타입을 클래스 타입으로 씀)
         * 
         * 4. 주요메소드
         *      1.  .add( 자료 )          : 리스트 요소 추가
         *      2.  .add( 인덱스 , 자료 ) : 리스트 중간 삽입
         *      3.  .set( 인덱스 , 자료 ) : 리스트 특정 인덱스 요소 수정
         *      4.  .size()               : 리스트 내 요소 개수 반환
         *      5.  .get( 인덱스 )        : 리스트 특정 인덱스 요소 값 반환
         *      6.  .remove( 인덱스 )     : 리스트 특정 인덱스 삭제
         *      7.  .clear()              : 리스트 요소 전체 삭제
         *      8.  .indexOf( 찾을값 )    : 리스트 내 찾을 값이 존재하면 인덱스 번호를 반환, 없다면 -1 반환
         *      9.  .contains( 찾을값 )   : 리스트 내 찾을 값이 존재하다면 true, 없다면 false 반환
         *      10. .isEmpty()            : 리스트가 비어있다면 true, 요소값이 있다면 false 반환
         */
        
        // [1] 리스트 생성
        ArrayList< String > 변수명1 = new ArrayList<>(); // String 타입 여러개 저장하는 리스트
        
        // [2] 리스트 요소 추가
        변수명1.add("유재석");  
        변수명1.add("강호동");
        변수명1.add("신동엽");

        // [3] 리스트 전체 출력
        System.out.println( 변수명1 ); // 출력: [유재석, 강호동, 신동엽]

        // [4] 리스트 중간 삽입
        변수명1.add(1, "하하"); // 1번 인덱스 자리에 요소를 추가
        System.out.println(변수명1); // 출력: [유재석, 하하, 강호동, 신동엽]

        // [5] 리스트 요소 수정
        변수명1.set(1,"서장훈"); // 1번 인덱스 자리의 요소를 수정
        System.out.println(변수명1); // 출력: [유재석, 서장훈, 강호동, 신동엽]

        // [6] 리스트 요소 총 개수
        System.out.println(변수명1.size()); // 출력: 4

        // [7] 리스트 내 특정 요소 출력
        System.out.println(변수명1.get(1)); // 1번 인덱스 요소값 호출 -> 출력: 서장훈

        // [8] 리스트 내 요소 삭제
        변수명1.remove(1); // 1번 인덱스(두 번째) 요소 값 삭제
        System.out.println(변수명1); // 출력: [유재석, 강호동, 신동엽]

        // [9] 리스트 요소 찾기
        System.out.println(변수명1.indexOf("강호동")); // '강호동' 값의 인덱스 반환 없으면 -1, 있으면 인덱스 반환
        System.out.println(변수명1.contains("강호동")); // '강호동' 값이 배열 내에 없으면 false, 있으면 true

        // [10] 반복문과 리스트 관계
        // 1. 일반 for문
        for ( int index = 0; index < 변수명1.size() - 1; index++ ) { String str = 변수명1.get(index); }

        // 2. 향상된 for문, 콜론(:) 기준 오른쪽 리스트 내 요소 하나씩 왼쪽에 반복 대입
        for ( String str : 변수명1 ) { }

        // [11] 리스트 전체 삭제
        변수명1.clear();
        System.out.println(변수명1); //출력: []

        // [12] 리스트 요소 여부 확인
        System.out.println(변수명1.isEmpty()); // 리스트 내 요소가 하나도 없으면 true, 있으면 false
    }
}
