package Day13;

import java.util.Arrays;

public class Exam3 {
    public static void main(String[] args) {
        
        // String 클래스
        // 1. 문자열은 배열임
        char str1 = '유'; // char 타입은 1글자만 가능
        char[] str2 = {'유', '재', '석'}; // char 타입의 배열
        String str3 = "유재석"; // String 클래스는 배열의 멤버변수를 가짐

        // 2. 문자 변환
        char str4 = 65;     System.out.println(str4); // 65 -> A (아스키코드 변환)
        char[] str5 = { 74, 65, 86, 65 };       System.out.println(str5); // JAVA 출력
        char str6 = '유';   System.out.println(str6);   System.out.println((int)str6); // 50976
        // * 정수 - char(규칙)-> 문자 - 배열 -> 문자열 *
        
        // 3. 문자열 비교
        System.out.println("유재석"=="유재석");                                         // true
        System.out.println( new String("유재석") == "유재석");                  // false
        System.out.println(new String("유재석").equals("유재석"));      // true
    
        // 4. 문자열A.concat(문자열B) : 문자열 연결, 연결된 새로운 문자열을 반환함 ( 주소값 생성 )
        String str7 = "자바";   String str8 = "프로그래밍";
        System.out.println( str7.concat(str8) );            // 문자열이 연결됨 -> 자바프로그래밍
        System.out.println( str7 + str8 );                  // 자바프로그래밍

        // 5. StringBuilder , append( )
        // 문자열(리터럴)은 불변(수정불가)이다.
        // 빌더 주소값 1개만 지정해서 넣었다 뺐다 가능
        StringBuilder builder = new StringBuilder();
        builder.append(str7);
        builder.append(str8);
        System.out.println(builder); // 자바프로그래밍

        // 6. .chatAt( 인덱스 ) , 문자열에서 문자 하나 추출
        String str9 = "자바프로그래밍";     System.out.println(str9.charAt( 2)); // 프

        // 7. .length() : 문자열 내 문자 개수를 반환
        System.out.println( str9.length() );    // 7

        // 8. .replace(기존문자, 새로운문자) : 만약 기존 문자가 존재하면, 새로운 문자로 치환하여 반환(새로운 문자열로 반환) 
        System.out.println(str9.replace("자바", "JAVA")); // JAVA프로그래밍

        // 9. .substring( 시작 인덱스, [끝 인덱스]) : 시작 인덱스부터 끝 인덱스까지 문자열을 추출함
        String str10 = "012345-1230123";
        System.out.println(str10.substring(6)); // -1230123
        System.out.println(str10.substring(0, 6)); // 012345

        // 10. .split( 기준문자 ) : 기준 문자를 기준으로, 문자열을 분해함
        System.out.println(str10.split("-"));  // [Ljava.lang.String;@2ff4acd0
        String[] strArray = str10.split("-");  // [0]012345 / [1]1230123
        System.out.println(strArray[0]);             // 012345
        System.out.println(strArray[1]);             // 1230123

        // 11. .indexOf( 찾을문자 ) : 만약, 찾을 문자가 존재한다면 인덱스, 없다면 -1을 반환함
        //      .contains( 찾을문자 ) : 만약 찾을 문자가 존재한다면 true, 없다면 false를 반환함
        System.out.println("자바 프로그래밍 언어".indexOf("프로"));     // 3
        System.out.println("자바 프로그래밍 언어".indexOf("pro"));      // -1

        System.out.println("자바 프로그래밍 언어".contains("프로"));      // true
    
        // 12. .getBytes(); , 문자열 내 문자들을 바이트 배열 반환       *파일 처리/네트워크처리*
        byte[] strArray2 = "ABC".getBytes();
        System.out.println( Arrays.toString(strArray2)); // "ABC" ---> [65, 66, 67]
        System.out.println( new String( strArray2 ));    // [65, 66, 67] ---> "ABC"
    }
}
