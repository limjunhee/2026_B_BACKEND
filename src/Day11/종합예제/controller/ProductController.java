package Day11.종합예제.controller;

import java.util.ArrayList;

import Day11.종합예제.model.dao.IBaseDao;
import Day11.종합예제.model.dao.ProductDao;
import Day11.종합예제.model.dto.ProductDto;

public class ProductController {
    private ProductController() {}
    private static final ProductController instance = new ProductController();
    public static ProductController getInstance() { return instance; }

    private IBaseDao ib = ProductDao.getInstance();

    // TODO 1: productDto 전달받아 DAO의 save()를 호출하고 결과 반환
    public boolean save(ProductDto productDto) {
        Object obj1 = (Object)productDto;
        boolean result = ib.save(obj1);
        return result;
    }

    // TODO 2: DAO의 findAll() 호출하여 결과를 받고 반환
    // 제품 전체 조회 컨트롤러
    public ArrayList<ProductDto> findAll() {
        // <ProductDto> -> <Object> 업캐스팅?
        // ㄴㄴ 다운캐스팅 <Object> -> <ProductDto>
        
        // Object의 하위 타입(ProductDto)의 배열을 하나 더 만들어서 그걸 전달한다.
        ArrayList<Object> list = ib.findAll();
        ArrayList<ProductDto> result = new ArrayList<>();
        for(Object item : list){
            result.add((ProductDto)item);
        }
        return result;
    }
}