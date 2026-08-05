package Day06;

public class Exam1 {
    public static void main(String[] args) {
        Phone p1 = new Phone();
        p1.model = "갤럭시";

        Phone p2 = new Phone("아이폰","파랑");

        Phone p3 = new Phone("갤럭시탭", "블랙", 300000);
    }
}

class Phone {
    // 멤버변수
    String model;
    String color;
    int price;

    /*
        - 생성자
        생성자가 1개 없으면 자동으로 기본 생성자 생성
        생성자명은 중복 안됨 -> 단 오버로딩 중복 가능 ( 매개변수 개수, 타입, 순서가 다름)

        this : 멤버 변수 식별 키워드
        멤버변수와 매개변수명 같으면 멤버변수명 앞에 this
    */

    // [1] 기본생성자 : 매개변수가 없음
    Phone(){};

    // [2] 정의생성자 : 매개변수가 있음
    Phone (String model, String color){
        this.model = model;
        this.color = color;
    }
    Phone(String model, String color, int 가격) {
        this.model = model;
        this.color = color;
        price = 가격;
    }
}