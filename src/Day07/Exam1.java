package Day07;
/*
    함수 -> 기능을 수행하는 코드 집합
    메소드 -> 자바에서는 메소드라고 부름

    메소드
        1) 클래스 내부 선언
        2) 목적 : 재사용하기 , 인수에 따른 서로 다른 결과물 이끌어내기
        3) 선언
            반환타입 메소드명( 타입 매개변수 ){ 
                return 반환값
            }
            - 반환타입 : 반환값의 타입/자료형 뜻
            - 메소드명 : 소문자 시작하는 카멜 표기법
            - 타입 매개변수 : 함수호출 하는 곳으로부터 전달받는 값 타입 일치시켜야 한다.
            - { } : 함수 호출시 실행할 코드
            - return : 함수 종료시 반환되는 값

        4) 호출 : 다양한 기준
            1. 서로 다른 클래스에서 메소드를 호출시 인스턴스(객체) 필요
                주체: this( 특정 메소드/생성자 호출한 객체)
                객체변수명.메소드명();
            2. 동일한 클래스내 메소드 호출 시 인스턴스 필요 없다.
                메소드명( );

            ★ 매개변수는 *지역변수*임
*/
public class Exam1 {
    public static void main(String[] args) {

        // 1
        사람 유재석 = new 사람();
        사람 강호동 = new 사람();
        유재석.달리기();
        // 2
        계산기 나만의계산기 = new 계산기();
        double pi = 나만의계산기.getPI();

        // 3
        나만의계산기.powerOn();

        // 4
        int result = 나만의계산기.add(10, 5);


        // 주의점 : this(주체) 인스턴스 식별할 것.

        // 사람타입
        사람타입 p1 = new 사람타입("강호동");
        사람타입 p2 = new 사람타입("유재석");

        p1.취업성공("개발자");
        System.out.println(p1.job); // 개발자 출력
        System.out.println(p2.job); // null 출력


    }
}

class 계산기{
    // 1. 멤버변수
    // 2. 생성자
    // 3. 메소드/함수

    // 1) 매개변수X, 반환값O
    double getPI(){
        return 3.14;
    }

    // 2) 매개변수X, 반환값X
    void powerOn(){
        System.out.println("ON");
        return;
    }

    // 3) 매개변수O, 반환값X
    void printSum( int x , int y){
        System.out.println( x + y );
    }

    // 4) 매개변수O, 반환값O
    int add( int x, int y ){
        // 동일한 클래스 내 다른 메소드 호출하기
        printSum( x, y );
        return x + y ;
    }
}

class 사람 {
    String name;

    void 달리기(){
    }
}

class 사람타입{
    // 사랑미 가져야할 상태 설계 = 멤버 변수
    String name;
    int age;
    String job;

    // 사람이 태어날 때 조기로 가져야할 설계 = 생성자
    사람타입( String name ){
        this.name = name;
        age = 1;
    }   

    // 취업(행위) 연결
    void 취업성공(String 취업한직업) {
        this.job = 취업한직업;
        return;
    }
}

