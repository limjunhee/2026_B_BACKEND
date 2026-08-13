package Day12;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam1 {
    public static void main(String[] args) {
        // 예외 : 에러 발생 시 고치는 게 아니라 흐름 제어
        // -> vs if

        // 예외처리: try { 예외발생코드 } catch( 예외클래스명 변수명 ) { 처리할 코드 }

        // [1] 일반예외 : 실행(컴파일)하기 전 예외가 발생할 수도 있는 코드에 대해 미리 예외처리 
        // 1. ClassNotFoundException : 클래스를 찾을 수 없다.
        // 참고 = java.lang.String이라고 써야 함(패키지명 포함)
        try{
            Class.forName("java.lang.String2"); // Class.forName( "찾을클래스" ) -> 동적으로 존재하는 클래스를 로드함(읽어옴)   
        } catch (ClassNotFoundException e ){
            System.out.println("존재하지 않는 클래스입니다." + e);
        }
        
        // 2. InterruptedException: 스레드에 문제가 발생 하면
        // Thread.sleep(1000) // Thread.sleep(밀리초); -> 밀리초만큼 일시 정지, 스레드란? 컴파일 된 
        try {
            Thread.sleep(1000);    
        } catch (InterruptedException e) { // 예외 발생시 처리되는 코드, e -> 예외 정보를 담는 객체이면서 변수
            System.out.println("인터럽트 문제 발생" + e);
        }
        
        // [2] 실행 예외 : 컴파일(실행) 하고 나서 발생하는 예외를 처리      * 파악하려면 경험 중요 * 예측하거나, 유지보수(로그)
        // 3. NullPointerException : 참조가 없는데 참조하려는 경우
        // .(도트/접근) 연산자는 참조할 대상의 멤버들 접근
        try {
            String str1 = null; // 참조값이 없음 -> (객체)인스턴스가 없다.
            System.out.println(str1.length()); // Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "str1" is null at Day12.Exam1.main(Exam1.java:30)    
        } catch (NullPointerException e) {
            System.out.println( e );           // java.lang.NullPointerException: Cannot invoke "String.length()" because "str1" is null
        }
        

        // 4. NumberFormatException : 숫자타입로 변환하는 데 문제 발생(불가능한 경우)
        try {
            String str2 = "100";
            Integer.parseInt(str2); // 문자얄 -> 정수 변환 함수

            String str3 = "100a";   // a 있어서 불가능
            Integer.parseInt(str3); // Exception in thread "main" java.lang.NumberFormatException: For input string: "100a" at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67) at java.base/java.lang.Integer.parseInt(Integer.java:565) at java.base/java.lang.Integer.parseInt(Integer.java:662) at Day12.Exam1.main(Exam1.java:41)      
        } catch (NumberFormatException e) {
            System.out.println( e );
        }

        // 5. ArrayIndexOutOfBoundsException: 배열 내 인덱스 범위가 넘는 경우
        try {
            int[] array = { 10, 25 }; // 2개 저장하는 배열
            System.out.println(array[0]);
            System.out.println(array[10]); // 없는 인덱스 호출    
        } catch (ArrayIndexOutOfBoundsException e ) {
            System.out.println( e ); // java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 2
        }

        // [3] 다중 catch : try에서 다양한 예외들을 다양하게 흐름 제어
        // [4] finally: 예외가 발생 여부 상관 없이 무조건 실행하는 구역, 외부 프로그램과 연동 종료 코드를 둠
        // 6. InputMismatchException: 타입 예외
        Scanner scanner = new Scanner(System.in, "EUC-KR"); 
        try {
            System.out.print("정수 입력:");
            int ch = scanner.nextInt(); // 입력받은 자료를 int로 변환, 문자열 입력시 오류
            Integer.parseInt("ABC"); // 예외
        } catch (InputMismatchException e) {
            System.out.println("정수만 입력하세요." + e);
        } catch( NumberFormatException e ){ // 다중 catch() 가능!
            System.out.println("타입 변환 오류!" + e);
        } catch( Exception e) { // 다중 catch -> Exception으로 그 외 예외처리 실시 (단, Exception은 가장 마지막에 둘 것. 앞에 두면 자식 예외처리들은 무용지물이 됨)
            System.out.println("예외 발생, 관리자에게 문의하세요" + e);
        } finally {
            System.out.println("무조건 실행되는 부분입니다.");
        }

        // * 여러 타입들의 예외들을 하나의 타입으로 Exception으로 사용 가능 (Exception -> 모든 예외들의 최상위 부모 클래스다.)
        // 단, 한 예외로 퉁쳐버리기 때문에 디테일 한 부분은 파악 불가능

        // * try{ 예외가 발생할 것으로 예상되는 코드 } catch( 예외클래스명 예변수명){ } finally{ }
        
        
        
        // [5] 예외 떠넘기기 , *예외 반환* : 해당 메소드를 호출한 곳으로 예외 반환
        try {
            method1(); // 예외가 반환, throws가 존재해서 메소드가 아니라 여기서 빨간줄이 뜬다.
                       // main에다 throws 하면 빨간줄 없어지긴 한다. 이 경우엔 프로그램이 다운되지 않으나 흐름 제어를 못한다.    
        } catch (Exception e) {
            System.out.println("메소드 예외 발생! "+ e);
        }
        
    } 

    // 7. 예외발생시 발생한 곳에서 예외처리 하지 않고 해당 함수를 반환시킬 수 있음
    public static void method1() throws ClassNotFoundException {
        Class.forName("java.lang.Spring"); // 예외 발생?
    }
}
