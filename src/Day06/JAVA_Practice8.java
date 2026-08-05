package Day06;

public class JAVA_Practice8 {
    public static void main(String[] args) {
        // 1
        Book b1 = new Book("이것이 자바다","신용권",30000);
        Book b2 = new Book("자바의 정석", "남궁성", 28000);

        System.out.printf("%s, %s, %d \n", b1.title, b1.author, b1.price);
        System.out.printf("%s, %s, %d \n", b2.title, b2.author, b2.price);

        // 2
        Rectangle r1 = new Rectangle(10, 5);
        System.out.printf("가로 길이 : %d, 세로 길이 : %d\n", r1.height, r1.width);

        // 3
        BankAccount bank1 = new BankAccount("111-222-3333", "유재석", 10000);
        System.out.printf("계좌번호: %s, 예금주명: %s, 잔액: %d\n", bank1.accountNumber, bank1.ownerName, bank1.balance);

        // 4
        Goods goods = new Goods("콜라", 2000);
        System.out.printf("%s, %d \n", goods.name, goods.price);

        // 5
        Member member = new Member();
        System.out.printf("%s, %b \n", member.id, member.isLogin);
    }
}

/*
 * [문제 5] Member 클래스 (기본 생성자 및 초기값 설정)
 * Member 클래스를 정의하세요. (멤버 변수: id, isLogin)
 * 멤버 변수의 타입은 적절하게 선택하시오.
 * Member 클래스에 기본 생성자를 만들고, 생성자 내부에서 id는 "guest", isLogin은 false로 초기화되도록 구현하세요.
 * main 함수에서 new Member()로 객체를 생성한 뒤, 초기화된 id와 isLogin 값을 출력하여 확인하세요.
 */
class Book {
    String title;
    String author;
    int price;

    Book(String title, String author, int price){
        this.title = title;
        this.author = author;
        this.price = price;
    }
}

class Rectangle {
    int width;
    int height;

    Rectangle (int width, int height){
        this.width = width;
        this.height = height;
    }
}

class BankAccount {
    String accountNumber;
    String ownerName;
    int balance;

    BankAccount(String accountNumber, String ownerName, int balance){
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }
}

class Goods {
    String name = "미정";
    int price = 0;

    Goods (String name, int price){
        this.name = name;
        this.price = price;
    }
}

class Member {
    String id = "guest";
    boolean isLogin = false;
}
