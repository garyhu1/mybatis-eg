package com.garyhu;

import com.garyhu.mapper.CategoryMapper;
import com.garyhu.mapper.ProductMapper;
import com.garyhu.pojo.Category;
import com.garyhu.pojo.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        String str = "mybatis-config.xml";
        InputStream input = Resources.getResourceAsStream(str);
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(input);
        SqlSession ss = ssf.openSession();

//        listByXML(ss);

        getProductById(ss);

//        addProduct(ss);
//        listByMapper(ss);

//        listCategory(ss);

//        addProduct2(ss);

//        listCategoryByMapper(ss);

//        getCategoryById(ss);

        ss.commit();
        ss.close();
    }

    public static  void addProduct(SqlSession ss){
        Category c = ss.selectOne("getCategory");
        Product p = new Product();
        p.setName("魅族");
        p.setPrice(1299.0f);
        p.setCategory(c);
        ss.insert("addProduct",p);
        listByXML(ss);
    }

    public static void addProduct2(SqlSession ss){
        ProductMapper mapper = ss.getMapper(ProductMapper.class);
        Category c = ss.selectOne("getCategory",2);
        Product p = new Product();
        p.setName("魅族");
        p.setPrice(1299.0f);
        p.setCategory(c);
        mapper.insert(p);
    }

    public static void listByXML(SqlSession ss){
        List<Product> listProduct = ss.selectList("listProduct");

        for(Product p : listProduct){
            System.out.println(p.getName()+" :: "+p.getCategory());
        }
    }

    public static void listCategoryByMapper(SqlSession ss){
        CategoryMapper mapper = ss.getMapper(CategoryMapper.class);
        List<Category> cs = mapper.listCategory();
        for(Category c : cs){
            System.out.println(c);
            List<Product> ps = c.getProducts();
            for(Product p : ps){
                System.out.println(p);
            }
        }
    }

    public static  void getProductById(SqlSession ss){
        Product p = ss.selectOne("getProductById",2);
        System.out.println(p.getName()+" :: "+p.getCategory());
    }

    public static void listByMapper(SqlSession ss){
        ProductMapper mapper = ss.getMapper(ProductMapper.class);
        List<Product> list = mapper.list();

        for(Product p : list){
            System.out.println(p.getName());
        }
    }

    public static void listCategory(SqlSession ss){
        List<Category> cs = ss.selectList("listCategory");

        for(Category c : cs){
            System.out.println(c);
            List<Product> ps = c.getProducts();
            for (Product p : ps){
                System.out.println(p);
            }
        }
    }

    public static void getCategoryById(SqlSession ss){
        Category c = ss.selectOne("getCategory", 2);

        List<Product> ps = c.getProducts();
        for(Product p : ps){
            System.out.println(p);
        }
    }
}
