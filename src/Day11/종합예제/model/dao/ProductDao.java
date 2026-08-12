package Day11.종합예제.model.dao;

import java.util.ArrayList;


public class ProductDao implements IBaseDao {
    private ProductDao() {}
    private static final ProductDao instance = new ProductDao();
    public static ProductDao getInstance() { return instance; }

    private ArrayList<Object> productList = new ArrayList<>();

    // TODO 1: IBaseDao의 save() 메서드를 오버라이딩하여 productList에 저장하는 로직 작성
    // boolean save(Object obj);
    @Override
    public boolean save(Object productDto){
        // 1. controller로부터 저장할 정보 객체 받기
        // 2. 리스트에 저장하기
        productList.add(productDto);
        // 3. 성공반환
        return true;
    }
    
    
    // TODO 2: IBaseDao의 findAll() 메서드를 오버라이딩하여 productList를 반환하는 로직 작성
    // 1. IBaseDao의 추상 메서드 오버라이드 -> ArrayList<Object> findAll();
    @Override
    public ArrayList<Object> findAll(){
        return productList;
    }
}