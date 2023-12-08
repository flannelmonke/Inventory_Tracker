package ca.sheridan.najiahm.naji_ahmad_khalil_assignment4.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridan.najiahm.naji_ahmad_khalil_assignment4.model.Product;

@Repository
public class DatabaseAccess {
    @Autowired
    protected NamedParameterJdbcTemplate jdbc;
    //add product to db method
    public long addProducts(Product prod) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String insert= "INSERT INTO product_catalog (product_code, brand, unit_price, quantity) VALUES (:product_code, :product_brand, :price, :quantity);";
        
        namedParameters.addValue("product_code", prod.getProduct_code());
        namedParameters.addValue("product_brand", prod.getBrand());
        namedParameters.addValue("price", prod.getUnit_price());
        namedParameters.addValue("quantity", prod.getQuantity());
        
        int rowsAffected = jdbc.update(insert, namedParameters);
        
        return rowsAffected;
    }
    //select all method
    public List<Product> selectProducts(int threshhold, String brand) {
        MapSqlParameterSource namedParameters =
        new MapSqlParameterSource();
        String query = "SELECT * FROM product_catalog";
        if(threshhold != 0){
            query = "SELECT * FROM product_catalog WHERE quantity > :threshhold";
            namedParameters.addValue("threshhold", threshhold);
            System.out.println(query);
        }else if(brand != ""){
            query = "SELECT * FROM product_catalog WHERE brand = :brand";
            namedParameters.addValue("brand", brand);
        }
        List<Product> products_list = jdbc.query(query,
        namedParameters, new
        BeanPropertyRowMapper<Product>(Product.class));
        return products_list;
    }

    //delete method
    public long deleteProduct(int id){
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query ="DELETE FROM product_catalog WHERE id = :id";
        
        namedParameters.addValue("id", id);
        long rows_affected = jdbc.update(query, namedParameters);

        return rows_affected;
    }

    //Select row method
    public long update_row(int id, Product prod){
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        
        String query = "UPDATE product_catalog SET id = :id, product_code = :code , brand = :brand , quantity = :quantity , unit_price = :price WHERE id = :id";
        
        namedParameters.addValue("id", id);
        namedParameters.addValue("code", prod.getProduct_code());
        namedParameters.addValue("brand", prod.getBrand());
        namedParameters.addValue("quantity", prod.getQuantity());
        namedParameters.addValue("price", prod.getUnit_price());        
        
        long rows_affected = jdbc.update(query, namedParameters);

        return rows_affected;
    }
}
