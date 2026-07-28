package Day01; // 클래스가 속한 폴더명/패키지

public class Exam2 { // class start
    // [1] main 함수 생성 (m + enter 자동완성)
    public static void main(String[] args) { //main start
        // [2] 리터럴 : 상수, 키보드로 입력한 것들. 미리 상수로 구성한 자료들
        // 3, 'a', true 등등

        System.out.println(3); //so + enter
        System.out.println('a'); // 작은따옴표 : 문자 처리
        System.out.println("홍길동"); //큰따옴표 : 문자열 처리
        System.out.println(true);

        // [3] 자료 타입 / 자료형 : 자료(데이터)의 효율적인 분류 방법
        // * 효율 => 자료 크기에 따라 적당한 타입(크기) 선정하여 빈 공간(여백) 줄이기
        // python, js는 동적 타입, 즉 자동으로 타입을 지정하지만 C와 JAVA는 정적 타입으로, 타입을 직접 지정해야 함
        
        // 1) boolean (논리 타입) : true or false, 1byte 사용
        boolean bool1 = true;
        System.out.println(bool1);
        // 2) char = 작은 따옴표로 감싼 문자 1개를 저장함, 유니코드(코드 <-----> 자연어) 사용, 2(영문)/3(한글)byte 사용
        char ch1 = 'A';
        System.out.println(ch1);
        // 3) String = 큰따옴표로 감싼 문자 N게 저장하는 타입, N*2 byte 사용한다. (한글일 경우 n*3 byte), 객체(문자열)
        String str1 = "ABC";
        System.out.println(str1);

        // 4) byte : -128 ~ 127 저장하는 타입, 1byte
        byte b1 = 100; System.out.println( b1 );

        // 5) short : +-3만정도, 2byte
        short sh1 = 30000;

        // 6) int : +- 21억정도, 4byte **** (정수) 리터럴 타입 ****
        int i1 = 200000000; System.out.println(i1);

        // 7) long : +- 21억 이상, 8byte, ***키보드로부터 입력한 정수는 int이므로, 뒤에 L/l 붙인다.
        long l1 = 20000000000L; System.out.println(l1);

        // 실수 : 부동소수점 용한 소수점 표현은 오차가 있으므로 정교한 소수점/계산 라이브러리
        // 8) float : 소수점 8자리까지 표현 가능한 실수 , 4byte ***키보드로부터 입력한 실수는 double이므로, 뒤에 F/f 붙인다.
        float f1 = 0.123456789012345678f; System.out.println(f1);
        // 9) double : 소수점 17자리까지 표현 가능한 실수 , 8byte **** (실수) 리터럴 타입 ****
        double d1 = 0.123456789012345678; System.out.println(d1); //float, double 둘 다 자릿수가 넘어갈 경우 반올림 처리하여 출력

        // 8가지 타입 (기본 타입, 리터럴 저장)
        // 그 외 타입 (참조 타입, 객체/배열//인터페이스 등등)
    }// main end
}// class end
