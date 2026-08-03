package Day04;

public class Exam2 {
public static void main(String[] args) {
    // 1.for(초기값; 조건문; 증감식;){ 실행문; }
    for( int i = 2; i <= 9; i++){
        for(int j = 1; j <= 9; j++){
            System.out.printf("%d * %d = %d \n", i, j, i*j);
        }
    }

    // 2. break; = 반복문 탈출, continue; = 증감식 즉시 이동
    for( int i = 1; i <= 10; i++){
        if (i == 3) {
            continue;
        }
        if (i == 9) {
            break;
        }
        System.out.println(i);
    }

    // 3. 무한루프 : 영원히 실행문 반복
    for( ; ; ){System.out.println("무한반복"); break;}
    while (true) { System.out.println("무한반복"); break; }
    
    // 4. while(조건문){ 실행문; }  [VS] for문
    int i = 1;
    while (i <= 10) {
        System.out.println(i);
        i++;
    }

    // 5. 반복문과 배열 관계
    // 배열 : 순서에 따라 저장된 자료들을 index로 식별 (항상 0번부터)
    int[] ary = { 92, 80, 75 }; // JS 버전 -> let ary = [ 92, 80, 75 ]
    
    // 배열은 인덱스 0번부터 순차적으로 저장
    for (int index = 0; index <= ary.length - 1; index++){
        System.out.println(ary[index]);
    }

    // 향상된 for문: for( 타입명 변수명 : 배열명 ) { }
    for (int data : ary){
        System.out.println( data ); // 인덱스 없이 자료(요소) 추출
    }

    
}
}