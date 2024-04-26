package com.jparelation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jparelation.entity.org.Organization;

@Repository
public interface OrgRepository extends JpaRepository<Organization,Integer> {

}
