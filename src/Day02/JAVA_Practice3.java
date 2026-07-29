package Day02;
import java.util.Scanner;

public class JAVA_Practice3 {
public static void main(String[] args) {
        // 연산자는 JS와 동일, !== === 강력비교 제외한 java와 js 연산자 동일
        Scanner scanner = new Scanner(System.in, "EUC-KR");
        
        /* ============== [문제 1] ============== */

        System.out.print("국어 점수 입력:");
        int score1 = scanner.nextInt();
        System.out.print("영어 점수 입력:");
        int score2 = scanner.nextInt();
        System.out.print("수학 점수 입력:");
        int score3 = scanner.nextInt();

        int result1 = score1+score2+score3;
        double result2 = result1/3.0;

        System.out.printf("총점: %d, 평균: %.1f", result1, result2);

        /* ============== [문제 2] ==============  */
        System.out.print("원의 반지름 입력: ");
        double radius = scanner.nextDouble();
        double result3 = radius * radius * 3.14;
        System.out.printf("원의 넓이: %f", result3);

        
        /* ============== [문제 3] ============== */
        System.out.print("첫 번째 실수 입력: ");
        double d1 = scanner.nextDouble();
        System.out.print("두 번째 실수 입력: ");
        double d2 = scanner.nextDouble();

        double result4 = d1/d2 * 100;
        System.out.printf("비율: %.1f", result4);

        /* ============== [문제 4] ============== */
        System.out.print("정수 하나 입력: ");
        int i = scanner.nextInt();
        if (i % 2 != 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        /* ============== [문제 5] ============== */
        System.out.print("정수 하나 입력: ");
        int i1 = scanner.nextInt();
        if (i1 % 7 != 0) {
            System.out.println(false);
        } else {
            System.out.println(true);
        }


        /* ============== [문제 6] ============== */
        System.out.print("ID 입력: ");
        String id = scanner.next();
        System.out.print("비밀번호 입력: ");
        String pw = scanner.next();

        if (id.equals("admin") == true & pw.equals("1234") == true ) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }


        /* ============== [문제 7] ============== */
        System.out.print("정수 하나 입력: ");
        int i2 = scanner.nextInt();
        if (i2 % 2 != 0 & i2 % 7 == 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        /* ============== [문제 8] ============== */
        System.out.print("점수 1 입력: ");
        int i3 = scanner.nextInt();
        System.out.print("점수 2 입력: ");
        int i4 = scanner.nextInt();

        if (i3+i4 >= 150) {
            System.out.println("합격");
        } else {
            System.out.println("불합격");
        }

        /* ============== [문제 9] ============== */
        System.out.print("1. 이름 입력: ");
        String name = scanner.nextLine();
        System.out.println(name);
        if (name.equals("유재석") == true) {
            System.out.print(true);
        } else {
            System.out.println(false);
        }

        /* ============== [문제 10] ============== */
        System.out.print("삼각형 밑변 입력: ");
        double d3 = scanner.nextDouble();
        System.out.print("삼각형 높이 입력: ");
        double d4 = scanner.nextDouble();

        double result10 = d3 * d4 / 2;
        System.out.printf("삼각형의 넓이: %.1f\n", result10);

        /* ============== [문제 11] ============== */
        System.out.print("섭씨 온도 입력: ");
        double temp = scanner.nextDouble();

        double result11 = (temp * 9.0 / 5.0 ) + 32;
        System.out.printf("화씨 온도: %.1f", result11);

        /* ============== [문제 12] ============== */
        System.out.print("태어난 년도 입력");
        int age = scanner.nextInt();
        int result12 = 2025 - age;
        System.out.printf("2025년 기준 나이: %d", result12);

        /* ============== [문제 13] ============== */
        System.out.print("키(cm) 입력: ");
        double height = scanner.nextDouble();
        height /= 100.0;
        System.out.print("몸무게(kg) 입력: ");
        double weight = scanner.nextDouble();
        double result13 = weight / (height * height);
        System.out.printf("BMI 지수: %.2f", result13);

        /* ============== [문제 14] ============== */
        System.out.print("아이디 입력: ");
        String id2 = scanner.next();
        System.out.print("이메일 입력: ");
        String email = scanner.next();

        System.out.println(id2.equals("admin") == true || email.equals("admin@test.com") == true? "관리자" : "일반 사용자");

        /* ============== [문제 15] ============== */
        System.out.println("점수 입력: ");
        int score = scanner.nextInt();
        if (score >= 90) {
            System.out.print("등급: A");
        } else if (score >= 80) {
            System.out.print("등급: B");
        } else {
            System.out.print("등급: C");
        }

        /* ============== [문제 16] ============== */
        System.out.print("나이 입력: ");
        int age3 = scanner.nextInt();

        System.out.println(age3 >= 20 & age3 <= 29 == true ? "이벤트 대상입니다." : "이벤트 대상이 아닙니다.");
    }
}
