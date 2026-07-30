package Day03;

import java.util.Scanner;
public class Exam1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // ============================== [문제 1] ==============================
        System.out.print("1) 점수 1 입력:");    int score1 = scan.nextInt();
        System.out.print("1) 점수 2 입력:");    int score2 = scan.nextInt();

        if (score1+score2 >= 90) {
            System.out.println("성공");
        } else {
            System.out.println("실패");
        }

        // ============================== [문제 2] ==============================
        System.out.print("2) 정수 1 입력: ");   int i1 = scan.nextInt();
        System.out.print("2) 정수 1 입력: ");   int i2 = scan.nextInt();

        if (i1 > i2) {
            System.out.println(i1);
        } else {
            System.out.println(i2);
        }

        // ============================== [문제 3] ==============================
        System.out.print("3) 아이디 입력: ");   String id = scan.next();
        System.out.print("3) 비밀번호 입력: ");   String pw = scan.next();

        if (id.equals("admin") & pw.equals("1234")) {
            System.out.println("로그인 성공");
        } else {
            System.out.println("로그인 실패");
        }

        // ============================== [문제 4] ==============================
        System.out.print("4) 비밀번호 입력: ");     String pw2 = scan.next();
        if (pw2.length() < 8) {
            System.out.println("보안 등급: 약함 (8자 이상으로 설정하십시오.)");
        } else if (pw2.length() < 12) {
            System.out.println("보안 등급: 보통");
        } else {
            System.out.println("보안 등급: 강함");
        }

        // ============================== [문제 5] ==============================
        System.out.print("5) 주민등록번호 입력하기(- 포함): ");     String number = scan.next();
        if (number.charAt(7) == '1' || number.charAt(7) == '3') {
            System.out.println("남자");
        } else if (number.charAt(7) == '2' || number.charAt(7) == '4') {
            System.out.println("여자");
        } else  {
            System.out.println("잘못된 형식입니다.");
        }

        // ============================== [문제 6] ==============================
        System.out.print("6) 게임 점수 입력: ");    short gameScore = scan.nextShort();

        if (gameScore >= 900) {
            System.out.println("A급 경품");
        } else if (gameScore >= 700) {
            System.out.println("B급 경품");
        } else if (gameScore >= 500) {
            System.out.println("C급 경품");
        } else {
            System.out.println("참가상");
        }
        
        // ============================== [문제 7] ==============================
        System.out.print("7)사용자 역할 입력: "); String role = scan.next();

        if (role.equals("admin")) {
            System.out.println("모든 기능에 접근할 수 있습니다.");
        } else if (role.equals("editor")) {
            System.out.println("콘텐츠 수정 및 생성 기능에 접근할 수 있습니다.");
        } else if (role.equals("viewer")) {
            System.out.println("콘텐츠 조회만 가능합니다.");
        } else {
            System.out.println("정의되지 않은 역할입니다.");
        }

        // ============================== [문제 8] ==============================
        System.out.print("8)나이 입력하기: " ); int age4 = scan.nextInt();

        if (age4 < 8) {
            System.out.println("무료");
        } else if (age4 <= 19) {
            System.out.println("5,000원");
        } else if (age4 < 65) {
            System.out.println("10,000원");
        } else {
            System.out.println("3,000원");
        }

        // ============================== [문제 9] ==============================
        System.out.print("9) 점수 입력: ");        byte score4 = scan.nextByte();

        if (score4 >= 90) {
            System.out.println("A등급");
        } else if (score4 >= 80) {
            System.out.println("B등급");
        } else if (score4 >= 70) {
            System.out.println("C등급");
        } else {
            System.out.println("재시험");
        }

        // ============================== [문제 10] ==============================
        System.out.println("10) 구매 금액 입력: "); int price = scan.nextInt();

        if (price >= 50000) {
            System.out.println("10% 할인");
        } else if (price >= 30000) {
            System.out.println("5% 할인");
        } else if (price >= 10000) {
            System.out.println("1% 할인");
        } else {
            System.out.println("할인 없음");
        }

        // ============================== [문제 11] ==============================
        System.out.println("11) 월 입력: ");     int month = scan.nextInt();

        if (month >= 3 && month <= 5) {
            System.out.println("봄");
        } else if (month >= 6 && month <= 8) {
            System.out.println("여름");
        } else if (month >= 9 && month <= 11) {
            System.out.println("가을");
        } else if (month == 12 || month == 1 || month == 2) {
            System.out.println("겨울");
        } else {
            System.out.println("잘못된 월입니다.");
        }

        // ============================== [문제 12] ==============================
        // System.out.print("12) 정수 1 입력: ");     int i_1 = scan.nextInt();
        // System.out.print("12) 정수 2 입력: ");     int i_2 = scan.nextInt();
        // System.out.print("12) 정수 3 입력: ");     int i_3 = scan.nextInt();
        // if (i_1 > i_2 && i_1 > i_3) {
        //     System.out.printf("가장 큰 수 :%d", i_1);
        // }
        // if(i_2 > i_1 && i_2 > i_3){
        //     System.out.printf("가장 큰 수 :%d", i_2);
        // }
        // if (i_3 > i_1 && i_3 > i_2) {
        //     System.out.printf("가장 큰 수 :%d", i_3);
        // }

        // ============================== [문제 13] ==============================
        System.out.print("13) 년도 입력: "); int year = scan.nextInt();

        if ((year % 4 == 0 & year % 100 != 0) || year % 400 == 0) {
            System.out.printf("%d년은 윤년입니다.", year);
        } else {
            System.out.printf("%d년은 윤년이 아닙니다.", year);
        }

        // ============================== [문제 14] ==============================
        System.out.print("14) 정수 1 입력: "); int i_1 = scan.nextInt();
        System.out.print("14) 정수 2 입력: "); int i_2 = scan.nextInt();
        System.out.print("14) 정수 3 입력: "); int i_3 = scan.nextInt();

        if (i_1 > i_2 & i_1 > i_3) {
            if (i_2 > i_3) {
                System.out.printf("%d, %d, %d", i_3, i_2, i_1);
            }
            if (i_3 > i_2) {
                System.out.printf("%d, %d, %d", i_2, i_3, i_1);
            }
        } else if (i_2 > i_1 & i_2 > i_3) {
            if (i_1 > i_3) {
                System.out.printf("%d, %d, %d", i_3, i_1, i_2);
            }
            if (i_3 > i_1) {
                System.out.printf("%d, %d, %d", i_1, i_3, i_2);
            }
        } else if (i_3 > i_1 & i_3 > i_1) {
            if (i_1 > i_2) {
                System.out.printf("%d, %d, %d", i_2, i_1, i_3);
            }
            if (i_2 > i_1) {
                System.out.printf("%d, %d, %d", i_1, i_2, i_3);
            }
        }

        // ============================== [문제 15] ==============================
        System.out.print("15) 플레이어 1 준비 (0:가위, 1:바위, 2:보) : "); byte player1 = scan.nextByte();
        System.out.print("15) 플레이어 1 준비 (0:가위, 1:바위, 2:보) : "); byte player2 = scan.nextByte();

        if (player1 == player2) {
            System.out.println("무승부");
        } else {
            if (player1 == 0) {
                if (player2 == 1) {
                    System.out.println("플레이어 2 승리");
                }
                if (player2 == 2) {
                    System.out.println("플레이어 1 승리");
                }
            }
            if (player1 == 1) {
                if (player2 == 0) {
                    System.out.println("플레이어 1 승리");
                }
                if (player2 == 2) {
                    System.out.println("플레이어 2 승리");
                }
            }
            if (player1 == 2) {
                if (player2 == 0) {
                    System.out.println("플레이어 2 승리");
                }
                if (player2 == 1) {
                    System.out.println("플레이어 1 승리");
                }
            }
        }
    }
}