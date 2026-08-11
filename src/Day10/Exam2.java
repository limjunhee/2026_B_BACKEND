package Day10;

public class Exam2 {
    public static void main(String[] args) {
        // [1]
        // 자바는 100% 객체지향언어이다.
        // Object(슈퍼클래스) 클래스로부터 모든 클래스는 상속 관계를 갖는다.
        
        // 1.
        A a = new A(); // 총 2개 A --> Object

        // 2.
        B b = new B(); // 총 3개 B --> A --> Object

        // 3.
        C c = new C(); // 총 3게 C --> A --> Object

        // 4.
        D d = new D(); // 총 4개 D --> B --> A --> Object

        // 5.
        E e = new E(); // 총 4개 E --> C --> A --> Object

        // [2] 자동 타입변환/업캐스팅
        A a2 = b; // B -> A [가능]

        Object o1 = a2; // A --> Object [가능]

        // [3] 강제 타입 변환/다운캐스팅
        B b2 = (B)a2; // A --> B 가능함, 태생이 B였기 때문에

        // C c2 = (C)b2; // B --> C 불가능함, 형제간의 타입 변환 불가능

        // [4] 타입 확인, 인스턴스 instanceOf 타입명
        System.out.println( e instanceof Object ); // e는 Object로부터 상속 관계인가? : true
        System.out.println( e instanceof C ); // e는 C로부터 상속 관계인가? : true
        // System.out.println( e instanceof D ); // e는 D로부터 상속 관계인가? : 오류뜸(false)
        // System.out.println( e instanceof B ); // e는 B로부터 상속 관계인가? : 오류뜸(false)
        // *** 타입 변환 전에 instanceOf 키워드를 활용하여 타입을 환인 후 타입 변환을 하면 안전하게 수행 가능
    }
}


class A{
    A(){ System.out.println("[1]A객체 생성");}
}

class B extends A{
    B(){ System.out.println("[2]B객체 생성");}
}

class C extends A{
    C(){ System.out.println("[3]C객체 생성");}
}

class D extends B{
    D(){ System.out.println("[4]D객체 생성");}
}

class E extends C{
    E(){ System.out.println("[5]E객체 생성"); }
}