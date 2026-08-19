package Day13;

import java.util.Random;
import java.util.UUID;

public class Exam4 {
    public static void main(String[] args) {
        
        // [1] 난수 클래스 - 임시 인증번호, 비밀번호 만들기 등
        // 1. 랜덤 객체
        Random random = new Random();
        
        // 2. 랜덤 생성 : nextXXX( ), .nextXXX( 개수 ) + 시작번호
        int value1 = random.nextInt(); System.out.println(value1);                // 실행할 때마다 서로 다른 값으로 난수가 생성됨.
        int value2 = random.nextInt(10); System.out.println(value2);        // 0 ~ 9 범위 내에서 난수 생성
        int value3 = random.nextInt(10) + 1; System.out.println(value3);    // 1~10 범위 내에서 난수 생성
        boolean value4 = random.nextBoolean(); System.out.println(value4);         // true/false 난수

        // [2] UUID , 범용 고유 식별자. 절대 중복 없는 난수 생성
        // * 
        String uuid = UUID.randomUUID().toString();
        System.out.println( uuid ); // 86726571-95fc-4485-b826-90231e2596ca
    }
}
