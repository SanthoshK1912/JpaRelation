package com.jparelation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jparelation.entity.org.Company;

public interface CompanyRepository extends JpaRepository<Company,Integer> {

}
