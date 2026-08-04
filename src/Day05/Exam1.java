package Day05;

/*
    1. 객체(Object)란? ->  상태와 행위를 정의하는 것
        -> 반대되는 개념 : 주체(본인)
        -> 상태(값/자료), 행위(함수/메소드)


    2. 객체지향 프로그래밍 : 개발자(주체)가 컴퓨터내 객체(대상) 만들기
    3. 객체 정의 : class 기반으로 객체 정의
    4. 클래스란? 객체(추상)의 상태와 행위 코드로 정의한 곳
        1) 설계 클래스(객체 정의 용도)
        2) main 함수 클래스(실행 목적)
    5. 인스턴스 : 클래스로 객체가 정의된 기반으로 메모리 할당 ( 물리 개념 )
        new 연산자 이용
        * 8가지 기본 타입 (boolean, char, byte, short, int, long, float, double)
        * 8가지 외 커스텀 타입 -> 클래스 타입 -> 참조 타입
        
        즉 클래스란? -> 존재하지 않는 타입을 만드는 것만 동일
*/

public class Exam1 {
    public static void main(String[] args) {
        /*
         * [1] 객체 만들기
         * (1)클래스 정의 : .java 새롭게 만들기 / 현재 파일 class{ } 밖에 만들기
         * class 클래스명 { 상태; 행위; }
         * 
         * (2) 클래스 { } 안에서 상태(멤버변수)와 행위(메소드) 코드 작성
         * (3) 실행문(main 함수) 애서 객체 생성 : 타입명 변수명 = new 생성자(인수)
         *      - class 타입도 참조 타입임.(기본 타입이 아님)
         *      - class 타입은 첫글자 대문자, 기본타입 소문자, 변수명 소문자시작 관례
         *      - new 인스턴스화 : 클래스 기반으로 (heap)메모리 할당
         *      - Student 생성자 : 클래스명과 동일하며 메소드/함수 비슷한 역할을 해줌
         */
        Student s1 = new Student( );

        // [2] 객체 사용/참조, .(접근/도트/이동)연산자 이동하여 멤버 접근
        System.out.println( s1 ); // 객체 저장하고 있는 변수명 작성 -> 주소값을 반환(Day05.Student@54bedef2)
        System.out.println( s1.studentName); //객체 저장하고 있는 변수명.멤버변수명 -> null

        // [3] 객체 내 멤버변수 값 수정
        s1.studentName = "유재석"; // 1) 변수명.멤버변수명 = 새로운 값
        System.out.println(s1.studentName);
        s1.studentId = 10; // { 'studentName' : '유재석', 'studentId' : 10 }
        System.out.println(s1.studentId);

        // * 주의: new 연산자 *1개당* *하나의 인스턴스*를 생성
        Student s2 = new Student(); // 인스턴스 생성
        Student s3 = new Student(); // 인스턴스 생성
        Student s4 = s2;            // 인스턴스를 새로운 곳에 참조시킴 -> 결론적으로 s2,s3 인스턴스 2개만 있음

        System.out.println(s2); // Day05.Student@5caf905d
        System.out.println(s3); // Day05.Student@27716f4
        System.out.println(s4); // Day05.Student@5caf905d -> s2의 주소값을 가리키고 있음
        
        s2.studentName = "강호동";
        System.out.println(s2.studentName); 
        System.out.println(s4.studentName); // 똑같이 "강호동"
    }   
}

// '학생' 추상 개념 -> 코드화
class Student { 
    // 멤버 변수(상태)
    int studentId; // 타입 변수명;              클래스 안에서 선언된 변수를 *멤버/인스턴스 변수*라고 한다.
    String studentName; // 타입 변수명;         

}

// 자바는 무조건 class 단계로 객체를 만