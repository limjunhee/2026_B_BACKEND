package Day11;

/*
    byte short int long float double char boolean = 기본 타입
    객체 = 참조 타입 : 배열[], 인스턴스(String, Dto, Scanner 등등), 인터페이스
*/

// 1. 인터페이스 만들기, interface 인터페이스명
// 2. 인터페이스의 주요 멤버: 상수, 추상 메소드(public abstract)            
// 추상 : 여러 사물이나 개념에서 공통된 특성과 본질을 뽑아내어 파악
// 3. 추상 메소드를 구현할 클래스 <구현객체> 만들기                 -> 클래스명 implements 인터페이스명, 인터페이스명, ... { }
interface ExamInterface{ 
    // 인터페이스에서는 public static final 생략해도 상수이다.
    int a = 10; // 상수
    public static final int b = 20; // 상수
    // * 생성자 없음, 즉 new()도 없음 --> 인스턴스 생성 안함(목적이 다름, 여러 인스턴스를 생성하는 게 아니라 호환시키는 데만 목적을 둠)
    // ** 추상 메소드란? : 본문 없이 선언만 존재함 == { } 구현부가 없는 메소드
    void method1(int x);
    public abstract int method2(int x, int y);
 }

class ExamClass implements ExamInterface{ // 해당 클래스가 지정한 인터페이스 구현
    // * 상속은 오버라이딩(선택) vs 구현은 오버라이딩(필수)
    // 추상 메소드에 대한 구현을 *모두* 마친다면 클래스에 오류가 사라진다.
    @Override
    public void method1(int x) {
        System.out.println(x);
    }

    @Override
    public int method2(int x, int y) {
        System.out.println(x + y);
        return x + y;
    }
}

public class Exam1 {
    public static void main(String[] args) {
        // [1] 인터페이스 만들기
        // 인터페이스로 인스턴스를 생성 불가능함

        // ExamInterface e1 = new ExamInterface(); // 생성자가 없으니 불가능

        // [2] implements 구현한 객체
        ExamClass ec = new ExamClass();
        ec.method1(10); // 가능함
        ec.method2(10, 20); // 가능함

        // [3] 다형성(업캐스팅)
        ExamInterface e1 = new ExamClass();
        // 인터페이스 타입이더라도 오버라이딩 우선
        e1.method1(10); // 가능
        e1.method2(10, 20); // 가능

    }    
}

