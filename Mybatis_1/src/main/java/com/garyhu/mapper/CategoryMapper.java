package com.garyhu.mapper;

import com.garyhu.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: garyhu
 * @Since: 2017/11/24 0024.
 * @Decription:
 */
public interface CategoryMapper {

    @Select("select * from category_")
    @Results({
            @Result(property = "products",column = "id", javaType=List.class,many = @Many(select = "com.garyhu.mapper.ProductMapper.getProductById"))
    })
    List<Category> listCategory();
}
