package Day09;

public class JAVA_Practice10 {
    public static void main(String[] args) {
        // 1
        Member member = new Member();
        member.setId("admin");
        System.out.println(member.getId());
        
        // 2
        Score score1 = new Score();
        Score score2 = new Score();
        score1.setScore(120);
        score2.setScore(80);

        System.out.println(score1.getScore());
        System.out.println(score2.getScore());
    }
}

class Member{
    private String id; // 외부 클래스에서 접근 불가능한 멤버 변수
    // 오른쪽 -> 소스 작업 -> setter and getter
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
}

class Score {
    private int score;

    public void setScore(int score) {
        if (score >=0 && score <= 100 ) {
            this.score = score;  
        } else {
            System.out.println("유효하지 않은 점수");
        }
    }
    public int getScore() {
        return score;
    }
}