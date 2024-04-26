package com.jparelation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jparelation.entity.dto.UpdateOrg;
import com.jparelation.entity.org.Company;
import com.jparelation.entity.org.Organization;
import com.jparelation.repository.CompanyRepository;
import com.jparelation.repository.OrgRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrgService {
	
	@Autowired
	OrgRepository orgRepository;
	
	@Autowired
	CompanyRepository comRepository;
	
	public void insertOrg(Organization org) {
		Organization orgn=new Organization();
		orgn.setOrgName(org.getOrgName());
		List<Company> comList=new ArrayList();
		for(Company company:org.getCompany()) {
			Company com=new Company();
			com.setCompanyName(company.getCompanyName());
			com.setCompanyType(company.getCompanyType());
			com.setOrg(orgn);
			comRepository.save(com);
			
		}
	}
	
	public Optional<Organization> getOrgById(int id) {
		Optional<Organization> org=orgRepository.findById(id);
		return org;
	}
	
	public void updateOrg(UpdateOrg updateOrg,int id) {
			orgRepository.findById(id).map(update->{
			update.setOrgId(id);
			update.setOrgName(updateOrg.getName());
			return orgRepository.save(update);
			
		}).orElseThrow(()->{
			
			return new EntityNotFoundException("No data Found");
		});
		
	}
	
	
}
