package Day10;

public class Exam3 {
    public static void main(String[] args) {
        // 1. 상위 객체
        상위클래스 obj1 = new 상위클래스();
        obj1.show();
        System.out.println(obj1.value1);
        System.out.println(obj1.value2);
        // System.out.println(obj1.value3);
        // System.out.println(obj1.value4);
        System.out.println("-=-=-=-=-=-=-=-=-=-=");
        // 2. 하위 객체
        하위클래스 obj2 = new 하위클래스();
        obj2.show();
        System.out.println(obj2.value1);
        System.out.println(obj2.value2);
        System.out.println(obj2.value3);
        System.out.println(obj2.value4);
        System.out.println("-=-=-=-=-=-=-=-=-=-=");
        // 3. 타입 변환
        상위클래스 obj3 = obj2;
        obj3.show();
        System.out.println(obj3.value1);
        System.out.println(obj3.value2);
        // System.out.println(obj3.value3);
        // System.out.println(obj3.value4);
    }
}

/*
    오버로딩: 생성자명/메소드명 동일하게
    오버라이딩: 상속으로부터 물려받은 메소드 재정의
*/

class 상위클래스 {
    int value1 = 10;
    int value2 = 20;

    상위클래스(){
        System.out.println("상위클래스 생성");
    }

    void show(){
        System.out.println("상위 메소드 실행");
    }
}

class 하위클래스 extends 상위클래스 {
    int value3 = 30; int value4 = 40;
    하위클래스(){
        System.out.println("하위 클래스 탄생");
    }

    // 주의 : 오버로딩 vs 오버라이딩
    void show(int a) {}     // 오버로딩 : 메소드명은 같지만, 매개변수는 다름


    // 오버라이드가 존재하지 않는다면, 상위 클래스의 show를 실행한다.
    @Override // 메소드 위에 @Override 먼저
    void show( ){           // 오버라이딩 : 상위 클래스의 메소드 선언부 모두 동일(재정의) (최우선 실행)
        System.out.println("하위 메소드가 재정의 실행");
    }

    // 여러 개 인스턴스가 메소드를 공유한다.
}