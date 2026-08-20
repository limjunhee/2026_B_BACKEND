package Day14;

import java.util.ArrayList;

public class Exam1 {
    public static void main(String[] args) {
        /* 
            제네릭 타입
                정의 : 여러가지 타입에서 동작할 수 있도록 만든 키워드/타입/문법
                목적 : 클래스를 정의할 때 타입을 정하지 않고 인스턴스/함수를 호출할 때 사용자(개발자)가 사용할 때 타입을 정함
                사용법:
                    1) 제네릭 타입은 영어 대문자로 한다(관례적)
                    2) 여러 개 가능하다.
                    3) 기본 타입은 불가능하므로 래퍼 클래스를 사용한다.
        */

        // 1) 클래스 내 객체 멤버변수 동일한 타입으로 값을 대입
        Box1 box1 = new Box1();
        box1.content = "안녕하세요"; // 가능

        // 2) String 대신에 int 타입으로 content를 대입 -> 새로운 클래스를 만들자.
        Box2 box2 = new Box2();
        box2.content = 10;  // 가능, 다만 동일한 이름의 멤버변수간 서로 다른 타입을 사용한다.

        // 3) 해결 방안 : 제네릭을 이용한 동일한 멤버변수간 서로 다른 타입을 사용함
        // - 사용하는 사람이 제네릭 타입을 정한다.
        Box3<String> box3 = new Box3<String>(); // new Box3 다음 <String>은 생략 가능함
        box3.content = "안녕하세요";
        
        Box3<Integer> box33 = new Box3();
        box33.content = 10;                     // 타입을 미리 정의하지 않고, 인스턴스를 만들 때 정함

        // * Object 타입으로 하면 되지 않나? -> 이런 경우 타입 변환이 필수적
        // 제네릭의 경우 타입 변환 과정은 딱히 거치지 않는다.

        // ArrayList에서도 제네릭을 썼었다. 
        ArrayList<String> list1 = new ArrayList<>(); // 제네릭 String 타입으로 배열을 선언
        String[] list2 = new String[10];
        
        
        // 4) 2개 이상의 제네릭 타입 가능하다.
        Box4<String, Integer> box4 = new Box4();
        box4.value1 = "안녕하세요";
        box4.value2 = 10;

        // 5) 제네릭 안에 제네릭 중첩 가능
        Box4< String, ArrayList<Integer> > box44 = new Box4(); // 문자열 , ArrayList<Integer>
        box44.value1 = "안녕하세요";    box44.value2 = new ArrayList<Integer>();

        // * 활용처 : 컬렉션 프레임워크(중요함, 제네릭을 무조건 씀)
        //                             (ArrayList)

        // 6) 메소드 제네릭 가능( 메소드의 매개변수와 반환 타입 또한 제네릭 가능 )
        Box3<String> box333 = Util.boxing("사과");
        System.out.println(box333.content); // 사과

        // 7) 상속 관계 제약 < 타입 extends 상위타입 >
        // Box5<String> box5 = new Box5(); // String은 Number의 자식이 아니므로 불가능함
        Box5<Integer> box5 = new Box5(); // Integer는 Number의 상속을 받는 타입이라 가능함
    }
}

class Box1 { String content; } // 박스1 클래스 내 문자열 content 대입 가능
class Box2 { int content; } // 박스2 클래스 내 정수형 content 대입 가능
class Box3 <제네릭타입>{ 제네릭타입 content; } // < >를 이용한 미지수 타입 지정
class Box4 <T , E> { T value1; E value2;} // 2개의 멤버변수를 만듦

class Util {
    // 첫 번째 T : 이 메서드가 제네릭 메서드이며, T라는 이름의 타입 파라미터를 사용할 것이라고 알리는 용도
    // 두 번째 T : 이 메서드가 실행을 마친 후 T 타입을 담고 있는 Box3 객체를 반환할 것이라고 알림
    //             예시) 메서드 호출 시 <T>가 <String>으로 호출된다면, 리턴 타입은 Box3<String>
    // 세 번째 T : 메서드를 호출할 때 받는 매개변수의 타입.
    
    // 요약: "내가 지금부터 제네릭 타입 T를 쓸 건데(<T>), 반환해 주는 객체는 T를 담은 Box이고(Box3<T>), 입력받는 값의 타입도 T란다(T 매개변수)."
    public static <T> Box3<T> boxing( T 매개변수 )
    { // 메소드의 타입들을 제네릭 타입 가능
        Box3<T> box = new Box3();
        box.content = 매개변수;
        return box;
    }
}

class Box5<T extends Number>{
    T content; // T(제네릭) 타입에는 Number의 자식들만 들어올 수 있다. -> Number의 자식들만
}