package Day11;

public class Exam3 {
    public static void main(String[] args) {
        Car myCar = new Car();
        Car yourCar = new Car();

        // myCar.run(); // 오류, 타이어 없음

        // 2.
        // myCar.tire = new Tire(); // 인터페이스로 객체 생성 불가능.

        // 3.
        myCar.tire = new HankokTire();
        myCar.run(); //한국타이어 회전

        // 4.
        myCar.tire = new KumhoTire();
        myCar.run(); // 금호타이어 회전

        // 5.
        System.out.println(myCar.tire instanceof Tire); // true
        System.out.println(myCar.tire instanceof KumhoTire); // true
        System.out.println(myCar.tire instanceof HankokTire); // false

        // [*] 익명 구현체 : 일회성 사용하는 인터페이스 구현체
        // *자체적으로 추상 메소드 오버라이딩*
        // new 인터페이스명() { 오버라이딩 }
        myCar.tire = new Tire(){
            @Override
            public void roll() {
                System.out.println("일회성 타이어 회전");
            }
        };
        myCar.run(); // 일회성 타이어 회전

    }
}

class Car {
    Tire tire; // 인터페이스 받는 멤버변수?
    void run( ) { this.tire.roll();}
}

interface Tire{
    void roll(); // 추상 메소드 정의
}

//구현체
class HankokTire implements Tire {
    // 추상 메서드 구현(재정의)
    @Override
    public void roll() {
        System.out.println("[한국] 타이어 회전");
    }
}

class KumhoTire implements Tire {
    @Override
    public void roll() {
        System.out.println("[금호] 타이어 회전");
    }
}