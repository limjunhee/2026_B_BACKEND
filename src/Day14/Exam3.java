package Day14;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Exam3 {
    public static void main(String[] args) {
        
        // Set 인터페이스 : 여러 개 자료들을 저장하는 컬렉션, 중복을 허용하지 않으며 인덱스(순서)가 없음
        // 1. Set 구현
        Set <String> set1 = new HashSet<>();

        // 2. Set   .add(추가할 값);
        set1.add("유재석");
        set1.add("강호동");
        set1.add("유재석"); // List는 중복 허용, Set은 중복을 허용 안함
        set1.add(new String("유재석")); // 이래도 안됨 (중복방지)
        System.out.println( set1 ); // [유재석, 강호동]

        // 3. .get(인덱스); 없다. -> 인덱스가 없으니 지원 불가능
        // set1.get(0); // 인덱스 자체가 없으므로 불가

        // 4. .size();
        System.out.println(set1.size()); // 2 -> 항목의 개수를 반환

        // 5. .remove( 자료 );  인덱스 말고 자료로 찾아서 삭제
        set1.remove("강호동");
        System.out.println(set1);

        // 6. 
        // indexOf(인덱스); 지원 불가
        // contains( 찾을값 ) 지원

        // set1.indexOf(0); // 인덱스 없으니 안됨.
        set1.contains("강호동");

        // 7. .clear() : 항목 전체 삭제
        set1.clear();

        // 8. .isEmpty() : 항목이 하나도 없으면 true / false
        set1.isEmpty();

        // 9. set 컬렉션과 반복문 관계
        // 1) 일반 for문은 사용 불가능 -> index가 없으니까 불가능
        // 2) 향상된 for문 -> 가능함
        for (String str : set1){ System.out.println(str); }
        // 3) forEach() -> 가능함 , 컬렉션객체.forEach( (반복변수명) -> { } )
        set1.forEach( ( str ) -> { System.out.println(str); } );

        // - 활용처: Set ( JDBC ResultSet )
        Iterator<String> 순회자 = set1.iterator(); // 인덱스가 아닌 자료들을 순회하는 인터페이스를 반환
        while (순회자.hasNext()) { // 인터페이스를 이용한 다음 자료 확인
             System.out.println(순회자.next()); // 다음 자료 꺼내기 지원
        }; // .hasNext(): 목록(컬렉션)에서 자료 하나씩 꺼내기( 저장된 순서로 꺼내며, 순서를 보장할 수 없음 )
        // 즉) 위 코드 이용한 향상된 for문 / forEach / ResultSet 이 만들어짐

        // 11. TreeSet : 이진 트리(자료구조)를 통한 자동 정렬
        TreeSet<Integer> set2 = new TreeSet<>(); 
        set2.add(50); set2.add(70); set2.add(60);
        System.out.println( set2 ); // [50, 60, 70] : 기본값이 오름차순
        System.out.println( set2.descendingSet() ); // [70, 60, 50] : 내림차순 지원
        // descendingSet() 메소드는 set 인터페이스 내 추상 메소드가 없다.
    }
}
