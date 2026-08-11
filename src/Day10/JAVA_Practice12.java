package Day10;

/*[문제 6] instanceof와 강제 타입 변환 (Downcasting)
1. Vehicle 클래스와 이를 상속받는 Bus 클래스를 만드세요. Bus 클래스에만 checkFare() 메소드("요금을 확인합니다.")를 추가하세요.
2. main 함수에서 Vehicle vehicle = new Bus(); 코드를 작성하세요.
3. if문과 instanceof 연산자를 사용하여 vehicle 변수가 Bus 타입인지 확인하세요.
4. 만약 Bus 타입이 맞다면, Bus 타입으로 강제 변환한 뒤 checkFare() 메소드를 호출하세요.*/

/*[문제 7] 다형성을 활용한 객체 배열
1. "음료를 마십니다."를 출력하는 drink() 메소드를 가진 Beverage 클래스를 만드세요.
2. Beverage를 상속받는 Coke와 Coffee 클래스를 만들고, 각 클래스에서 drink() 메소드를 오버라이딩하여 "콜라를 마십니다.", "커피를 마십니다."를 출력하도록 하세요.
3. main 함수에서 Beverage 타입의 배열을 생성하고, 그 안에 Coke 객체와 Coffee 객체를 저장하세요.
4. 반복문을 사용하여 배열의 모든 요소를 꺼내 drink() 메소드를 호출하고, 각기 다른 결과가 출력되는 것을 확인하세요.*/

/*[문제 8] 다형성을 활용한 매개변수
1. Weapon 클래스와 이를 상속받는 Sword, Gun 클래스를 만드세요. 각 클래스는 "무기로 공격합니다.", "검으로 공격합니다.", "총으로 공격합니다."를 출력하는 attack() 메소드를 가집니다. (오버라이딩 활용)
2. Weapon 타입의 매개변수를 받아 그 객체의 attack() 메소드를 호출하는 Character 클래스와 use(Weapon weapon) 메소드를 만드세요.
3. main 함수에서 Sword 객체와 Gun 객체를 생성한 뒤, 이 객체들을 Character의 use() 메소드에 인자로 전달하여 각기 다른 결과가 출력되는 것을 확인하세요.*/

/*[문제 9] 필드와 메소드의 오버라이딩 차이
1. String name = "상위"; 필드와 method() 메소드("상위 메소드" 출력)를 가진 SuperClass를 만드세요.
2. SuperClass를 상속받고, String name = "하위"; 필드와 method() 메소드("하위 메소드" 출력)를 가진 SubClass를 만드세요.
3. SuperClass obj = new SubClass(); 로 객체를 생성한 뒤, obj.name과 obj.method()를 각각 호출했을 때의 결과를 확인하고, 왜 다른 결과가 나오는지 주석으로 설명하세요.*/

/*[문제 10] 다중 상속 관계
1. Device 클래스를 만드세요.
2. Device를 상속받는 Electronic 클래스를 만드세요.
3. Electronic을 상속받는 Laptop 클래스를 만드세요.
4. main 함수에서 Laptop 객체를 생성한 뒤, 이 객체가 Electronic 타입과 Device 타입으로도 형 변환이 가능한지 instanceof 연산자로 확인하고 결과를 출력하세요.*/
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
        // Override 뺐는데 왜 고양이가 운다 출력되는지?

        // [3]
        Computer com1 = new Computer();
        // 부모 클래스 생성자 실행 -> 자식 클래스 생성자 실행 순서로 출력됨. Machine -> Computer
        // 부모가 먼저 실행되고, 자식이 먼저 실행됨
        // * 생성자 내부에는 super() 키워드는 생략시 자동으로 적용됨 * (super() 키워드: 부모 생성자 가리킴)


        // [4]
        Figure f1 = new Triangle();
        // f1.explain(); // error

        // 자식 타입(Trigangle)의 객체를 부모 타입(Figure)의 참조 변수에 할당했다.
        // 두 클래스가 상하관계에 있기 때문에 하나의 객체, 메서드가 여러 가지의 타입을 가질 수 있는 다형성을 가질 수 있기 때문에
        // 업캐스팅(자동 타입 변환)을 통해 Triangle이라는 자식 타입을 Figure이라는 부모 타입의 참조변수에 할당할 수 있다.
        // 그러나 이 경우 자식 클래스에 있던 메소드를 실행할 수는 없다.(explain)

        // [5]
        Shape shape = new Circle();
        shape.draw();

    }
}
// [1]
class Person { String name; }
class Student extends Person { int studentId; }


// [2]
class Animal {
    void makeSound(){
        System.out.println("동물이 소리를 냅니다.");
    }
}
class Cat extends Animal{
    // @Override
    void makeSound(){
        System.out.println("고양이가 야옹하고 웁니다.");
    }
}

// [3]
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

// [4]
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

/*
 * [문제 5] 다형성과 오버라이딩
 * 1."도형을 그립니다."를 출력하는 draw() 메소드를 가진 Shape 클래스를 만드세요.
 * 2.Shape을 상속받고, draw() 메소드를 재정의하여 "원을 그립니다."를 출력하는 Circle 클래스를 만드세요.
 * 3.main 함수에서 Shape shape = new Circle(); 코드를 작성한 뒤, shape.draw()를 호출했을 때 어떤
 * 결과가 나오는지 확인하고 그 이유를 주석으로 설명하세요.
 */
// [5]
class Shape {
    void draw(){

    }
}

class Circle extends Shape {
    void draw(){
        System.out.println("원을 그립니다.");
    }
}