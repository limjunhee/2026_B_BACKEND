package Day13;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Exam2 {
    public static void main(String[] args) {
        // [1] 래퍼 클래스 : 기본 타입을 참조 타입으로 표현할 때 --> 참조 타입은 상태/기능을 가짐(기본 타입은 메소드가 없음)
        int value1 = 100;       // System.out.println(value1.toString());
        Integer value2 = 100;   System.out.println(value2.toString());
        
        // 즉) 기본 타입은 기능이 없으니 참조 타입으로 변환하여 기능을 사용하겠다.
        // 1. 언박싱과 오토박싱
        int value3 = value2;    // Integer(참조타입) --> int(기본타입) 변환 = [언박싱]
        Integer value4 = value1; // int(기본타입) --> Integer(참조타입) 변환 = [오토박싱]

        // 2. 타입 변환 (csv, excel, api, python, json, xml 등등)
        // XXX.parseXXX("문자열"); , 유사(JDBC): rs.getXXX()
        int value5 = Integer.parseInt("100");           // "100" 문자열을 정수 100으로 변환 (스프링에서는 자동 변환)
        double value6 = Double.parseDouble("3.14");     // "3.14" --> 3.14 
        boolean value7 = Boolean.parseBoolean("true");  // "true" --> true
        
        // 기본 타입 --> 문자열 반환
        String s1 = 100+"";                     // 공백없이 문자열 더하기 , 100 -> "100"
        String s2 = String.valueOf(100);     // 100 -> "100"

        // [2] 날짜/시간 클래스
        // 1. 현재 날짜 가져오기
        LocalDate localDate = LocalDate.now();  // new LocalDate() 안쓰는 이유 -> Static이라서
        System.out.println(localDate);          // 오늘 날짜를 가져옴

        // 2. 현재 시간 가져오기
        LocalTime localTime = LocalTime.now();  // 현재 시간을 가져옴
        System.out.println(localTime);

        // 3. 현재 날짜/시간 가져오기
        LocalDateTime localDateTime = LocalDateTime.now(); // 현재 날짜, 시간을 가져옴
        System.out.println(localDateTime);

        // 4. 정해진 날짜/시간 객체 생성    LocalDateTime.of( ) : 오버로딩(매개변수에 따른 메소드 여러 개 가능)
        LocalDateTime localDateTime2 = LocalDateTime.of(2026, 8, 19, 11, 11, 30);
        System.out.println(localDateTime2);

        // 5. 정해진 형식으로 날짜/시간 표현 DateTimeFormatter.ofPattern( 패턴 );
        // 패턴 : y 연도 / M 달 / d 일 / h시 / m분 / s초    날짜/시간객체.format(패턴객체)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("y년 MM월 d일, hh시 mm분 s초"); // 형식을 만듦
        System.out.println( localDateTime2.format(formatter)); // 2026년 8월 19일, 11시 11분 30초

        // 6. 날짜 계산, 날짜/시간객체.plusXXX
        LocalDateTime result1 = localDateTime2.plusDays(10);
        System.out.println(result1.format(formatter)); // 2026년 08월 29일, 11시 11분 30초
        LocalDateTime result2 = localDateTime2.minusDays(20);
        System.out.println(result2.format(formatter)); // 2026년 07월 30일, 11시 11분 30초


        // 7. 특정한 날짜/시간 추출하기, getXXX
        System.out.println(localDateTime2.getYear());           // 2026
        System.out.println(localDateTime2.getMonth());          // AUGUST
        System.out.println(localDateTime2.getMonthValue());     // 8
        System.out.println(localDateTime2.getDayOfMonth());     // 19
        System.out.println(localDateTime2.getSecond());         // 30
    }
}

