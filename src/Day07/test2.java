package Day07;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
       OverallRepository review_repository = new OverallRepository();
       OverallRepository post_repository = new OverallRepository();
        Scanner scan = new Scanner(System.in, "EUC-KR");
        for (;;) {
            System.out.println("============ My Community ============ ");
            System.out.println("1. 게시물등록, 2. 게시물출력, 3. 리뷰등록, 4. 리뷰출력");
            System.out.println("====================================== ");
            System.out.print("선택>");
            int ch = scan.nextInt();

            if (ch == 1) {
                scan.nextLine();
                System.out.print("게시물내용 : ");    String content = scan.nextLine();
                System.out.print("게시물작성자 : ");        String writer = scan.nextLine();

                Post post = new Post(content, writer);
                boolean result = review_repository.postsave(post);

                if (result) { System.out.println("[안내] 리뷰등록 성공");} 
                else { System.out.println("[안내] 글쓰기 실패"); }

            } else if (ch == 2) {
                Post[] posts = review_repository.findAllPosts();
                for (Post post : posts) {
                    if (post != null) {
                        System.out.printf("리뷰내용 : %s , 점수 : %s \n", post.content, post.writer);
                    }
                }
            } else if (ch == 3) {
                scan.nextLine();
                System.out.print("리뷰내용 : ");    String review = scan.nextLine();
                System.out.print("리뷰점수 : ");        int score = scan.nextInt();
                System.out.print("리뷰작성일 : ");        String listDay = scan.nextLine();

                reviewTable post = new reviewTable(review, score, listDay);
                boolean result = review_repository.reviewsave(post);

                if (result) { System.out.println("[안내] 리뷰등록 성공"); }
                else { System.out.println("[안내] 리뷰등록 실패"); }
            } else if (ch == 4) {
                reviewTable[] posts = review_repository.findAllReviews();
                for (reviewTable post : posts) {
                    if (post != null) {
                        System.out.printf("리뷰내용 : %s , 리뷰점수 : %d , 리뷰작성일 : %s \n", post.review, post.score, post.listDay);
                    }
                }
            }
        }
    }
}

class OverallRepository {

    Post[] posts = new Post[100];
    reviewTable[] reviewTable = new reviewTable[100];

    boolean postsave(Post post) {
        for (int index = 0; index < posts.length; index++) {
            if (posts[index] == null) {
                posts[index] = post;
                return true;
            }
        }
        return false;
    }

    // 리뷰테이블에 저장
    boolean reviewsave(reviewTable revTable) {
        for (int index = 0; index < reviewTable.length; index++) {
            if (reviewTable[index] == null) {
                reviewTable[index] = revTable;
                return true;
            }
        }
        return false;
    }

    Post[] findAllPosts() {
        return posts;
    }

    // 리뷰테이블 전체 목록 반환
    reviewTable[] findAllReviews() {
        return reviewTable;
    }
}

// 게시물 
class Post {
    String content;
    String writer;

    Post() {
    }

    Post(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }
}


// 리뷰테이블 class 생성
class reviewTable {
    String review;
    int score;
    String listDay;

    // 기본 생성자 생성
    reviewTable() {
    }

    reviewTable(String review, int score, String listDay) {
        this.review = review;
        this.score = score;
        this.listDay = listDay;
    }
}








class Post2 {
    int listID; // PK
    int memberID; // FK
    String listTitle;
    String listContent;
    String listDay;
    int thumbsUp;
    int thumbsDown;
}

class cigarTable{
    int cigarID;
    int brandID;
    String cigarName;
    String Category;
    int price;
    float nicotine;
    float tar;
    boolean isCapsule;
    String cigarimg;
}

class reviewTable2 {
    int reviewID;
    int CigarID;
    int MemberID;
    String review;
    int score;
    String listDay;
}

class memberTable {
    int memberID;
    String userID;
    String userPW;
    String userName;
    String userPhoto;
}

class Brandtable {
    int brandID;
    String brandName;
    String brandLogo;

    Brandtable() {
    }

    Brandtable(int brandID, String brandName) {
        this.brandID = brandID;
        this.brandName = brandName;
    }

}



