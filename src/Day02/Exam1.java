package Day02;

public class Exam1 {
    public static void main(String[] args) {

        // === 다형성 ===
        // [1] 자동 타입 변환
        byte bytevalue = 100;   // byte 타입에 bytevalue 변수명으로 100 리터럴 대입했다.
        short shortvalue = bytevalue; // byte 타입을 short 타입에 대입
        int intvalue = shortvalue; // short 타입을 int 타입에 대입
        long longvalue = intvalue; // int 타입을 long 타입에 대입
        float floatvalue = longvalue; // long 타입을 float 타입에 대입
        double doublevalue = floatvalue; // float를 double로 타입 변환하여 대입 -> 자동 타입 변환으로 자료( 100 )는 유지한 상태로 타입만 변경함

        // [1] 연산(계산) 중 자동 타입 변환 (묵시적) 
        // byte/short 계산 결과는 무조건 int
        // 두 항중 더 큰 타입으로 결과 타입을 반환
        byte b1 = 10; byte b2 = 20; short s1 = 30; int i1= 40; long l1 = 50L; float f1 = 50.2f; double d1 = 40.2;
        int result1 = b1 + b2; // byte + byte = int (127+127은 byte의 최대 크기를 넘어간다.)
        int result2 = b2 + s1; // byte + short = int
        int result3 = i1 + i1; // int + int = int
        long result4 = i1 + l1; //int + long = long(더 큰 타입으로 결과 타입 반환)
        float result5 = i1 + f1; // int + float = float
        double result6 = i1 + d1; // int + double = double


        // [2] 강제 타입 변환 (명시적) : byte <- short <- int <- long <- float <- double
        // 큰 자료형에서 작은 자료형으로 이동
        // 자료손실 발생 가능성이 존재한다.
        double dvalue = 3.14;
        // float fvalue = dvalue; // [불가능] -> 자료 앞에 소괄호를 치고 변화할 타입을 입력하면 강제 타입 변환시킴
        float fvalue = (float)dvalue;
        long lvalue = (long)fvalue;     // 3.14 -> 3 자료손실발생
        int ivalue = (int)lvalue;
        short svalue = (short)ivalue;
        byte bvalue = (byte)svalue;


    }
}
