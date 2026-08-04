package Day04;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = new int [0]; // [1] 0개 저장 가능한 배열

        // array[ array.length - 1 ] = 30; // [2] Index -1 out of bounds for length 0 -> 인덱스 없다고 한다.

        int[] newArray = new int[ array.length + 1]; // [3] 현재 배열에서 +1 증가한 새로운 배열 만들기

        // 기존배열 내 요소들의 값들을 새로운 배열에 복사함
        for (int index = 0; index < array.length; index++) {
            newArray[index] = array[index];
        }

        newArray[ newArray.length - 1 ] = 30; // [4] 2번째 과정 반복하기

        array = newArray; // [5] 기존 배열에 새로운 배열을 대입하기

        System.out.println(Arrays.toString(array)); // [30] 출력
    }
}
