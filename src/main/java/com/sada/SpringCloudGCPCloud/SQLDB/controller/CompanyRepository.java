package com.sada.SpringCloudGCPCloud.SQLDB.controller;

import com.sada.SpringCloudGCPCloud.SQLDB.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company ,String > {
}
