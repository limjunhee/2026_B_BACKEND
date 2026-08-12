package Day11;

public class Exam2 {
    public static void main(String[] args) {
        // 1. 인터페이스 파일에서 키보드 규격(규칙) 만든다.
        // 2. 규격에 따른 구현체를 만든다.
        // 3. 키보드 타입 생성
        Keyboard myBoard;

        // 4. 스포츠 게임 실행하면?
        myBoard = new SportsGame();     // 업캐스팅 

        // 5. a, b키 눌러보기
        myBoard.aKey();                 // 슈팅
        myBoard.bKey(0);              // 수비

        // 6. 스포츠게임 끄고 액션게임 실행하기
        myBoard = new ActionGame();     // 업캐스팅 ( 변수는 단 하나의 자료만 저장 )
        myBoard.aKey();                 // 공격
        myBoard.bKey(0);              // 방어

        // 다형성 표현 1) extends 2) implements
        System.out.println( Keyboard.info );
    }
}

class ActionGame implements Keyboard {
    @Override
    public void aKey() {
        // TODO Auto-generated method stub
        System.out.println("공격");
    }

    @Override
    public int bKey(int x) {
        // TODO Auto-generated method stub
        System.out.println("방어");
        return 0;
    }
}

class SportsGame implements Keyboard {
    @Override
    public void aKey() {
        // TODO Auto-generated method stub
        System.out.println("슈팅");
    }

    @Override
    public int bKey(int x) {
        // TODO Auto-generated method stub
        System.out.println("수비");
        return 0;
    }
}

interface Buy {
    // 1) ★ 추상메소드: 구현부가 없는 메소드
    public abstract void method1();

    // 2) 디폴트 메소드 : 구현부가 있는 메소드
    public default void method2(){ };

    // 3) 정적 메소드 : static 이면 인스턴스(구현체) 없이 사용 메소드
    public static void method3(){ };

    // 4) 비공개 메소드 : private -> 하위 타입에서 오버라이드 불가능한 메소드 = 구현 불가능
    private void method4(){};
}

interface Sell {
    void method5(); // 생략시 public abstract 기본
}

class Customer extends Object implements Buy, Sell{ // 2개 이상의 인터페이스로부터 구현 가능
    // 여러 개 인터페이스들을 구현 가능함
    // ***추상 메소드만 필수 오버라이딩***
    @Override
    public void method1() {
        
    }
    @Override
    public void method5() {
        
    }
}

interface CustomerControl extends Buy, Sell{
    // 인터페이스는 다른 인터페이스로부터 상속 가능
    void order(); // 추상
}

class Customer2 implements CustomerControl{
    // Buy + Sell = CustomerControl 이므로
    // method1, method5, order -> 총 3개의 추상 메소드들을 오버라이딩 해야만 한다(필수).
    @Override
    public void method1() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void method5() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void order() {
        // TODO Auto-generated method stub
        
    }
}