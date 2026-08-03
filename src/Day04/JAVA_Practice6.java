package Day04;

import java.util.Arrays;
import java.util.Scanner;

public class JAVA_Practice6 {
    public static void main(String[] args) {
        //1
        int[] numbers1 = { 10, 20, 30, 40 , 50}; System.out.println(numbers1[2]);

        //2
        String[] season = new String[3];
        season[0] = "봄"; 
        season[1] = "여름";
        season[2] = "가을";
        System.out.println(Arrays.toString(season));

        //3
        String[] fruits = {"사과", "바나나", "포도", "딸기"};
        for (int i = 0; i < fruits.length; i++) {
            System.out.println(fruits[i]);
        }
        //vs
        for(String str : fruits ) {System.out.println(str);}

        //4
        int[] scores1 = { 85, 92, 78, 65, 95 };
        double sum = 0;
        float average = 0.0f;
        for (int score : scores1) {
            sum += score;
        }
        System.out.printf("합계 : %.0f , 평균 : %.1f \n", sum, sum / scores1.length );

        //5
        int[] scores2 = { 77, 82, 100, 54, 96 };
        for (int score : scores2) {
            if (score == 100) {
                System.out.println("만점자!"); break;
            }
        }

        //6
        String[] bloodTypes = { "A", "B", "O", "AB", "A", "B", "A" };
        int count = 0;
        for( String str : bloodTypes){
            if (str.equals("A")) {
                count++;
            }
        }

        //7
        int[] numbers2 = { 23, 5, 67, 12, 88, 34 };
        int max = 0;
        for (int i : numbers2){
            if (max < i) {
                max = i;
            }
        }
        System.out.println(max);

        //8
        String[] products = {"볼펜", "노트", "지우개"};
        int[] stock = {10, 5, 20};
        Scanner scan = new Scanner( System.in );
        System.out.print("구매할 상품명: "); String 상품명 = scan.next();
        System.out.print("구매할 수량: "); int 수량 = scan.nextInt();
        boolean find = false;
        for(int index = 0; index <= products.length - 1; index++){
            if (상품명.equals( products[index] ) ) {
                find = true;
                if (수량 <= stock[index]) {
                    stock[index] -= 수량;
                }else{
                    System.out.println("재고가 부족합니다.");
                }
            }
        }

        //9
        String[] movieNames = {"히든페이스", "위키드", "글래디에이터2", "청설"};
        int[] movieRatings = {8, 4, 7, 6};

        for( int index = 0; index <= movieNames.length - 1; index++){
            // [1] 영화 이름을 하나씩 출력
            String name = movieNames[index];
            System.out.print( name );

            // [2] 별점 출력하기
            for( int star = 1; star <= 10; star++ ){
                // 현재 별보다 index번째 평점이 더 작으면 검은별
                if (star <= movieRatings[index]) {
                    System.out.print("★ ");
                } else {
                    System.out.print("☆ ");
                }
            }
            System.out.println();
        }

        //10
        String[] carNumbers = {"210어7125", "142가7415", "888호8888", "931나8234"};
        int[] usageMinutes = {65, 30, 140, 420};

        for(int i = 0; i <= carNumbers.length - 1; i++){
            int fee = 0;
            if (usageMinutes[i] <= 30) {
                fee = 1000;
            } else {
                int minutes = usageMinutes[i] - 30;
                // System.out.println(minutes);
                fee = 1000 + 500 * (minutes / 10);
                // System.out.println(fee);
            }

            if (fee > 20000) {
                fee = 20000;
            }
            System.out.printf("%s : %d분 주차, 최종 요금 : %d원\n", carNumbers[i], usageMinutes[i], fee);
        }

    }
}