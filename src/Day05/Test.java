package Day05;

class Book {
    String title;

    // 생성자: 객체 생성 시 전달받은 도서 제목(title)으로 멤버변수(필드)를 초기화합니다.
    Book(String title) {
        this.title = title;
    }
}

public class Test {
    public class Main {
        public static void main(String[] args) {
            Book b1 = new Book("Java Basics"); //인스턴스 b1
            Book b2 = new Book("OOP Concepts"); // 인스턴스 b2

            Book[] library = new Book[3]; // 인스턴스 담는 인스턴스 배열 - 인스턴스 library

            library[0] = b1; // 인스턴스 library의 0번에 인스턴스 a의 주소값 넣음 -> 인스턴스 아님
            library[1] = new Book("Data Structure"); // 인스턴스 library의 1번에 인스턴스 a 생성

            Book b3 = library[1]; // 인스턴스 b3는 인스턴스 b1 참조 -> 인스턴스 아님

            b2 = library[0]; // 인스턴스 b2가 갑자기 인스턴스 library의 0번을 참조함 -> 인스턴스 b2는 b1을 참조하기 시작하고, 인스턴스가 아니게 됨
            
            // 총 인스턴스 생성 수 -> 4개, 유효한 인스턴스 -> b1, library[1] , 사라진 인스턴스 -> b2 = null
            
            Book[] archive = library; // library를 참조하는 archive 배열 생성
            archive[2] = new Book("Algorithm"); // 비어있던 library[3](==archive[3])에 새로운 인스턴스 추가
            // 총 인스턴스 생성 수 -> 5개, 유효한 인스턴스 -> b1, library[1] , 사라진 인스턴스 -> b2 = null

            library[0] = null;
            b1 = null; // b1 인스턴스 사라짐, 그러나 archive[0]에 남아있다
            // 총 인스턴스 생성 수 -> 5개, 유효한 인스턴스 -> b1(archive[0]), library[1], archive[2] , 사라진 인스턴스 -> b2


            
            // ===== 프로그램 실행 종료 직전 (Final State) =====
            // 제시된 코드에서 총 인스턴스는 몇개 만들어졌고 main함수가 종료 되기 전 유효 한 인스턴스는 몇 개 이고 몇개가 사라졌을까?
        }
    }
}
