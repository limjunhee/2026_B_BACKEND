package Day13;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import Day12.종합예제.model.dto.BoardDto;

public class Exam1 {
    public static void main(String[] args) {
        // 라이브러리 : 다른 사람들이 만든 클래스/메소드 집합
        // [1] Object 클래스 : 자바의 최상위 클래스
        Object o1 = 3; Object o2 = 3.14; Object o3 = "문자열";
        Object o4 = true;    Object o5 = new Object[4];
        /* 모든 자료들을 Object 타입 변수에 대입 가능 */    
        // 1. toString() : 객체의 주소값을 반환하는 함수
        System.out.println( o5.toString() );    // [Ljava.lang.Object;@2ff4acd0
        System.out.println( o5 );               // [Ljava.lang.Object;@2ff4acd0 , toString()은 생략 가능
        Object o6 = new BoardDto();             // Day12의 toString()에 오버라이딩을 함
        System.out.println( o6.toString() );    // BoardDto [no=0, content=null, writer=null]
        System.out.println( o6 );               // BoardDto [no=0, content=null, writer=null] 

        // 2. equals( ) : 객체를 참조하는 값 비교 함수, 활용처: 객체 비교, *문자열* 비교
        Object o7 = new BoardDto();
        System.out.println( o6 == o7 );         // false (주소값 비교)
        System.out.println( o6.equals(o7) );    // false (주소값 비교)

        String str1 = "유재석";
        String str2 = new String("유재석");
        System.out.println( str1 == str2 );                         // false (주소값 비교)
        System.out.println( str1.equals(str2) );                    // true  (문자열 비교)
        System.out.println( str1 == "유재석");                      // true  (문자열과 문자열의 비교)
        System.out.println( str2 == "유재석");                      // false (객체와 문자열의 비교, str2는 객체로 감싸져 있으므로 다르다고 판별)
        System.out.println( str2.equals("유재석"));        // true

        // 3. hashcode( ) : 객체를 식별하는 값을 정수로 반환 * 원래의 주소값은 16(0~9abcdef)진수임  * 사람은 10진수(0~9)
        // 활용처 : 객체 탐지하는 경우에 주소값이 아닌 정수로 된 값(키) 비교하여 속도를 향상시킴
        System.out.println(o6.hashCode());          // 168423058
        System.out.println(o7.hashCode());          // 821270929
        System.out.println(str1.hashCode());        // 50621969
        System.out.println("유재석".hashCode());    // 50621969


        // [2] Class : 클래스의 정보를 담는 클래스
        // 정보 = 멤버 변수, 생성자, 메소드
        
        // 1. getclass
        String obj1 = new String();         Class c1 = obj1.getClass();
        System.out.println(c1);     // class java.lang.String -> 패키지명, 클래스명 확인

        // 2. Class.forName("패키지명.클래스명"), *일반예외 필수*
        // * 리플렉션 * : 최초 실행(컴파일)할 때 해당 클래스의 객체를 로드/생성하지 않고 실행 도중에 객체를 로드/생성
        // 활용처 : JDBC(프로그램 시작이 아닌 DB 연동시 MYSQL 관련 클래스로드), 스프링 프레임워크( IOC )
        try {
            Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        //  3. .getfields
        Field[] fields = c1.getFields();
        for(Field field : fields){System.out.println(field);} //public static final java.util.Comparator java.lang.String.CASE_INSENSITIVE_ORDER

        // 4. .getConstructors( ) : 클래스 내 생성자 정보를 반환
        Constructor[] constructors = c1.getConstructors();
        for( Constructor constructor : constructors) {System.out.println(constructor);}

        // 5. .getMethods( ) : 클래스 내 메소드 정보를 반환
        Method[] methods = c1.getMethods();
        for(Method method : methods){System.out.println(method);}
    }
}

/*
    기본 타입 : byte short int long float double char boolean
                - 리터럴 : 상수
    참조 타입 : 클래스(String, Scanner, ~DTO 등), 인터페이스(Connnection, PreparedStatement), 배열[ ]
                - 참조 = 주소       , 기본 타입 여러개를 하나로 만들 때 사용
    
*/