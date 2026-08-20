/*

.java 파일 만들기
 1. 내가 만들고자 하는 폴더에 오른쪽 클릭하고, [new java file] -> [class]
 2. 첫 글자가 영문 대문자로 시작하는 임의의 클래스명으로 생성해줌

자바 주석 == 자바스크립트 주석
*/

package Day01; // 패키지(폴더명), 클래스의 위치 식별도 역할

public class Exam1 {
    // public : 공개용, 다른패키지에서 사용 가능한 클래스 뜻
    // class : 클래스 선언 시 사용 키워드
    // Exam1 : 클래스명 -> 아무거나 해도 되지만 첫 글자는 무조건 대문자여야 한다.
        // * 클래스: 자바에서의 가장 최소 컴파일/번역/통역사 단위 -> { } 밖에 쓴 코드는 실행 X
    // { 클래스 시작 뜻 , } 클래스 끝 뜻

    // [ 클래스 안 / main 함수 밖 ] -> 선언만 가능한 공간, 실행문 불가능
    // System.out.println("hello"); -> 이거 안됨
    int b = 10; // 선언 가능

    // [1] 자바 실행 시작점 생성, main 함수( 번역한 코드를 읽어들이는 흐름 단위 = 메인 스레드 )
    // m + enter main 함수 자동 완성, *JS에 없는 이유 -> 브라우저 엔진이 해주므로 main{}함수 필요 없음
    public static void main(String[] args) {
        // [main 함수 안 -> 선언 및 실행문 가능]

        // [2] 콘솔 출력문 생성하기
        //so + enter -> js의 console.log == System.out.println()
        System.out.println( "ㅎㅇ");
        
        // [3] 세미콜론 -> 자바에서 코드의 문장이 끝나는 뜻으로 받아들임
    }

} //class Exam1 end

// * class 밖에선 작동 코드를 작성하지 말자. (외부 클래스 작성용)*