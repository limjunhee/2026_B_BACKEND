package Day05;

import java.util.Scanner;

public class JAVA_Practice7 {
    public static void main(String[] args) {
        // 1번 문제==========================================================================
        Book b1 = new Book();
        b1.title = "이것이 자바다";
        b1.author = "신용권";
        b1.price = 30000;

        Book b2 = new Book();
        b2.title = "자바의 정석";
        b2.author = "남궁성";
        b2.price = 28000;

        System.out.printf("%s, %s, %d \n", b1.title, b1.author, b1.price);
        System.out.printf("%s, %s, %d \n", b2.title, b2.author, b2.price);

        // 2번 문제==========================================================================
        Pet pet1 = new Pet();
        Pet pet2 = new Pet();
        pet1.name = "초코"; pet1.species="푸들"; pet1.age = 3;
        pet2.name = "나비"; pet2.species="코리안숏헤어"; pet2.age = 5;

        System.out.printf("이름: %s, 종류: %s, 나이: %d살\n", pet1.name, pet1.species, pet1.age);
        System.out.printf("이름: %s, 종류: %s, 나이: %d살\n", pet2.name, pet2.species, pet2.age);

        // 3번 문제==========================================================================
        Rectangle rectangle1 = new Rectangle();
        rectangle1.width = 10;
        rectangle1.height = 5;
        System.out.printf("사각형의 넓이: %d\n", rectangle1.width * rectangle1.height);

        // 4번 문제==========================================================================
        BankAccount bankaccount1 = new BankAccount();
        bankaccount1.accountNumber = "111-222-3333";
        bankaccount1.ownerName = "유재석";
        bankaccount1.balance = 10000;
        bankaccount1.balance += 5000;
        System.out.printf("입금 후 잔액: %d\n", bankaccount1.balance);
        bankaccount1.balance -= 3000;
        System.out.printf("출금 후 잔액: %d\n", bankaccount1.balance);

        // 5번 문제==========================================================================
        Product p1 = new Product();
        Product p2 = new Product();
        p1.name = "새우깡"; p1.price = 1500;
        p2.name = "콜라"; p2.price = 2000;

        if (p1.price > p2.price) {
            System.out.println(p1.name);
        } else{
            System.out.println(p2.name);
        }

        // 6번 문제==========================================================================
        Member member = new Member();
        member.id = "admin";
        member.isLogin = false;
        System.out.printf("로그인 전 상태 = %b\n", member.isLogin);
        member.isLogin = true;
        System.out.printf("로그인 전 상태 = %b\n", member.isLogin);

        // 7번 문제==========================================================================
        Television t1 = new Television();
        t1.channel = 7;
        t1.volume = 20;
        System.out.printf("채널 : %d, 볼륨 : %d\n", t1.channel, t1.volume);
        t1.channel = 11;
        t1.volume -= 2;
        System.out.printf("채널 : %d, 볼륨 : %d\n", t1.channel, t1.volume);

        // 8번 문제==========================================================================
        Player P1 = new Player();
        Player P2 = new Player();
        P1.name = "손흥민"; P1.power = 90; P1.speed = 95;
        P2.name = "이강인"; P2.power = 85; P2.speed = 92;
        
        int sum1 = P1.power + P1.speed;
        int sum2 = P2.power + P2.speed;

        if ( sum1 > sum2 ) {
            System.out.println(P1.name);
        } else {
            System.out.println(P2.name);
        }

        // 9번 문제 ==========================================================================
        MenuItem item1 = new MenuItem();
        MenuItem item2 = new MenuItem();
        MenuItem item3 = new MenuItem();

        item1.name = "김치찌개"; item1.price = 8000; item1.isSignature = true;
        item2.name = "된장찌개"; item2.price = 8000; item2.isSignature = false;
        item3.name = "계란찜"; item3.price = 3000; item3.isSignature = false;

        if (item1.isSignature == true) {
            System.out.println(item1.name);
        }
        if (item2.isSignature == true) {
            System.out.println(item2.name);
        }
        if (item3.isSignature == true) {
            System.out.println(item3.name);
        }

        // 10번 문제 ==========================================================================
        UserProfile profile1 = new UserProfile();
        Scanner scanner = new Scanner(System.in, "EUC-KR");
        System.out.print("이름 입력: ");
        profile1.name = scanner.next();
        System.out.print("나이 입력: ");
        profile1.age = scanner.nextInt();
        System.out.print("MBTI 입력: ");
        profile1.mbti = scanner.next();

        System.out.println("--- 프로필 ---");
        System.out.printf("이름: %s\n", profile1.name);
        System.out.printf("이름: %d\n", profile1.age);
        System.out.printf("이름: %s\n", profile1.mbti);
    }
}

//문제 1 클래스
class Book {
    String title;
    String author;
    int price;
}

//문제 2 클래스
class Pet {
    String name;
    String species;
    int age;
}

//문제 3 클래스
class Rectangle {
    int width;
    int height;
}

//문제 4 클래스
class BankAccount{
    String accountNumber;
    String ownerName;
    int balance;
}

// 문제 5 클래스
class Product {
    String name;
    int price;
}

// 문제 6 클래스
class Member{
    String id;
    boolean isLogin;
}

// 문제 7 클래스
class Television {
    int channel;
    int volume;
}

// 문제 8 클래스
class Player {
    String name;
    int power;
    int speed;
}

// 문제 9 클래스
class MenuItem{
    String name;
    int price;
    boolean isSignature;
}

// 문제 10 클래스
class UserProfile {
    String name;
    int age;
    String mbti;
}

