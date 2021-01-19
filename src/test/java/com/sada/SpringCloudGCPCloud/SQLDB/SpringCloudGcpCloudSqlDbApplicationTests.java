package com.sada.SpringCloudGCPCloud.SQLDB;

import com.sada.SpringCloudGCPCloud.SQLDB.model.Product;
import com.sada.SpringCloudGCPCloud.SQLDB.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringCloudGcpCloudSqlDbApplicationTests {
	@Autowired
	public ProductRepository productRepository;


	@Test
	void contextLoads() {
	}
	@Test
	public void testProduct(){
		List<Product> a=productRepository.findAll();
		for(Product product : a){
			//System.out.println(product.getId());
			System.out.println("Tesla Model: "+ product.getName());
			System.out.println("Tesla Price: "+ product.getPrice());
			System.out.println("Warehouse:   "+   product.getWarehouse());
			System.out.println("-------------------------------------");
		}

	}

}
