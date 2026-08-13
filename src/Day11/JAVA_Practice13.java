package Day11;

public class JAVA_Practice13 {
    public static void main(String[] args) {
        // [1] ===============================================================
        System.out.println("===============================================================");
        Cat cat = new Cat();
        Dog dog = new Dog();
        cat.makeSound();
        dog.makeSound();

        Soundable sound = new Cat();
        sound.makeSound();
        sound = new Dog();
        sound.makeSound();

        // [2] ===============================================================
        // 상수는 인스턴스가 필요 없음
        // static은 프로그램 시작 시 메모리 할당, 종료 시 제거
        // 클래스명.상수명 / 인터페이스명.상수명
        // 1. 첫글자가 대문자이면 인터페이스/클래스명, 2. 첫글자 소문자이면 변수/멤버변수.
        //          MyCar                                   myCar, a.myCar
        // 3. 전체가 대문자이면 상수                   3. 첫글자가 소문자이면 ( ) 함수/생성자
        //          MYCAR                                   myCar( ), a.myCar( )
        System.out.println("===============================================================");
        System.out.println(RemoteControl.MAX_VOLUME);
        System.out.println(RemoteControl.MIN_VOLUME);
        
        // [3] ===============================================================
        System.out.println("===============================================================");
        Sword sword = new Sword();
        Gun gun = new Gun();

        Character character = new Character();

        character.useWeapon(gun);
        character.useWeapon(sword);

        // [4] ===============================================================
        System.out.println("===============================================================");
        Duck duck = new Duck();
        duck.fly();
        duck.swim();

        // [5] ===============================================================
        System.out.println("===============================================================");
        Duck duck2 = new Duck();
        Object obj1 = duck2;

        if (obj1 instanceof Swimmable) {
            Swimmable obj2 = (Swimmable)obj1;
            obj2.swim();
        } else {
            System.out.println("obj1은 Swimmable 타입이 아닙니다");
        }

        if (obj1 instanceof Flyable){
            Flyable obj2 = (Flyable)obj1;
            obj2.fly();
        } else {
            System.out.println("obj1은 Flyable 타입이 아닙니다");
        }

        // [6] ===============================================================
        System.out.println("===============================================================");
        DataAccessObject dao;
        dao = new OracleDao();
        dao.save();

        dao = new MySqlDao();
        dao.save();

        // [7] ===============================================================
        System.out.println("===============================================================");
        Greeting g = new Greeting() {
            public void welcome(){
                System.out.println("환영합니다");
            }
        };

        g.welcome();

        // [8] ===============================================================
        System.out.println("===============================================================");
        Television television = new Television();
        television.turnOn();
        television.turnOff();
        television.setMute(false);
        television.setMute(true);

        // [9] ===============================================================
        System.out.println("===============================================================");
        Calculator.plus(5, 15);
    }
}

// [1] ===============================================================
interface Soundable{
    public abstract void makeSound();
}

class Cat implements Soundable{
    @Override
    public void makeSound() {
        System.out.println("야옹");
    }
}

class Dog implements Soundable{
    @Override
    public void makeSound() {
        System.out.println("멍멍");
    }
}

// [2] ===============================================================
interface RemoteControl {
    public static final int MAX_VOLUME = 10;
    public static final int MIN_VOLUME = 0;
}

// [3] ===============================================================
interface Attackable {
    void attack();
}

class Sword implements Attackable{
    @Override
    public void attack() {
        System.out.println("검으로 공격!");
    }
}

class Gun implements Attackable{
    @Override
    public void attack() {
        System.out.println("총으로 사격!");
    }
}

class Character{
    void useWeapon(Attackable weapon){
        weapon.attack();
    }
}

// [4] ===============================================================
interface Flyable{
    void fly();
}

interface Swimmable{
    void swim();
}

class Duck implements Flyable, Swimmable{
    @Override
    public void fly() {
        System.out.println("오리가 날아갑니다");
    }

    @Override
    public void swim() {
        System.out.println("오리가 헤엄칩니다");
    }
}

// [5] ===============================================================
// 4번 클래스, 인터페이스 활용 문제임.

// [6] ===============================================================
interface DataAccessObject{
    void save();
}

class OracleDao implements DataAccessObject{
    @Override
    public void save() {
        System.out.println("Oracle DB에 저장");
    }
}

class MySqlDao implements DataAccessObject{
    @Override
    public void save() {
        System.out.println("MySQL DB에 저장");
    }
}

// [7] ===============================================================
interface Greeting {
    void welcome();
}

// [8] ===============================================================
interface Device {
    void turnOn();
    
    void turnOff();

    public default void setMute(boolean mute){
        System.out.println("무음 처리합니다.");
    }
}

class Television implements Device {
    @Override
    public void turnOn() {
        System.out.println("소리를 킵니다.");
    }
    @Override
    public void turnOff() {
        System.out.println("소리를 끕니다.");
        
    }
}

// [9] ===============================================================
interface Calculator {
    public static void plus(int x, int y){
        System.out.println(x + y);
    };
}