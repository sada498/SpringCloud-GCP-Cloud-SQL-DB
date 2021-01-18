package com.sada.SpringCloudGCPCloud.SQLDB;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends CrudRepository<Product,String> {
}
