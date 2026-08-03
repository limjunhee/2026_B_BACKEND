package Day04;

public class Exam1 {
    public static void main(String[] args) {
        
        //조건문 (if, switch)
        
        int 온도 = 5;
        
        if (온도 <= 10) System.out.println("외투입기");   

        if (온도 <= 10) {
            System.out.println("외투입기");
            System.out.println("긴 바지 입기");
        }

        if (온도 <= 10) {
            System.out.println("외투입기");
        } else {
            System.out.println("외투벗기");
        }

        if (온도 <= 10) {
            System.out.println("외투입기");
        } else if (온도 <= 5) {
            System.out.println("외투안입기");
        } else if (온도 <= 3) {
            System.out.println("반바지 입기");
        } else {
            System.out.println("밖에 안나가기");
        }

        // if 여러번 쓰는 것 vs if-else if 쓰는 것을 구분할 것

        System.out.println("if문 실습 끝");
        
        
        // switch : 논리 검사(true/false, 삼항연산자)가 아닌, *값에 따른 흐름 제어*
        //  true / false 쓰는 곳이 아님
        // switch (자료) {
        //     case 값1:               //값1일경우
                
        //         break;
        //     case 값2:               // 값2일 경우
                
        //         break;
        //     default:                // 기본값
        //         break;
        // } 

        char grade = 'B';
        switch (grade) {
            case 'A':
                System.out.println("A등급입니다.");
                break;
            case 'B':
                System.out.println("B등급입니다.");
                break;
            case 'C':
                System.out.println("C등급입니다.");
                break;
            default:
                System.out.println("불합격");
                break;
        }


        //반복문
        for (int i = 0; i < args.length; i++) {
            
        }


    }
}
