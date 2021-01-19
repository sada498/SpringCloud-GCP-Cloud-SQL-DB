package com.sada.SpringCloudGCPCloud.SQLDB.repository;


import com.sada.SpringCloudGCPCloud.SQLDB.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,String> {
@Query(value = "select * from product where stock='67'",nativeQuery = true)
    List<Product> findByStock();
   }
