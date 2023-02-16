package com.hc.transaction.service;

import com.hc.transaction.domain.Product;
import com.hc.transaction.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//for uncheckedException or RuntimeException Transaction rollBack method executed by default
//For CheckedException rollBack method not executed by default
//For this we need to right @Transactional(rollBackFor= Exception.class)
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Transactional(rollbackFor = Exception.class)
    public void saveProd() throws Exception {
        for (int i=1;i<=10;i++){
            Product product=new Product();
            product.setId(i);
            product.setName("Test No : "+i);
            productRepository.saveProduct(product);
            System.out.println("Product Inserted..##########"+i);
            if(i==5){
                throw new Exception(
                        "Something happen..!"
                );
            }
        }
    }
}
