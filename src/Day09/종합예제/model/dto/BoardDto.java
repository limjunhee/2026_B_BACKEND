package Day09.종합예제.model.dto;

public class BoardDto {
    // DTO : 데이터 이동 객체 -> JAVA는 저장소가 아니기 때문에 사용
    // 데이터베이스를 저장소로 사용
    // 1. 데이터베이스에서 (CRUD) 사용할 자료들을 멤버변수로 구성
    private String content;
    private String writer;


    // 2. 기본생성자, 전체매개변수생성자
    public BoardDto(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }


    // 3. getter , setter , toString
    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }


    public String getWriter() {
        return writer;
    }


    public void setWriter(String writer) {
        this.writer = writer;
    }


    @Override
    public String toString() {
        return "BoardDto [content=" + content + ", writer=" + writer + "]";
    }

}
