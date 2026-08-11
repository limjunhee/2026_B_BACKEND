package Day09.종합예제2.model.dto;

public class WaitingDto {
    // DTO 구성하기 - 데이터 이동시 사용되는 객체?
    
    // [1] DB에서 사용할(CRUD) 객체들을 선언(private)
    private String phone_number;
    private int count;

    // [2] 기본 생성자, 전체 매개변수 생성자
    public WaitingDto(String phone_number, int count){
        this.phone_number = phone_number;
        this.count = count;
    }
    // [3] setter and getter, toString
    public String getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "WaitingDto [phone_number=" + phone_number + ", count=" + count + "]";
    }
}
