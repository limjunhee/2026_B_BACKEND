package Day04;
import java.util.Scanner;

public class JAVA_Practice4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in, "EUC-KR" );
        // ======================== [문제 1] ========================
        System.out.println("[1번 문제]");
        
        for(int i = 1; i <= 10; i++){
            System.out.println(i);
        }

        // ======================== [문제 2] ========================
        System.out.println("[2번 문제]");

        for (int i = 10; i >= 1; i--){
            System.out.println(i);
        }

        // ======================== [문제 3] ========================
        System.out.println("[3번 문제]");
        int result3 = 0;
        for(int i = 1; i <= 50; i++ ){
            result3 += i;
        }
        System.out.println(result3);

        // ======================== [문제 4] ========================
        System.out.println("[4번 문제]");
        for(int i = 1; i <= 20; i++){
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }

        // ======================== [문제 5] ========================
        System.out.println("[5번 문제]");
        for(int i = 1; i <= 30; i++){
            if (i % 3 == 0) {
                continue;
            }
            System.out.println(i);
        }

        // ======================== [문제 6] ========================
        System.out.println("[6번 문제]");
        int result6 = 0;
        for(int i = 1; ; i++){
            if (result6 > 100) {
                System.out.println(result6);
                break;
            }
            result6 += i;
        }

        // ======================== [문제 7] ========================
        System.out.println("[7번 문제]");

        for(int i = 1; i <= 5; i++){
            for(int j = 1; j <= i; j++ ){
                System.out.print('*');
            }
            System.out.println();
        }

        // ======================== [문제 8] ========================
        System.out.println("[8번 문제]");
        for(int i = 5; i >= 0; i-- ){
            for (int j = 1; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }

        // ======================== [문제 9] ========================
        System.out.println("[9번 문제]");
        int count = 0;
        while (true) {
            count++;
            System.out.print("문자열 입력하기: ");
            String str = scanner.next();
            System.out.printf("%d회 입력: %s\n", count, str);

            if (str.equals("end")) {
                System.out.println("[프로그램을 종료합니다.]");
                System.out.printf("[총 %d회 입력]\n", count);
                break;
            }
        }

        // ======================== [문제 10] ========================
        System.out.println("[10번 문제]");
        int july1 = 3532100; int july2 = 9123700; int july3 = 5183400; int july4 = 11738700;
        int[] arr = {july1, july2, july3, july4};

        System.out.println("------- 7월 매출액 -------");
        for(int i = 0; i <= arr.length - 1; i++){
            int price = 0; //매출액 최종변환 결과 담을 변수
            price = arr[i];
            price /= 10000; //'만원' 단위로 변환
            // System.out.printf("%d만원\n", price);

            int cubes = 0; // '■' 찍을 횟수
            cubes = price / 100;
            // System.out.printf("%d", cubes);

            // 주차별 문자열 출력하기
            System.out.printf("%d주차 매출액: ", i+1);
            for(int c = 1; c <= cubes; c++){
                System.out.print('■');
            }
            System.out.printf("%d만원\n", price);
        }

        // ======================== [문제 11] ========================
        System.out.println("[11번 문제]");
        int balance = 0;

        for( ; ; ){
            System.out.print("\"1:입금 | 2:출금 | 3:잔고 | 4:종료\" : ");

            int choice = scanner.nextInt(); // 선택값(1~4)

            switch (choice) {
                case 1:
                    System.out.println("1 - 입금 선택");
                    System.out.print("입금액 입력: ");
                    int plus = scanner.nextInt();
                    balance += plus;
                    break;
                case 2:
                    System.out.println("2 - 출금 선택");
                    System.out.print("출금액 입력: ");
                    int min = scanner.nextInt();
                    if (balance < min) {
                        System.out.println("출금할 잔고가 없음.");
                        break;
                    }
                    balance -= min;
                    break;
                case 3:
                    System.out.println("3 - 현재 잔고 확인");
                    System.out.printf("현재 잔고: %d \n", balance);
                    break;

                case 4:
                    break;
                default:
                    System.out.println("잘못된 입력");
                    break;
            }
            if(choice == 4){
                System.out.println("프로그램 종료");
                break;
            }
        }
    }
}