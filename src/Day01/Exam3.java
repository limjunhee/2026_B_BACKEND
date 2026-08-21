package Day01;


import java.util.Scanner;
public class Exam3 {
    public static void main(String[] args) {
        
        // [1] 출력함수
        // System(클래스).out(출력객체).print(출력함수);
        // System.out.println();: 출력 후 자동 줄바꿈 
        System.out.println("hello1");

        System.out.print("hello2"); 
        System.out.print("hello3");

        // [2] 이스케이프/제어 문자 : 백슬래시 이용한 특수 기능
        // \t - 들여쓰기, \n - 줄바꿈, \" , \', \\
        System.out.println("\nhello4\thello5 \' \" \\");

        // [3] System.out.printf("형식", "자료"); 
        // %s - 문자열이 들어갈 자리, %d - 정수가 들어갈 자리
        // %c - 문자가 들어갈 자리, %f - 실수가 들어갈 자리
        // %자릿수d : 자릿수 만큼 자리를 차지, 만일 비어있으면 공백, 오른쪽 정렬
        // %-자릿수d : 자릿수 만큼 자리를 차지, 만일 비어있으면 공백, 왼쪽 정렬
        // %0자릿수d : 자릿수 만큼 자리를 차지, 만일 비어있으면 0을 채움
        // %전체자릿수.소수자릿수f
        System.out.printf("저는 %s 이고 나이는 %d 입니다.", "유재석", 30);
        System.out.printf("\n저는 %s이고, 나이는 %6d입니다.\n","유재석",40);
        System.out.printf("\n저는 %s이고, 나이는 %-6d입니다.\n", "유재석", 40);
        System.out.printf("저는 %s 이고 나이는 %06d입니다.\n", "유재석", 40);
        System.out.printf("저는 %-6s 이고 점수는 %5.2f입니다.\n","유재석",123.123456789);


        // [4] 입력객체/함수
        // 1. Scanner : 입력 관련 클래스. sc + 엔터 -> 코드 파일 상단에 import java.util.Scanner;
        // 2. scanner : 관례적으로 변수명은 클래스명의 소문자. (클래스명은 대문자로 시작)
        //              아무거나, 카멜 표기법
        // 3. = 대입
        // 4. new : 인스턴스화, 해당 크ㅡㄹ래스로 객체를 만들겠다는 뜻
        // 5. Scanner( System.in ) : 생성자(클래스명 동일) 안에 시스템입력(System.in) 객체
        // * 클래스/생성자/인스턴스 수업 전까지는 해당하는 한줄의 코드 복붙할 것
        Scanner scanner = new Scanner(System.in);

        // [입력함수] , scanner.nextXXX() *주로 입력(받은)함수 결과는 변수에 저장한다.
        // 6. scanner.next(); : 콘솔(터미널) 창에서 입력받은 자료를 문자열로 반환.
        System.out.println( "1) 문자열 입력: ");
        String str = scanner.next(); // 콘솔(터미널) 창에서 아무거나 입력 후 엔터 기준으로 입력 마침.
        System.out.printf("입력받은 자료 : %s \n", str);
        // *** 문자열타입 변수명 = 문자열반환, 과일상자 == 과일 반환, 과자상자 == 과자반환

        // 7. scanner.nextInt() : 콘솔(터미널)에서 입력받은 자료 정수로 반환
        System.out.println("2) 정수 입력: ");
        int i = scanner.nextInt();
        System.out.printf("입력받은 자료 : %d \n", i);

    }
} // class end

