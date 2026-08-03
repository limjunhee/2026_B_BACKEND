package Day04;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Exam3 {
    public static void main(String[] args) {
        /*
            JAVA 배열 : *동일한타입*의 여러 자료들을 순서(인덱스)대로 저장하는 *타입*
            선언 : 2가지
                - 타입[ ] 변수명 = new 타입명[ 총개수 ]; 
                - 타입[ ] 변수명 = { 초기값, 초기값, 초기값 };

            특징 :  1) 동일한 타입끼리 
                    2) 고정(정적) 길이 
                    3) 요소초기값(자동) 정수:0, 실수: 0.0, 논리:false, 객체:null

            인덱스: 요소(자료)들이 저장되는 순서 번호, 0번 시작
        */

        // [1] 배열의 선언
        int [] arr1 =  new int [ 3 ]; // int형 3개를 저장 가능한 배열 선언
        System.out.println( arr1 ); // 배열은 하나의 타입(동일한 타입 여러개 저장하는 타입) -> 메모리 주소값이 나옴 = I@2ff4acd0
        System.out.println(Arrays.toString(arr1)); // 배열을 찍는 게 아니라 Arrays.toString()을 통해 내용물 확인 = [ 0, 0, 0 ]
        
        String[] arr2 = { "유재석", "강호동", "신동엽" }; // String형 3개 초기화한 배열 선언
        // String[] arr2 = { "유재석", 3, "신동엽" }; // 타입 섞어서 불가능

        // [2] 배열의 요소 호출
        System.out.println( arr1[0] ); // 0번 인덱스의 자료 호출
        System.out.println( arr2.length ); // 배열변수명.length : 요소총개수
        System.out.println( arr2[1] ); // 1번 인덱스의 자료 호출 - '강호동'

        // 선언 이후 길이(요소) 추가 / 변경 / 삭제 안된다.
        arr2[0] = "유재석2"; // 기존 요소를 새로운 값으로 바꿀 수는 있다.
        System.out.println(arr2[0]);
        // arr2.push("하하"); arr2[3] = "하하"; // 존재하지 않는 인덱스 수정 및 추가는 불가능
        // arr2.splice(0, 1); // 삭제 못함

        /*
         * 배열 메모리 : 메모리 1byte 단위로 저장!
         * - 자바 int 1개 선언 -> 4byte -> [ ] [ ] [ ] [ ] 4개의 메모리가 컴퓨터 할당
         * - 자바 new int [ 3 ] 선언 -> 4byte * 3 선언 -> 4 * 3 = 12개의 메모리를 컴퓨터가 할당
         * - byte 단위별 주소값 정해진다.
         * - [ 101 ] [ 102 ] [ 103 ] [ 104 ], [ 201 ] [ 202 ] [ 203 ] [ 204 ], [ 301 ] [ 302 ] [ 303 ] [ 304 ]
         * 즉 배열은 요소내 모든 인덱스 주소값 참조하지 않고 가장 앞에 있는 주소값 1개(101호)만 참조한다.
         * 배열명[0] = 101
         * 배열명[1] = 타입크기만큼 이동 -> 201호
         * 배열명[2] = 301
         */
    }
}
