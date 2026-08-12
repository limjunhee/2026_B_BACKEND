package Day11.종합예제.model.dao;

import java.util.ArrayList;

public class ProductDao implements IBaseDao {
    private ProductDao() {}
    private static final ProductDao instance = new ProductDao();
    public static ProductDao getInstance() { return instance; }

    private ArrayList<Object> productList = new ArrayList<>();

    // TODO 1: IBaseDao의 save() 메서드를 오버라이딩하여 productList에 저장하는 로직 작성

    // TODO 2: IBaseDao의 findAll() 메서드를 오버라이딩하여 productList를 반환하는 로직 작성

}