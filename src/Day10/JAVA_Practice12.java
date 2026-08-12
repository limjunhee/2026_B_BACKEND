package Day10;

import java.util.ArrayList;


public class JAVA_Practice12 {
    public static void main(final String[] args) {
        // [1]
        final Student stu1 = new Student();
        stu1.name = "홍길동";
        stu1.studentId = 11111111;

        System.out.println(stu1.name);
        System.out.println(stu1.studentId);

        // [2]
        Cat cat1 = new Cat();
        cat1.makeSound();

        // [3]
        Computer com1 = new Computer();
        // 부모 클래스 생성자 실행 -> 자식 클래스 생성자 실행 순서로 출력됨. Machine -> Computer
        // 부모가 먼저 실행되고, 자식이 먼저 실행됨
        // * 생성자 내부에는 super() 키워드는 생략시 자동으로 적용됨 * (super() 키워드: 부모 생성자 가리킴)


        // [4]
        Figure f1 = new Triangle(); // Triangle(하위) -> Figure(상위)
        // f1.explain(); // error, 상위 클래스엔 같은 메소드가 없어서(오버라이딩 X)
        
        // 자식 타입(Triangle)의 객체를 부모 타입(Figure)의 참조 변수에 할당했다.
        // 하위 인스턴스를 만들면 상위 인스턴스역시 생성된다.
        // 두 클래스가 상하관계에 있기에 하나의 객체, 메서드가 여러 가지의 타입을 가질 수 있는 다형성을 가질 수 있다

        // [5]
        Shape shape = new Circle();
        shape.draw();

        // [6]
        Vehicle vehicle = new Bus();
        if (vehicle instanceof Bus) {
            Bus bus = (Bus)vehicle;
            bus.checkFare();
        } else {
            System.out.println("vehicle 변수는 Bus타입이 아닙니다.");
        }

        // [7]
        ArrayList< Beverage > array = new ArrayList<>();
        array.add(new Coke());
        array.add(new Coffee());

        for( Beverage drink : array){
            drink.drink();
        }

        // [8]
        Sword sword = new Sword();
        Gun gun = new Gun();
        // Weapon weapon = new Weapon();
        Character character = new Character();
        character.use(sword);
        character.use(gun);
        // character.use(weapon);

        //[9]
        SuperClass obj = new SubClass();    // 상위 메소드 타입으로 하위 메소드 출력(업캐스팅)
        System.out.println(obj.name);       // 상위 메소드 멤버변수가 출력됨 ("상위")
        obj.method();                       // "하위 메소드" 메소드가 실행됨

        // obj는 상위 클래스 타입으로 생성된 하위 클래스 변수이다.
        // 하위 클래스에서 상위 클래스로 업캐스팅(자동 타입 변환)될 경우, 클래스들끼리 상속관계에 있으므로 상위 클래스 타입으로 변환할 수 있고 
        // 하위 메소드를 그대로 불러올 수 있다. 
        // 하지만 하위 클래스의 멤버변수는 지역변수처럼 오직 하위 클래스에서만 사용되는 변수이기 때문에 상위 클래스 타입인 obj.name은 "상위"일 수 밖에 없다. 

        // [10]
        Laptop laptop = new Laptop();
        System.out.println( laptop instanceof Electronic); // true
        System.out.println(laptop instanceof Device); // true
        Electronic electronic = laptop;
        Device device = laptop;

        laptop.call();
        electronic.call();
        device.call(); // 타입만 변환했을 뿐 메소드는 그대로 Laptop 것을 불러온다
    }
}
// [1] =========================================================
class Person { String name; }
class Student extends Person { int studentId; }


// [2] =========================================================
class Animal {
    void makeSound(){
        System.out.println("동물이 소리를 냅니다.");
    }
}
class Cat extends Animal{
    @Override
    void makeSound(){
        System.out.println("고양이가 야옹하고 웁니다.");
    }
}

// [3] =========================================================
class Machine {
    Machine(){
        System.out.println("부모 클래스 생성자 실행");
    }
}

class Computer extends Machine {
    Computer(){
        System.out.println("자식 클래스 생성자 실행");
    }
}

// [4] =========================================================
class Figure {
    Figure(){
        System.out.println("도형 생성");
    }
}

class Triangle extends Figure{
    Triangle(){
        System.out.println("삼각형 생성");
    }
    void explain(){
        System.out.println("하위 클래스는 삼각형입니다.");
    }
}

// [5] 메소드 오버라이드 시 메소드 위에 @Override 생략해도 오버라이드 가능함.( 생략 시 컴파일 과정에서 자동 할당 )
class Shape {
    void draw(){
        System.out.println("도형을 그립니다.");
    }
}
class Circle extends Shape {
    @Override
    void draw(){
        System.out.println("원을 그립니다.");
    }
}

// [6] =========================================================
class Vehicle {

}
class Bus extends Vehicle {
    void checkFare(){
        System.out.println("요금을 확인합니다.");
    }
}

// [7] =========================================================
class Beverage {
    void drink(){
        System.out.println("음료를 마십니다.");
    }
}
class Coke extends Beverage {
    @Override
    void drink(){
        System.out.println("콜라를 마십니다.");
    }
}
class Coffee extends Beverage {
    @Override
    void drink(){
        System.out.println("커피를 마십니다.");
    }
}

// [8] =========================================================
class Weapon {
    void attack(){
        System.out.println("무기로 공격합니다.");
    }
}
class Sword extends Weapon {
    @Override
    void attack() {
        System.out.println("검으로 공격합니다.");
    }
}
class Gun extends Weapon {
    @Override
    void attack() {
        System.out.println("총으로 공격합니다.");
    }
}
class Character {
    void use(Weapon weapon){
        weapon.attack();
    }
}

// [9] =========================================================
class SuperClass {
    String name = "상위";

    void method(){
        System.out.println("\"상위 메소드\" 출력");
    }
}

class SubClass extends SuperClass {
    String name = "하위";

    void method() {
        System.out.println("\"하위 메소드\" 출력");
    }
}

// [10] =========================================================
class Device {
    void call(){
        System.out.println("클래스 Device");
    }
}
class Electronic extends Device{
    void call() {
        System.out.println("클래스 Electronic");
    }
}
class Laptop extends Electronic{
    void call() {
        System.out.println("클래스 Laptop");
    }
}