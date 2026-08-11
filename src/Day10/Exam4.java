package Day10;

public class Exam4 {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.tire = new Tire();
        myCar.run();
        System.out.println("===============");
        myCar.tire = new HankookTire();
        myCar.run();
        System.out.println("===============");
        myCar.tire = new KumhoTire();
        myCar.run();
        System.out.println(myCar.tire instanceof Tire); // true
        System.out.println(myCar.tire instanceof KumhoTire); // true
        System.out.println(myCar.tire instanceof HankookTire); // false

    } // main
} // class end

class Car { // 자동차
    Tire tire; // 하위 클래스의 메소드 받는 멤버변수?

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