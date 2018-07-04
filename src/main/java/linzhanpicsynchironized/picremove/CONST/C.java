package linzhanpicsynchironized.picremove.CONST;

//import org.springframework.beans.factory.annotation.Autowired;

import linzhanpicsynchironized.picremove.dao.javaMapper.A001TongYongMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@Component
public class C {
    @Autowired
    public A001TongYongMapper a001TongYongMapper;
}
