package com.hc.transaction;

import com.hc.transaction.config.ProductConfiguration;
import com.hc.transaction.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class TransactionApplication {

	public static void main(String[] args) throws Exception {
//		SpringApplication.run(TransactionApplication.class, args);
		ConfigurableApplicationContext context=new AnnotationConfigApplicationContext(ProductConfiguration.class);
		context.registerShutdownHook();
		ProductService productService = context.getBean("productService", ProductService.class);
		productService.saveProd();

		context.close();
	}

}
