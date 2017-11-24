package com.garyhu.mapper;

import com.garyhu.pojo.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: garyhu
 * @Since: 2017/11/23 0023.
 * @Decription:
 */
public interface ProductMapper {

    @Select("select * from product_")
    public List<Product> list();

    @Insert("insert into product_ values(null,#{name},#{price},#{category.id})")
    public void insert(Product product);

    @Select("select * from product_ where cid = #{id}")
    public List<Product> getProductById(int id);
}
