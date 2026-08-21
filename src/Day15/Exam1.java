package Day15;

import java.util.HashMap;
import java.util.Map;

public class Exam1 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();

        map.put("유재석", 95);
        map.put("강호동", 100);
        map.put("신동엽", 78);
        map.put("유재석", 80); // 같은 키에 또 put하면 value가 수정된다.
        System.out.println( map ); // {유재석=80, 강호동=100, 신동엽=78}

        // .get("key") : map 객체 내 key와 value를 한 쌍으로 저장, key는 중복불가, value는 중복가능
        System.out.println(map.get("유재석")); // 80

        // .size() : map 객체 내 전체 엔트리 개수 반환
        System.out.println(map.size()); // 3

        // .containsKey( 찾을키 ) : 찾을 키가 존재하면 true, 없으면 false
        // .containsValue( 찾을값 ) : 찾을 값이 존재하면 true, 없으면 false
        System.out.println(map.containsKey("강호동")); // true
        System.out.println(map.containsValue(95)); // false

        // .keySet : 객체 내 모든 키 반환
        // .values : 객체 내 모든 밸류 반환
        System.out.println(map.keySet());
        System.out.println(map.values());

        // .remove(key) : 해당하는 키의 엔트리(key:value) 삭제
        map.remove("강호동");   System.err.println(map); // {유재석=80, 신동엽=78}

        // .clear : map 객체 내 모든 엔트리 삭제
        map.clear();

        // .isEmpty( ) : 객체 내 엔트리가 없으면 true / 없으면 false
        System.out.println(map.isEmpty());
        
        /*
            * 활용처 
            1) JSON <-- 통신 --> DTO/MAP(JAVA)
            2) 자료구조(암호화) 등등
        */

        // - map과 반복문 -

        // 1. 인덱스 없어서 일반 for문 불가능
        // 2. 향상된 for문 -> key를 주로 사용(모든 키를 꺼내서 반복문에 응용)
        for(String key : map.keySet()){
            System.out.println(key +":"+ map.get(key)); // 키 이용한 값을 호출
        }
        // 3. 컬렉션.forEach( (반복변수명) -> {실행문})
        map.keySet().forEach( (key) -> { System.out.println( key + ":" + map.get( key ) ); } );
    }
}
