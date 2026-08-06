package Day07;

public class test2 {
    public static void main(String[] args) {
        
    }
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

class reviewTable {
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

class brandtable {
    int brandID;
    String brandName;
    String brandLogo;
}

class Post {
    int listID; // PK
    int memberID; // FK
    String listTitle;
    String listContent;
    String listDay;
    int thumbsUp;
    int thumbsDown;
}