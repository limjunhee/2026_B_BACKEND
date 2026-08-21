package Day15;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Exam2 {
    public static void main(String[] args) {
        /*
            스택 : 후입선출(나중에 삽입된 자료가 가장 먼저 삭제)
            예시) 브라우저(뒤로가기), ctrl+z(실행 취소), 메소드(처리구조) 등등
        */

        // 스택 클래스 이용한 구현, push() - 삽입, pop() - 출력
        Stack<String> stack = new Stack<>(); // 스택 메모리 만들기
        stack.push("네이버메인페이지");
        stack.push("뉴스페이지");
        stack.push("블로그페이지"); // 입력: 메인 -> 뉴스 -> 블로그
        
        while ( !stack.isEmpty() ) { // 스택이 비어있지 않다면? -> !변수명.isEmpty();
            System.out.println( stack.pop() ); // 출력: 블로그 -> 뉴스 -> 메인
        }

        /*
            큐(Queue): 선입선출(가장 먼저 삽입된 자료가 가장 먼저 삭제)
            예시) 번호표 웨이팅, 프린트 인쇄 프로그램
        */
        
        // LinkedList 클래스 이용하여 객체 구현, offer() - 입력, poll() - 출력
        Queue<String> queue = new LinkedList<>();
        queue.offer("1번 손님");
        queue.offer("2번 손님");
        queue.offer("3번 손님"); // 입력: 1번 -> 2번 -> 3번

        while ( !queue.isEmpty() ) {
            System.out.println( queue.poll() ); // 출력: 1번 -> 2번 -> 3번
        }
    }
}
