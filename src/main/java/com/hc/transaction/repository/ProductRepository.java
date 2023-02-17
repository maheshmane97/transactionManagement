package com.hc.transaction.repository;

import com.hc.transaction.domain.Product;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    //No need to write @Transactional annotation here bcz from service class transaction propagation level is REQUIRED
    //,so it uses existing transaction which created already in service class
    //so if we write here @Transactional annotation then its useless bcz by default Propagation.REQUIRED
    //keeping @Transactional on the repo layer is not required, if service which calls the dao methods had already had existing transaction
    //@Transactional
    public void saveProduct(Product product){
        String sql="INSERT into Product VALUES(?,?)";
        Object[] args={product.getId(), product.getName()};
        jdbcTemplate.update(sql, args);

    }
}
