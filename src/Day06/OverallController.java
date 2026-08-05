package Day06;

import java.util.Scanner;

public class OverallController {
    public static void main(String[] args) {
        Post[] posts = new Post[100];
        Scanner scanner = new Scanner( System.in, "EUC-KR" );
        
        for( ; ; ){
            System.out.println("============ My Community ============");
            System.out.println("1. 게시물쓰기 / 2. 게시물출력 / 3. 퇴장");
            System.out.println("======================================");
            System.out.print("선택: ");
            byte choice = scanner.nextByte();

            //입력 선택
            if (choice == 1) {
                System.out.println("선택> 1");
                scanner.nextLine();
                System.out.print("내용 : ");
                String text = scanner.nextLine();
                System.out.print("작성자 : ");
                String user = scanner.nextLine();

                // 객체화, 결과bool 선언
                Post post = new Post(text, user);
                boolean result = false;

                // 배열에 삽입
                for( int index = 0; index <= posts.length - 1; index++ ){
                    if ( posts[index] == null ) {
                        posts[index] = post;
                        result = true;
                        break;
                    }
                }

                // 삽입 결과
                if (result == true) {
                    System.out.println("[안내] 글쓰기 성공");
                } else {
                    System.out.println("[안내] 글쓰기 실패");
                }
            }

            if (choice == 2) {
                // 전체 배열 돌리는 for문으로 출력
                for (Post post : posts ){
                    if (post != null) {
                        System.out.printf("작성자: %s , 내용: %s \n", post.text, post.user);
                    }
                }
            }
            
            if (choice == 3) {
                break;
            }
        }
    }
}

class Post {
    String text;
    String user;

    Post (String text, String user){
        this.text = text;
        this.user = user;
    }
}