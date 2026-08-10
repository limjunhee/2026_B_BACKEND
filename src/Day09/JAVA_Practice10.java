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

        // 3
        BankAccount account = new BankAccount("123-456");
        System.out.println(account.getAccountNumber());

        // 4
        CircleCalculator circle1 = new CircleCalculator(5);
        System.out.println(circle1.printCircleArea());

        // 5
        TicketMachine machine1 = new TicketMachine();
        TicketMachine machine2 = new TicketMachine();
        TicketMachine machine3 = new TicketMachine();

        machine1.issueTicket(); 
        machine1.issueTicket();
        machine2.issueTicket();

        TicketMachine.printTotalTickets(); // 각 기기에서 발권된 수를 출력하는 게 아님 -> 3

        // 6
        System.out.println(GameConfig.GAME_TITLE);
        System.out.println(GameConfig.MAX_HP);
        System.out.println(GameConfig.MAX_LEVEL);
    }
}

// 1
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

// 2
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


// 3
class BankAccount{
    private String accountNumber;

    BankAccount(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    
}

// 4
class CircleCalculator{
    final double PI = 3.14159;
    double radius;

    CircleCalculator(double radius){
        this.radius = radius;
    }

    public double printCircleArea(){
        return radius * radius * PI;
    }
}

// 5
class TicketMachine {
    static int totalTickets = 0;

    void issueTicket(){
        totalTickets++;
        System.out.println("티켓 1장을 발권했습니다.");
    }

    static void printTotalTickets(){
        System.out.printf("발권된 티켓 수: %d \n", totalTickets);
    }
}

// 6
class GameConfig{
    public static final int MAX_LEVEL = 99;
    public static final int MAX_HP = 10000;
    public static final String GAME_TITLE = "My RPG";
}