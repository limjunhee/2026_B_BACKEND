package Day09;

import java.util.ArrayList;
import java.util.Scanner;




public class JAVA_Practice11 {
    public static void main(String[] args) {
        // 1
        // ArrayList< 요소타입 > 변수명 = new ArrayList<>();
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("유재석"); 
        nameList.add("강호동");
        nameList.add("신동엽");

        System.out.println(nameList);

        // 2
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("사과");
        fruits.add("바나나");
        fruits.add("딸기");
        for (int i = 0; i <= fruits.size() - 1; i++) {
            System.out.println( "인덱스 " + i +": "+ fruits.get(i));
        }

        // 3
        for(String fruit : fruits){ System.err.println(fruit); }

        // 4
        ArrayList<String> alphabets = new ArrayList<>();
        alphabets.add("A");
        alphabets.add("B");
        alphabets.add("C");
        alphabets.add("D");
        alphabets.add("E");
        alphabets.remove("C");
        System.out.println(alphabets);
        
        // 5
        ArrayList<String> list5 = new ArrayList<>();
        list5.add("자바");
        list5.add("파이썬");
        list5.add("C++");

        list5.add(1,"자바스크립트");
        System.out.println(list5);

        // 6
        ArrayList<Book> library = new ArrayList<>();
        library.add(new Book("저자1", "제목1"));
        library.add(new Book("저자2", "제목2"));
        library.add(new Book("저자3", "제목3"));
        for(Book book : library){
            System.out.println( book.getTitle() + " : " + book.getAuthor());
        }

        // 7
        Scanner scanner = new Scanner(System.in, "EUC-KR");
        ArrayList<String> inputList = new ArrayList<>();
        for(;;){
            System.out.print("문자열 입력하기: ");
            String input = scanner.next();
            if (input.equals("종료")) {
                System.out.println(inputList);
                break;
            } else {
                inputList.add(input);
            }
        }
        /*
         * [문제 8] "국어", "수학", "사회", "과학"을 요소로 가지는 ArrayList를 생성하세요.
         * 1. .set(인덱스, 요소) 메소드를 사용하여 1번 인덱스의 "수학"을 "영어"로 수정하세요.
         * 2. 수정 후의 리스트 전체를 출력하여 결과가 올바른지 확인하세요.
         */
        // 8
        ArrayList<String> SubjectList = new ArrayList<>();
        SubjectList.add("국어");
        SubjectList.add("수학");
        SubjectList.add("사회");
        SubjectList.add("과학");

        SubjectList.set(1, "영어");
        System.out.println(SubjectList);
    }
}

// 6
class Book {
    private String author;
    private String title;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book [author=" + author + ", title=" + title + "]";
    }
    
}