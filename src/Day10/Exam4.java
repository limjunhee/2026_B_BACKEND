package Day10;

public class Exam4 {
    public static void main(String[] args) {
        Car myCar = new Car();          // 인스턴스 1 생성 -> Day10.Car@54bedef2
        System.out.println(myCar);
        Car yourCar = new Car();        // 인스턴스 2 생성 -> Day10.Car@5caf905d
        System.out.println(yourCar);

        myCar.tire = new Tire();            // myCar에 Tire 대입
        myCar.run();                        // [일반] 타이어가 회전

        //yourCar.run();                    // yourCar에는 아직 타이어 없는 상태[오류]
        System.out.println("============================================================");
        myCar.tire = new HankookTire();     // myCar에 HankookTire 대입
        myCar.run();                        // [한국] 타이어가 회전(업그레이드)

        yourCar.tire = new Tire();          // yourCar에 Tire 대입
        yourCar.run();                      // [일반] 타이어가 회전
        System.out.println("============================================================");
        myCar.tire = new KumhoTire();       // myCar에 KumhoTire 대입
        myCar.run();                        // [금호] 타이어가 회전(업그레이드)

        yourCar.tire = new HankookTire();   // yourCar에 HankookTire 대입
        yourCar.run();                      // [한국] 타이어가 회전(업그레이드)

        System.out.println(myCar.tire instanceof Tire); // true
        System.out.println(myCar.tire instanceof KumhoTire); // true
        System.out.println(myCar.tire instanceof HankookTire); // false

        System.out.println(yourCar.tire instanceof Tire); // true
        System.out.println(yourCar.tire instanceof KumhoTire); // false
        System.out.println(yourCar.tire instanceof HankookTire); // true

        // 인스턴스 1개당 멤버변수를 각각 생성      ( 상태 )
        // 인스턴스 여러개는 하나의 메소드를 공유   ( 행위 )
        // 상속의 다형성 = 타입 변환간의 호환성 
        // 클래스를 생성할 때 코드가 중복된다면 부모 클래스 만들기
        // 일반 코드가 중복되면 함수를 만들기
        // 특정 패턴이 있는 코드가 중복되면 반복문 만들기
    } // main
} // class end

class Car { // 자동차
    Tire tire; // 하위 클래스의 메소드 받는 멤버변수? (초기값 없음)

    void run() {
        this.tire.roll(); // 현재 tire가 가리키는 (Tire 클래스 / 한국타이어 클래스 / 금호타이어 클래스)의 roll() 메소드 실행
    }
}

class Tire { // 타이어
    Tire(){
        System.out.println("1. 타이어 장착");
    }
    void roll() {
        System.out.println("[일반] 타이어가 회전");
    }
}

class HankookTire extends Tire { // 한국타이어
    HankookTire(){
        System.out.println("2. 한국타이어 장착");
    }
    void roll() {
        System.out.println("[한국] 타이어가 회전(업그레이드)");
    }
}

class KumhoTire extends Tire { // 금호타이어
    KumhoTire(){
        System.out.println("3. 금호타이어 장착");
    }
    void roll() {
        System.out.println("[금호] 타이어가 회전(업그레이드)");
    }
}