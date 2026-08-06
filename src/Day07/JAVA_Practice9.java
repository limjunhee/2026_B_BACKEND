package Day07;

public class JAVA_Practice9 {
    public static void main(String[] args) {
        // 1
        Printer printer = new Printer();
        printer.printMessage();

        // 2
        Greeter greeter = new Greeter();
        greeter.greet("임준희");

        // 3
        SimpleCalculator cal = new SimpleCalculator();
        int result3 = cal.add(5, 10);
        System.out.println(result3);

        // 4
        Checker checker = new Checker();
        boolean result4 = checker.isEven(10);
        if (result4) {
            System.out.println("짝수입니다.");
        } else {
            System.out.println("홀수입니다.");
        }

        // 5
        Lamp lamp = new Lamp();
        lamp.turnOn();
        System.out.println(lamp.isOn);
        lamp.turnOff();
        System.out.println(lamp.isOn);

        // 6
        Product product1 = new Product("콜라", 10);
        product1.sell(4);

        // 7
        Visualizer stars = new Visualizer();
        stars.getStars(5);
        
        // 8 
        ParkingLot car1 = new ParkingLot();
        ParkingLot car2 = new ParkingLot();
        car1.calculateFee(65);  // 30(1000) + 35(500 * 3 = 1500) = 2500
        car2.calculateFee(140); // 30(1000) + 110(500 * 11 = 5500) = 6500
    }
}

class Printer{
    void printMessage(){
        System.out.println("안녕하세요, 메소드입니다.");
    }
}

class Greeter {
    void greet(String name){
        System.out.printf("안녕하세요, %s님!\n", name);
    }
}

class SimpleCalculator{
    int add(int x, int y){
        return x + y;
    }
}

class Checker {
    boolean isEven(int x){
        if (x % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}

class Lamp {
    boolean isOn = false;

    void turnOn() {
        isOn = true;
    }

    void turnOff() {
        isOn = false;
    }
}

class Product {
    String name;
    int stock;

    Product(String name, int stock){
        this.name = name;
        this.stock = stock;
    }

    boolean sell (int quantity){
        if (stock >= quantity) {
            stock -= quantity;
            System.out.printf("%s의 남은 재고 수 : %d\n", name, stock);
            return true;
        } else {
            return false;
        }
    }
}
/*
 * [문제 7] Visualizer 클래스를 만드세요.
 * 1. 정수 하나를 매개변수로 받아, 그 숫자만큼 "★" 문자를 반복하여 하나의 문자열로 만들어 반환하는 getStars 메소드를
 * 정의하세요.
 * 2. main 함수에서 getStars(5)를 호출하여 반환된 문자열 "★★★★★"를 출력하세요.
 */
class Visualizer {
    void getStars(int star){
        for( int i = 1; i <= star; i++){
            System.out.print("★ ");
        }
        System.out.println();
    }
}


class ParkingLot {
    void calculateFee( int time ){
        int fee = 0;

        if (time <= 30) {
            fee = 1000;
        } else {
            time -= 30;
            fee = 1000 + 500 * ( time / 10);
        }

        if (fee > 20000) {
            fee = 20000;
        }

        System.out.printf("주차 요금 결과: %d원\n", fee);
    }
}