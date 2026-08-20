package Day14;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Exam2 {
    public static void main(String[] args) {
        /* 
            제네릭: 클래스 내 타입들을 인스턴스 생성 시 정한다.

            컬렉션(수집) 프레임(틀)워크(일)
                - 정의 : 데이터 수집(목록) 하는 자료구조(방법) 미리 만들어둔 인터페이스/클래스들
                - 목적 : 복잡한 자료들을 편리하게 사용하기 위함
                - 종류
                    List 인터페이스 : 구현체 - ArratList, Vector, LinkedList, Stack 등
                    Set 인터페이스  : 구현체 - HashSet, TreeSet 등 
                    Map 인터페이스  : 구현체 - HashMap, HashTable, TreeMap 등

            * 인터페이스 : 서로 다른 클래스들을 하나의 타입으로 제어/조작하기 위해
            * 구현체란? 인터페이스 내 추상 메소드 구현한 클래스들
            * 다형성이란? (캐스팅) 하나의 자료가 서로 다른 타입으로 변환
        */

        // [1] list 인터페이스
        ArrayList<String> list = new ArrayList<>();
        // list = new LinkedList(); // 형제끼리 타입 변환 불가

        List<String> list2 = new ArrayList<>();
        list2 = new LinkedList<>(); // 다형성(가능)

        // [2] List 인터페이스 타입으로 구현체 메소드 사용 가능 < day09 Exam1 참고 > , 구현체들이 오버라이딩을 하기 때문
        list2.add("유재석");
        System.out.println(list2.get(0));
        list2.add("강호동");
        System.out.println(list2.get(1));

        // [3] 리스트/배열과 반복문 관계 -> 리스트 내 항목 값들을 한 번에 꺼낼 수는 없음 -> 반복문으로 하나씩 열어야한다.
        // 1. 일반 for문
        for( int index = 0; index <= list2.size() - 1; index++ ){
            String str = list2.get(index);
            System.out.println( str );
        }

        // 2. 향상된 for문 :(콜론) 기준으로 오른쪽에 리스트(목록)들을 하나씩 왼쪽에 대입 반복 (단, 이 경우엔 인덱스를 확인할 수단이 없음)
        for(String str : list2){
            System.out.println( str );
        }

        // 3. foreach문(문법 X, 메소드임.) : 리스트객체.forEach( (반복변수) -> { } );
        // -> : 람다식
        list2.forEach( ( String str ) -> { System.out.println(str); } );

        /* 
            [4] List 구현체의 차이 : 사용법(함수) 동일하나 구조적 차이가 존재한다.

            ArrayList : 인덱스 기반의 배열 구조를 가짐, 동기화 미지원
                        [A] [B] [C] [D]     // E를 저장한 경우 마지막 뒤에 E 저장
                         0   1   2   3      // B 삭제한 경우 삭제된 B 이후로 C D 한 칸씩 앞으로 이동
                    
                        1000개의 자료가 있다는 가정 하에, 일부 삭제/수정 시 999번의 이동이 발생해버린다.
            ※ 맨 뒤 삽입 부분에서 강점을 보인다.
            
            LinkedList : 링크[h헤더][d본문][t꼬리] 기반의 배열 구조 = 노드 기반의 리스트 구조
                        [][ A ][B주소]     [A주소][ B ][C주소]     [B주소][ C ][D주소]     [C주소][ D ][] 
                            
                        // E를 저장한 경우 마지막 D 꼬리에 E 주소를 저장하고 E 헤더에 D 주소 저장한다.

                        // B 삭제한 경우 삭제한 노드의 꼬리에 있는 주소를 헤더노드의 꼬리에 대입 (C주소의 위치 : B꼬리 -> A꼬리)
            ※ 중간 수정 및 삭제 처리의 속도에서 강점을 보인다.


            Vector : ArrayList와 동일한 구조 + '동기화(스레드)'를 지원한다. -> 동기화 : 상태를 최신화.
        */
        
        
    }
}
