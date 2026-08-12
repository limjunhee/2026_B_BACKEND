package Day11;

public interface Keyboard {
    // 폴더 -> new java file -> interface 생성
    // 1. 상수(초기값 필수)
        public static final String info = "인텔";
        String date =  "2026-08-12";

    // 2. 추상메소드, 선언부 생략
        public abstract void aKey();
        int bKey( int x );
}

// 인터페이스는 규칙만 정하는 것(규격)


